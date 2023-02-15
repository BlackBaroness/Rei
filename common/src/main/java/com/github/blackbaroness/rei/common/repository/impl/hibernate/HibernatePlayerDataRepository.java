package com.github.blackbaroness.rei.common.repository.impl.hibernate;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import com.github.blackbaroness.rei.common.repository.PlayerDataRepository;
import com.github.blackbaroness.rei.common.repository.exception.InvalidPlayerDataException;
import com.github.blackbaroness.rei.common.repository.exception.RepositoryException;
import org.checkerframework.checker.index.qual.NonNegative;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public abstract class HibernatePlayerDataRepository implements PlayerDataRepository {

    @Override
    public PlayerData create(String nickname, UUID uuid) throws RepositoryException {
        HibernatePlayerData playerData = new HibernatePlayerData(nickname, uuid);
        write((session, transaction) -> session.persist(playerData));
        return playerData;
    }

    @Override
    public PlayerData merge(PlayerData playerData) throws RepositoryException {
        final var entity = validateEntity(playerData);

        AtomicReference<HibernatePlayerData> result = new AtomicReference<>();
        write((session, transaction) -> result.set(session.merge(entity)));
        return result.get();
    }

    @Override
    public void refresh(PlayerData playerData) throws RepositoryException {
        final var entity = validateEntity(playerData);

        read(session -> {
            session.refresh(entity);
            return entity;
        });
    }

    @Override
    public void delete(PlayerData playerData) throws RepositoryException {
        final var entity = validateEntity(playerData);
        write((session, transaction) -> session.remove(entity));
    }

    @SuppressWarnings("return")
    @Override
    public @NonNegative long ping() throws RepositoryException {
        final long startTime = System.currentTimeMillis();
        read(session -> session.createNativeQuery("SELECT 1", Integer.class).getSingleResult());
        return System.currentTimeMillis() - startTime;
    }

    @Override
    public Optional<PlayerData> findByNickname(String nickname) throws RepositoryException {
        return Optional.ofNullable(read(session -> session.get(HibernatePlayerData.class, nickname)));
    }

    @Override
    public Optional<PlayerData> findByUuid(UUID uuid) throws RepositoryException {
        return Optional.ofNullable(read(session -> {
            var builder = session.getCriteriaBuilder();
            var query = builder.createQuery(HibernatePlayerData.class);
            var root = query.from(HibernatePlayerData.class);

            return session.createQuery(query
                .select(root)
                .where(builder.equal(root.get("uuid"), uuid))
            ).setMaxResults(1).getSingleResultOrNull();
        }));
    }

    @Override
    public Collection<HibernatePlayerData> findAllByUuid(UUID uuid) throws RepositoryException {
        return read(session -> {
            var builder = session.getCriteriaBuilder();
            var query = builder.createQuery(HibernatePlayerData.class);
            var root = query.from(HibernatePlayerData.class);

            return session.createQuery(query
                .select(root)
                .where(builder.equal(root.get("uuid"), uuid))
            ).list();
        });
    }

    @Override
    public Optional<PlayerData> findByRegistrationDateBetween(Date from, Date to) throws RepositoryException {
        return Optional.ofNullable(read(session -> {
            var builder = session.getCriteriaBuilder();
            var query = builder.createQuery(HibernatePlayerData.class);
            var root = query.from(HibernatePlayerData.class);

            return session.createQuery(query
                .select(root)
                .where(builder.between(root.get("registrationDate"), from, to))
            ).setMaxResults(1).getSingleResultOrNull();
        }));
    }

    @Override
    public Collection<HibernatePlayerData> findAllByRegistrationDateBetween(Date from, Date to) throws RepositoryException {
        return read(session -> {
            var builder = session.getCriteriaBuilder();
            var query = builder.createQuery(HibernatePlayerData.class);
            var root = query.from(HibernatePlayerData.class);

            return session.createQuery(query
                .select(root)
                .where(builder.between(root.get("registrationDate"), from, to))
            ).list();
        });
    }

    protected abstract Session requestSession() throws RepositoryException;

    protected HibernatePlayerData validateEntity(PlayerData playerData) throws RepositoryException {
        if (playerData instanceof HibernatePlayerData hibernatePlayerData) {
            return hibernatePlayerData;
        } else {
            throw new InvalidPlayerDataException("PlayerData must be an instance of HibernatePlayerData");
        }
    }

    protected <T> T read(ReadInstructions<T> readInstructions) throws RepositoryException {
        try (Session session = requestSession()) {
            return readInstructions.read(session);
        } catch (Throwable e) {
            throw new RepositoryException(e);
        }
    }

    protected void write(WriteInstructions writeInstructions) throws RepositoryException {
        Transaction transaction = null;
        try (Session session = requestSession()) {
            transaction = session.beginTransaction();
            writeInstructions.write(session, transaction);
            transaction.commit();
        } catch (Throwable e) {
            if (transaction != null) transaction.rollback();
            throw new RepositoryException(e);
        }
    }


    @FunctionalInterface
    interface ReadInstructions<T> {
        T read(Session session) throws Throwable;
    }

    @FunctionalInterface
    interface WriteInstructions {
        void write(Session session, Transaction transaction) throws Throwable;
    }
}

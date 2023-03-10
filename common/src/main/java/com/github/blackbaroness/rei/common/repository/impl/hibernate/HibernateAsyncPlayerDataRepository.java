package com.github.blackbaroness.rei.common.repository.impl.hibernate;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import com.github.blackbaroness.rei.common.repository.AsyncPlayerDataRepository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Supplier;

public abstract class HibernateAsyncPlayerDataRepository extends HibernatePlayerDataRepository implements AsyncPlayerDataRepository {

    @Override
    public CompletableFuture<PlayerData> createAsync(String nickname, UUID uuid) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> create(nickname, uuid)));
    }

    @Override
    public CompletableFuture<PlayerData> mergeAsync(PlayerData playerData) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> merge(playerData)));
    }

    @Override
    public CompletableFuture<Void> refreshAsync(PlayerData playerData) {
        return CompletableFuture.runAsync(rethrowRunnable(() -> refresh(playerData)));
    }

    @Override
    public CompletableFuture<Void> deleteAsync(PlayerData playerData) {
        return CompletableFuture.runAsync(rethrowRunnable(() -> delete(playerData)));
    }

    @Override
    public CompletableFuture<Long> pingAsync() {
        return CompletableFuture.supplyAsync(rethrowSupplier(this::ping));
    }

    @Override
    public CompletableFuture<Optional<PlayerData>> findByNicknameAsync(String nickname) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> findByNickname(nickname)));
    }

    @Override
    public CompletableFuture<Optional<PlayerData>> findByUuidAsync(UUID uuid) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> findByUuid(uuid)));
    }

    @Override
    public CompletableFuture<Collection<? extends PlayerData>> findAllByUuidAsync(UUID uuid) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> findAllByUuid(uuid)));
    }

    @Override
    public CompletableFuture<Optional<PlayerData>> findByRegistrationDateBetweenAsync(Date from, Date to) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> findByRegistrationDateBetween(from, to)));
    }

    @Override
    public CompletableFuture<Collection<? extends PlayerData>> findAllByRegistrationDateBetweenAsync(Date from, Date to) {
        return CompletableFuture.supplyAsync(rethrowSupplier(() -> findAllByRegistrationDateBetween(from, to)));
    }

    private Runnable rethrowRunnable(ThrowingRunnable runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (Throwable e) {
                throw new CompletionException(e);
            }
        };
    }

    private <T> Supplier<T> rethrowSupplier(ThrowingSupplier<T> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (Throwable e) {
                throw new CompletionException(e);
            }
        };
    }

    protected interface ThrowingSupplier<T> {
        T get() throws Throwable;
    }

    protected interface ThrowingRunnable {
        void run() throws Throwable;
    }
}

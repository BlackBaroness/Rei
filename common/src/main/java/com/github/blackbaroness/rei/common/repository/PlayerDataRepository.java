package com.github.blackbaroness.rei.common.repository;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import com.github.blackbaroness.rei.common.repository.exception.RepositoryException;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDataRepository {

    void openConnection() throws RepositoryException;

    void closeConnection() throws RepositoryException;

    @Pure
    String name();

    PlayerData create(String nickname, UUID uuid) throws RepositoryException;

    PlayerData merge(PlayerData playerData) throws RepositoryException;

    void refresh(PlayerData playerData) throws RepositoryException;

    void delete(PlayerData playerData) throws RepositoryException;

    @SideEffectFree
    @NonNegative long ping() throws RepositoryException;

    @SideEffectFree
    Optional<PlayerData> findByNickname(String nickname) throws RepositoryException;

    @SideEffectFree
    Optional<PlayerData> findByUuid(UUID uuid) throws RepositoryException;

    @SideEffectFree
    Collection<? extends PlayerData> findAllByUuid(UUID uuid) throws RepositoryException;

    @SideEffectFree
    Optional<PlayerData> findByRegistrationDateBetween(Date from, Date to) throws RepositoryException;

    @SideEffectFree
    Collection<? extends PlayerData> findAllByRegistrationDateBetween(Date from, Date to) throws RepositoryException;

}

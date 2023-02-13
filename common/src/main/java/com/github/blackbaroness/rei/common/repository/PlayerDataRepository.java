package com.github.blackbaroness.rei.common.repository;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PlayerDataRepository {

    @Pure
    String name();

    ///////////////////////////////////////////////////////////////////////////
    // Ping
    ///////////////////////////////////////////////////////////////////////////

    @SideEffectFree
    @NonNegative long ping() throws Exception;

    @SideEffectFree
    CompletableFuture<Long> pingAsync();

    ///////////////////////////////////////////////////////////////////////////
    // Nickname
    ///////////////////////////////////////////////////////////////////////////

    @SideEffectFree
    Optional<PlayerData> findByNickname(String nickname);

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findByNicknameAsync(String nickname);

    ///////////////////////////////////////////////////////////////////////////
    // UUID
    ///////////////////////////////////////////////////////////////////////////

    @SideEffectFree
    Optional<PlayerData> findByUuid(UUID uuid);

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findByUuidAsync(UUID uuid);

    @SideEffectFree
    Collection<PlayerData> findAllByUuid(UUID uuid);

    @SideEffectFree
    CompletableFuture<Collection<PlayerData>> findAllByUuidAsync(UUID uuid);

    ///////////////////////////////////////////////////////////////////////////
    // Registration date
    ///////////////////////////////////////////////////////////////////////////

    @SideEffectFree
    Optional<PlayerData> findByRegistrationDateBetween(Date from, Date to);

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findByRegistrationDateBetweenAsync(Date from, Date to);

    @SideEffectFree
    Optional<PlayerData> findAllByRegistrationDateBetween(Date from, Date to);

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findAllByRegistrationDateBetweenAsync(Date from, Date to);


}

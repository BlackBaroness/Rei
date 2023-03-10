package com.github.blackbaroness.rei.common.repository;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface AsyncPlayerDataRepository extends PlayerDataRepository {

    CompletableFuture<PlayerData> createAsync(String nickname, UUID uuid);

    CompletableFuture<PlayerData> mergeAsync(PlayerData playerData);

    CompletableFuture<Void> refreshAsync(PlayerData playerData);

    CompletableFuture<Void> deleteAsync(PlayerData playerData);

    @SideEffectFree
    CompletableFuture<Long> pingAsync();

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findByNicknameAsync(String nickname);

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findByUuidAsync(UUID uuid);

    @SideEffectFree
    CompletableFuture<Collection<? extends PlayerData>> findAllByUuidAsync(UUID uuid);

    @SideEffectFree
    CompletableFuture<Optional<PlayerData>> findByRegistrationDateBetweenAsync(Date from, Date to);

    @SideEffectFree
    CompletableFuture<Collection<? extends PlayerData>> findAllByRegistrationDateBetweenAsync(Date from, Date to);
}

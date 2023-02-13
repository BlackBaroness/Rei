package com.github.blackbaroness.rei.common.repository;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;
import java.util.concurrent.Future;

public interface PlayerDataRepository {

    @NonNull String name();

    long ping();

    @NonNull Future<Long> pingAsync();

    @NonNull Future<PlayerData> byUuid(@NonNull UUID uuid);

    @NonNull Future<PlayerData> byNickname(@NonNull UUID uuid);


}

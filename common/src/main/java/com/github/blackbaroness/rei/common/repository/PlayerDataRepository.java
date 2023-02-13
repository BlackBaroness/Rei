package com.github.blackbaroness.rei.common.repository;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;
import java.util.concurrent.Future;

public interface PlayerDataRepository {

    String name();

    @NonNegative long ping() throws Exception;

    Future<Long> pingAsync();

    Future<PlayerData> byUuid(@NonNull UUID uuid);

    Future<PlayerData> byNickname(@NonNull UUID uuid);


}

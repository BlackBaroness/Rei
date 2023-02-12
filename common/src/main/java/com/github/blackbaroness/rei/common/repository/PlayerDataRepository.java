package com.github.blackbaroness.rei.common.repository;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import lombok.NonNull;
import org.checkerframework.common.value.qual.IntRangeFromNonNegative;
import org.jetbrains.annotations.Contract;

import java.util.UUID;
import java.util.concurrent.Future;

public interface PlayerDataRepository {

    @Contract(pure = true)
    @NonNull String name();

    @Contract(pure = true)
    long ping();

    @Contract(pure = true)
    @NonNull Future<Long> pingAsync();

    @Contract(pure = true)
    @NonNull Future<PlayerData> byUuid(@NonNull UUID uuid);

    @Contract(pure = true)
    @NonNull Future<PlayerData> byNickname(@NonNull UUID uuid);


}

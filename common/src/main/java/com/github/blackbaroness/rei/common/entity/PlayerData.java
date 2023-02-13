package com.github.blackbaroness.rei.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

@Getter
@Entity
public class PlayerData {

    private @Nullable UUID uuid;

    @Id
    private @Nullable String nickname;


}

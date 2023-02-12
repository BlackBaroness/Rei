package com.github.blackbaroness.rei.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
public class PlayerData {

    private UUID uuid;

    @Id
    private String nickname;


}

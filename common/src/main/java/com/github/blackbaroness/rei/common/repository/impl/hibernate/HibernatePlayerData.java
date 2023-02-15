package com.github.blackbaroness.rei.common.repository.impl.hibernate;

import com.github.blackbaroness.rei.common.entity.PlayerData;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rei_players")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuppressWarnings("initialization.fields.uninitialized")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HibernatePlayerData implements PlayerData {

    @Id
    private String nickname;
    private UUID uuid;
    String password;
    Date registrationDate;

    public HibernatePlayerData(String nickname, UUID uuid) {
        this.nickname = nickname;
        this.uuid = uuid;
    }

    @Override
    public String nickname() {
        return nickname;
    }

    @Override
    public UUID uuid() {
        return uuid;
    }

    @Override
    public Date registrationDate() {
        return registrationDate;
    }

    @Override
    public void registrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public void password(String password) {
        this.password = password;
    }
}

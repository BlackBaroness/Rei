package com.github.blackbaroness.rei.common.entity;

import com.github.blackbaroness.rei.common.repository.exception.RepositoryException;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.Date;
import java.util.UUID;

public interface PlayerData {

    @Pure
    String nickname();

    @Pure
    UUID uuid();

    @SideEffectFree
    Date registrationDate();

    void registrationDate(Date registrationDate);

    @SideEffectFree
    String password();

    void password(String password);
}

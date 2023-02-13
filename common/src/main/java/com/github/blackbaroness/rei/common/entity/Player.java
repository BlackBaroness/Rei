package com.github.blackbaroness.rei.common.entity;

import com.github.blackbaroness.rei.common.view.Title;
import org.checkerframework.checker.i18n.qual.LocalizableKey;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.Locale;
import java.util.UUID;

public interface Player {

    @SideEffectFree
    boolean online();

    @Pure
    String nick();

    @Pure
    UUID uuid();

    @SideEffectFree
    Locale locale();

    void sendMessage(String message);

    void sendMessageRaw(String message);

    void sendMessageLocalized(@LocalizableKey String key, Object... args);

    void sendTitle(Title title);

    void sendTitleRaw(Title title);

    void sendTitleLocalized(Title title);

    void kick(String reason);


}

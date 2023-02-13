package com.github.blackbaroness.rei.common.entity;

import com.github.blackbaroness.rei.common.view.Title;
import lombok.NonNull;

import java.util.Locale;
import java.util.UUID;

public interface Player {

    boolean online();

    @NonNull String nick();

    @NonNull UUID uuid();

    @NonNull Locale locale();

    void sendMessage(@NonNull String message);

    void sendMessageRaw(@NonNull String message);

    void sendMessageLocalized(@NonNull String key, @NonNull Object... args);

    void sendTitle(@NonNull Title title);

    void sendTitleRaw(@NonNull Title title);

    void sendTitleLocalized(@NonNull Title title);

    void kick(@NonNull String reason);


}

package com.github.blackbaroness.rei.common.entity;

import com.github.blackbaroness.rei.common.view.Title;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;

import java.util.Locale;
import java.util.UUID;

public interface Player {

    @Contract(pure = true)
    boolean online();

    @Contract(pure = true)
    @NonNull String nick();

    @Contract(pure = true)
    @NonNull UUID uuid();

    @Contract(pure = true)
    @NonNull Locale locale();

    void sendMessage(@NonNull String message);

    void sendMessageRaw(@NonNull String message);

    void sendMessageLocalized(@NonNull @Nls String key, @NonNull Object... args);

    void sendTitle(@NonNull Title title);

    void sendTitleRaw(@NonNull Title title);

    void sendTitleLocalized(@NonNull Title title);

    void kick(@NonNull String reason);


}

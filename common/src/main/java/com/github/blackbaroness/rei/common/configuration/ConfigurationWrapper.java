package com.github.blackbaroness.rei.common.configuration;

import lombok.NonNull;
import org.jetbrains.annotations.Contract;

public interface ConfigurationWrapper<T> {

    @Contract(pure = true)
    @NonNull T get();

    void reload() throws Throwable;
}

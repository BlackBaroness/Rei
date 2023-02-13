package com.github.blackbaroness.rei.common.configuration;

import lombok.NonNull;

public interface ConfigurationWrapper<T> {

    @NonNull T get();

    void reload() throws Throwable;
}

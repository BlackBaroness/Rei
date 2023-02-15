package com.github.blackbaroness.rei.common.configuration;

import lombok.NonNull;

public interface ConfigurationWrapper<T extends Configuration> {

    @NonNull T get();

    void reload() throws Throwable;
}

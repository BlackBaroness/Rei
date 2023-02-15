package com.github.blackbaroness.rei.test.common.configuration;

import com.github.blackbaroness.rei.common.configuration.Configuration;
import com.github.blackbaroness.rei.test.common.TestHelper;
import org.junit.jupiter.api.Test;
import space.arim.dazzleconf.ConfigurationOptions;
import space.arim.dazzleconf.error.InvalidConfigException;
import space.arim.dazzleconf.ext.snakeyaml.CommentMode;
import space.arim.dazzleconf.ext.snakeyaml.SnakeYamlConfigurationFactory;
import space.arim.dazzleconf.ext.snakeyaml.SnakeYamlOptions;
import space.arim.dazzleconf.helper.ConfigurationHelper;

import java.io.IOException;
import java.nio.file.Path;

public class ConfigurationCompileTest {

    @SuppressWarnings({"dereference.of.nullable", "argument"})
    @Test
    void check_is_configuration_class_can_be_parsed() throws IOException, InvalidConfigException {
        final Path tempFile = TestHelper.tempPathFile();

        final Path dir = tempFile.getParent();
        final String fileName = tempFile.getFileName().toString();

        new ConfigurationHelper<>(dir, fileName, SnakeYamlConfigurationFactory.create(
            Configuration.class,
            ConfigurationOptions.defaults(),
            new SnakeYamlOptions.Builder()
                .commentMode(CommentMode.fullComments())
                .build()
        )).reloadConfigData();
    }
}

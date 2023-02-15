package com.github.blackbaroness.rei.test.common;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("argument")
@UtilityClass
public class TestHelper {

    public Path tempPathFile() throws IOException {
        return Files.createTempFile(null, null);
    }

    public Path tempPathDir() throws IOException {
        return Files.createTempDirectory(null);
    }
}

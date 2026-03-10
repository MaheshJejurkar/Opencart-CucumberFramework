package com.abc;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationManager {
    private static Properties properties;

    private ConfigurationManager() {
    }

    public static Properties getProperties() throws Exception {
        try (FileReader file = new FileReader(
                Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "global.properties").toFile())) {
            properties = new Properties();
            properties.load(file);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load global.properties configuration file", e);
        }
    }
}

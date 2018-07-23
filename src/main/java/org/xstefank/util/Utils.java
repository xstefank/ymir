package org.xstefank.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.xstefank.model.DependenciesYaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Utils {

    public static DependenciesYaml readDependenciesConfig(String filePath) throws IOException {
        File configFile = Paths.get(filePath).toFile();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(configFile, DependenciesYaml.class);
    }
}

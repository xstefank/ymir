package org.xstefank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.xstefank.maven.MavenBOMGenerator;
import org.xstefank.model.DependenciesYaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        DependenciesYaml yaml = readDependenciesConfig();
        
        MavenBOMGenerator mavenBOMGenerator = new MavenBOMGenerator();
        String result = mavenBOMGenerator.generate(yaml);
        System.out.println(result);
        

    }

    private static DependenciesYaml readDependenciesConfig() throws IOException {
        File configFile = Paths.get("src/test/resources/dependencies.yaml").toFile();

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(configFile, DependenciesYaml.class);
    }
}

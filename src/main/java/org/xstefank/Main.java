package org.xstefank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.xstefank.maven.MavenBOMGenerator;
import org.xstefank.model.DependenciesYaml;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DependenciesYaml yaml = readDependenciesConfig();
        
        MavenBOMGenerator mavenBOMGenerator = new MavenBOMGenerator();
        mavenBOMGenerator.generate(yaml, "target/bom-pom.xml");
        

    }

    private static DependenciesYaml readDependenciesConfig() throws IOException {
        File configFile = new File(Main.class.getClassLoader().getResource("dependencies.yaml").getFile());

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(configFile, DependenciesYaml.class);
    }
}

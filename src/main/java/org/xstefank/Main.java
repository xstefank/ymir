package org.xstefank;

import org.xstefank.maven.MavenBOMGenerator;
import org.xstefank.model.DependenciesYaml;

import java.io.IOException;

import static org.xstefank.util.Utils.readDependenciesConfig;

public class Main {

    public static void main(String[] args) throws IOException {
        DependenciesYaml yaml = readDependenciesConfig("src/test/resources/dependencies.yaml");
        
        MavenBOMGenerator mavenBOMGenerator = new MavenBOMGenerator();
        String result = mavenBOMGenerator.generate(yaml);
        System.out.println(result);
    }
}

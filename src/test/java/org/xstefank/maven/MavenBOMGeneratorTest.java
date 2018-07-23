package org.xstefank.maven;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Assert;
import org.junit.Test;
import org.xstefank.Main;
import org.xstefank.model.DependenciesYaml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.xstefank.util.Utils.readDependenciesConfig;

public class MavenBOMGeneratorTest {

    private MavenBOMGenerator generator = new MavenBOMGenerator();
    
    @Test
    public void testBOMGenerating() throws Exception {
        DependenciesYaml config = readDependenciesConfig("src/test/resources/dependencies.yaml");

        Path templatePath = Paths.get("src/test/resources/maven/bom-pom-sample.xml");
        String expected = new String(Files.readAllBytes(templatePath));

        Assert.assertEquals("Generated BOM file doesn't match expected format", expected, generator.generate(config));
    }

    
}

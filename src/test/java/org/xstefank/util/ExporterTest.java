package org.xstefank.util;

import org.junit.Assert;
import org.junit.Test;
import org.xstefank.maven.MavenBOMGenerator;
import org.xstefank.model.DependenciesYaml;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.xstefank.util.Utils.readDependenciesConfig;

public class ExporterTest {
    
    MavenBOMGenerator generator = new MavenBOMGenerator();
    
    @Test
    public void testExportToFile() throws Exception {
        DependenciesYaml config = readDependenciesConfig("src/test/resources/dependencies.yaml");
        
        File tempFile = File.createTempFile("temp-pom", ".pom");
        Exporter.exportToFile(tempFile.getAbsolutePath(), generator.generate(config));
        
        String expected = new String(Files.readAllBytes(Paths.get(tempFile.getAbsolutePath())));

        Assert.assertEquals("Generated BOM file doesn't match expected format", expected, generator.generate(config));
    }

}

package org.xstefank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.xstefank.model.DependenciesYaml;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File configFile = new File(Main.class.getClassLoader().getResource("dependencies.yaml").getFile());

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        DependenciesYaml yaml = mapper.readValue(configFile, DependenciesYaml.class);

        System.out.println(yaml.getDependencies().get(0).getGroupId());

    }
}

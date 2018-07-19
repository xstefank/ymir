package org.xstefank.maven;

import org.xstefank.model.DependenciesYaml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class MavenBOMGenerator {
    
    private PrintWriter writer;
    
    public void generate(DependenciesYaml config, String filePath) {
        Project project = new Project();
        project.setProperties(config.getVersions());
        
        File outputFile = Paths.get(filePath).toFile();
        JAXBContext jaxbContext = null;
        
        try {
            jaxbContext = JAXBContext.newInstance(Project.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            jaxbMarshaller.marshal(project, outputFile);
            jaxbMarshaller.marshal(project, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
    }
}

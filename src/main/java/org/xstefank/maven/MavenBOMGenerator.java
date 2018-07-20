package org.xstefank.maven;

import org.xstefank.model.DependenciesYaml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MavenBOMGenerator {
    
    private PrintWriter writer;
    
    public String generate(DependenciesYaml config) {
        Project project = new Project();
        project.setProperties(config.getVersions());
        
        JAXBContext jaxbContext = null;
        
        try {
            jaxbContext = JAXBContext.newInstance(Project.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

            OutputStream out = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(project, out);
            
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "";
    }
}

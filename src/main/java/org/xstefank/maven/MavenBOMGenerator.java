package org.xstefank.maven;

import org.xstefank.model.DependenciesYaml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MavenBOMGenerator {
    
    private PrintWriter writer;
    
    public String generate(DependenciesYaml config) {
        BOM bom = new BOM();
        
        bom.setGroupId(config.getGroupId());
        bom.setArtifactId(config.getArtifactId());
        bom.setVersion(config.getVersion());
        
        bom.setName(config.getName());
        bom.setDescription(config.getDescription());

        bom.setLicenses(config.getLicenses());
        
        bom.setParent(config.getParent());
        bom.setProperties(config.getVersions());
        
        JAXBContext jaxbContext = null;
        
        try {
            jaxbContext = JAXBContext.newInstance(BOM.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd");
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
            jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

            OutputStream out = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(bom, out);
            
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "";
    }
}

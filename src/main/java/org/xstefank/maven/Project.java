package org.xstefank.maven;

import org.xstefank.maven.map.PropertiesAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement
public class Project {

    @XmlAttribute(name = "xsi:schemaLocation", namespace="http://maven.apache.org/POM/4.0.0", required = true)
    private String schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd";
    
    @XmlElement
    private String modelVersion = "4.0.0";

    @XmlElement
    @XmlJavaTypeAdapter(PropertiesAdapter.class)
    private Map<String, String> properties;

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}

package org.xstefank.maven;

import org.xstefank.maven.map.PropertiesAdapter;
import org.xstefank.model.Dependency;
import org.xstefank.model.License;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "project")
public class BOM {

    @XmlAttribute
    private String xmlns = "http://maven.apache.org/POM/4.0.0";
    
    @XmlElement
    private String modelVersion = "4.0.0";
    
    @XmlElement
    private Dependency parent;
    
    @XmlElement
    private String groupId;
    
    @XmlElement
    private String artifactId;
    
    @XmlElement
    private String version;

    @XmlElement
    private String packaging = "pom";
    
    @XmlElement
    private String name;
    
    @XmlElement
    private String description;

    @XmlElementWrapper(name = "licenses")
    @XmlElement(name = "license")
    private List<License> licenses;

    @XmlElement
    @XmlJavaTypeAdapter(PropertiesAdapter.class)
    private Map<String, String> properties;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setParent(Dependency parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}

package org.xstefank.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Dependency extends GAV {

    @XmlElementWrapper(name = "exclusions")
    @XmlElement(name = "exclusion")
    private List<GA> exclusions;

    public void setExclusions(List<GA> exclusions) {
        this.exclusions = exclusions;
    }

    @Override
    public void setVersion(String version) {
        this.version = "${version." + version + "}";
    }
}

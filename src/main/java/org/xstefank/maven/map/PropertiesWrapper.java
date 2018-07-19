package org.xstefank.maven.map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlType
public class PropertiesWrapper {

    @XmlAnyElement
    private List<JAXBElement<String>> properties = new ArrayList<>();

    public void addProperty(JAXBElement<String> prop) {
        properties.add(prop);
    }

    public List<JAXBElement<String>> getProperties() {
        return Collections.unmodifiableList(properties);
    }
}

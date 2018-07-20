package org.xstefank.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "url", "distribution"})
public class License {
    
    private String name;
    private String url;
    private String distribution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }
}

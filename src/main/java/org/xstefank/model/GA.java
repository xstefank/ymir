package org.xstefank.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"groupId", "artifactId"})
public class GA {

    private String groupId;
    private String artifactId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
}

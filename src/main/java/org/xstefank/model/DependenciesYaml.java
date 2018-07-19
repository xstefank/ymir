package org.xstefank.model;

import java.util.List;
import java.util.Map;

public class DependenciesYaml {

    private Dependency parent;
    private Map<String, String> versions; 
    private List<Dependency> dependencies;

    public Dependency getParent() {
        return parent;
    }

    public void setParent(Dependency parent) {
        this.parent = parent;
    }

    public Map<String, String> getVersions() {
        return versions;
    }

    public void setVersions(Map<String, String> versions) {
        this.versions = versions;
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }
}

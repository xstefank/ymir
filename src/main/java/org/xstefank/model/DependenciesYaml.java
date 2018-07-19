package org.xstefank.model;

import java.util.List;
import java.util.Map;

public class DependenciesYaml {

    private Map<String, String> versions; 
    private List<Dependency> dependencies;

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

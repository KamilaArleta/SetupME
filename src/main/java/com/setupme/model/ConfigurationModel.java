package com.setupme.model;

import java.util.List;

public class ConfigurationModel {
    private String version;
    private List<ProgramModel> programs;

    public ConfigurationModel(String version, List<ProgramModel> programs) {
        this.version = version;
        this.programs = programs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ProgramModel> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramModel> programs) {
        this.programs = programs;
    }
}

package com.setupme.model;

public class ProgramModel {

    private String name;
    private String version;
    private String link;

    public ProgramModel() {
    }

    public ProgramModel(String name, String version, String link) {
        this.name = name;
        this.version = version;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ProgramModel{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

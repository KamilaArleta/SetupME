package com.setupme.model;

public class FileModel {
    private ConfigurationModel configuration;

    public FileModel() {
    }

    public FileModel(ConfigurationModel configuration) {
        this.configuration = configuration;
    }

    public ConfigurationModel getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConfigurationModel configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "configuration=" + configuration +
                '}';
    }
}

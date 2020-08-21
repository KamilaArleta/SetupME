package com.setupme.execution.manager;

import com.setupme.model.ProgramModel;

import java.net.MalformedURLException;
import java.net.URL;

public interface FileManager {
    boolean downloadFile(URL url, ProgramModel programModel) throws MalformedURLException;
}

package com.setupme.execution.manager;

import com.setupme.model.ProgramModel;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class LinuxFileManager implements FileManager{

    Logger LOG = Logger.getLogger(LinuxFileManager.class);

    @Override
    public boolean downloadFile(URL url, ProgramModel programModel) throws MalformedURLException {
        LOG.warn("Its not working yet");
        return false;
    }

}

package com.setupme.execution.manager;

import com.setupme.model.ProgramModel;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WindowsFileManager implements FileManager {

    Logger LOG = Logger.getLogger(WindowsFileManager.class);

    @Override
    public boolean downloadFile(URL url, ProgramModel programModel) throws MalformedURLException {
        LOG.warn("Im begining download program " + programModel.getName() + " " + programModel.getVersion() + " from link " + programModel.getLink());
        try {
            FileUtils.copyURLToFile(
                    new URL(programModel.getLink()),
                    new File(programModel.getName() + programModel.getVersion() + ".exe"),
                    10000,
                    10000
            );
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}

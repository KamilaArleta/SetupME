package com.setupme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.setupme.execution.manager.FileManager;
import com.setupme.execution.manager.LinuxFileManager;
import com.setupme.execution.manager.MacFileManager;
import com.setupme.execution.manager.WindowsFileManager;
import com.setupme.model.ConfigurationModel;
import com.setupme.model.FileModel;
import com.setupme.model.ProgramModel;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.kohsuke.args4j.OptionHandlerFilter.ALL;

public class Main {

    private FileManager fileManager = getFileManager();


    private Logger LOG = Logger.getLogger(Main.class);


    @Option(name = "-h", usage = "show help")
    private boolean showHelp;

    @Option(name = "-f", usage = "path to json to parse")
    private String jsonPath;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        new Main().doMain(args);
    }

    public void doMain(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            if (arguments.isEmpty()) {
                throw new CmdLineException(parser, "No argument is given");
            }
        } catch (CmdLineException e) {
            System.out.println(e.getMessage());
            System.out.println("java SampleMain [options...] arguments...");
            parser.printUsage(System.out);
            System.out.println();
            return;
        }
        if (showHelp == true) {
            System.out.println("Example: java com.setupme.Main" + parser.printExample(ALL));
        }
        if (jsonPath != null) {
            ObjectMapper mapper = new ObjectMapper();
            try (FileReader reader = new FileReader(ClassLoader.getSystemResource(jsonPath).getFile())) {
                FileModel configuration = mapper.readValue(reader, FileModel.class);
                for (ProgramModel programModel : configuration.getConfiguration().getPrograms()) {
                    //todo implement file manager method
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private FileManager getFileManager() {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            return new WindowsFileManager();
        }else if (osName.startsWith("Linux")){
            return new LinuxFileManager();
        }else {
            return new MacFileManager();
        }
    }
}

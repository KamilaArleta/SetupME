package com.setupme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.setupme.model.ConfigurationModel;
import com.setupme.model.FileModel;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.kohsuke.args4j.OptionHandlerFilter.ALL;

public class Main {
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
                System.out.println(configuration);
            }catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    }
}

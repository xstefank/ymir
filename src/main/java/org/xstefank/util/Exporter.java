package org.xstefank.util;

import org.jboss.logging.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exporter {

    private static final Logger log = Logger.getLogger(Exporter.class);
    
    public static void exportToFile(String file, String content) {
        Path filePath = Paths.get(file);

        try {
            Files.write(filePath, content.getBytes());
        } catch (IOException e) {
            log.error(e);
        }
    }
    
}

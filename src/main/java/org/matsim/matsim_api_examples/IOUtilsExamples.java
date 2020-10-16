package org.matsim.matsim_api_examples;

import org.apache.log4j.Logger;
import org.matsim.core.utils.io.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class IOUtilsExamples {

    private static Logger log = Logger.getLogger(IOUtilsExamples.class);

    public static void main(String[] args) throws IOException {

        // MATSim provides a helper class IOUtils to work with (gzipped) files.
        // It automatically (de)compresses gzipped files if the filename ends on .gz

        String filename = "output/ioutils_example.txt";
        String filenameGz = "output/ioutils_example.txt.gz";

        // Write data

        // Version 1 (using throws IOException)
        BufferedWriter writer = IOUtils.getBufferedWriter(filename);

        // write single line
        writer.write("Hello MATSim!");
        writer.flush();
        writer.close();

        // Version 2 (using try/catch)
        try (BufferedWriter writer2 = IOUtils.getBufferedWriter(filenameGz)) {

            // write single line
            writer2.write("Hello MATSim GZ!");
            writer2.flush();

        } catch (IOException e) {
            log.error("oops!", e);
        }

        // Read data

        // Version 1 (using throws IOException)
        // Create reader
        BufferedReader reader1 = IOUtils.getBufferedReader(filename);

        // read line at a time
        String line1 = reader1.readLine();

        // write out to console
        log.info(line1);


        // Version 2 (using try/catch)
        try (BufferedReader reader2 = IOUtils.getBufferedReader(filenameGz)) {

            // read line at a time
            String line2 = reader2.readLine();

            // write out to console
            log.info(line2);

        } catch (IOException e) {
            log.error("oops!", e);
        }

    }
}
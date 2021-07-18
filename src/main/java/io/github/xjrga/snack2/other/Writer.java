package io.github.xjrga.snack2.other;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public Writer() {
    }

    public static void writeToFile(String fileName, String fileContent) {
        new Thread(()
                -> {
            BufferedWriter writer = null;
            File file = new File("files/" + fileName);
            try {
                writer = new BufferedWriter(new FileWriter(file));
                writer.write(fileContent);
                writer.close();
            } catch (IOException e) {
                Log.getLog().start("files/exception.log");
                Log.getLog().logMessage(e.toString());
                Log.getLog().write();
                Log.getLog().close();
                e.printStackTrace();
            }
        }).start();
    }
}

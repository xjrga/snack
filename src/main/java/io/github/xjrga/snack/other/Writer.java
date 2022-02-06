package io.github.xjrga.snack.other;

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

            }
        }).start();
    }
}

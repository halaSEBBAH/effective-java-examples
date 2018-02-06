package org.effectivejava.examples.chapter02.item09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CloseResource {

    void oldSchool(String src, String dst) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(src));
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(dst));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            } finally {
                writer.close();
            }
        } finally {
            reader.close();
        }
    }

    void preferredWay(String src, String dst) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(src));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(dst))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        }
    }
}

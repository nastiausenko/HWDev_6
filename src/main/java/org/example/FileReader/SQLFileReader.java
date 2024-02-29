package org.example.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SQLFileReader {
    public String readSQLFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("SQL/" + filePath))) {
            reader.lines().forEach(stringBuilder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}

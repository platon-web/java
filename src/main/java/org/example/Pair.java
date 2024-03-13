package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static Pair<String, Integer> findLongestLine(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String longestLine = null;
        int maxLength = 0;
        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;
            if (line.length() > maxLength) {
                maxLength = line.length();
                longestLine = line;
            }
        }

        reader.close();

        if (longestLine != null) {
            return new Pair<>(longestLine, maxLength);
        } else {
            return null;
        }
    }
}


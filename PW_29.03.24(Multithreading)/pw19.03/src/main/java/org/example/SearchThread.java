package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SearchThread extends Thread {
    private String filePath;
    private String word;
    private boolean found;

    public SearchThread(String filePath, String word) {
        this.filePath = filePath;
        this.word = word;
        this.found = false;
    }

    public boolean isFound() {
        return found;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    found = true;
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

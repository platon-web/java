package org.example;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class FileProcess {
    public static void searchFilesAndMerge(String directoryPath, String searchWord) throws IOException {
        // Список файлів для злиття
        List<Path> filesToMerge = new ArrayList<>();

        // Пошук файлів, що містять задане слово
        Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(file -> {
                    try {
                        return new String(Files.readAllBytes(file)).contains(searchWord);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .forEach(filesToMerge::add);

        // Злиття файлів в один
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("merged_file.txt"))) {
            for (Path file : filesToMerge) {
                List<String> lines = Files.readAllLines(file);
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }

    // Метод для вирізання заборонених слів з файлу
    public static void processFile(String filePath, String forbiddenWordsFile) throws IOException {
        // Зчитування заборонених слів з файлу
        List<String> forbiddenWords = Files.readAllLines(Paths.get(forbiddenWordsFile));

        // Читання вмісту файлу
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Підрахунок кількості вирізаних слів
        AtomicInteger removedWordsCount = new AtomicInteger();

        // Вирізання заборонених слів з кожного рядка
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (String word : forbiddenWords) {
                line = line.replaceAll("\\b" + word + "\\b", "");
                removedWordsCount.addAndGet(line.split(word, -1).length - 1);
            }
            lines.set(i, line);
        }

        // Запис відредагованого вмісту назад в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }

        // Відображення статистики виконаних операцій
        System.out.println("Вирізано заборонених слів: " + removedWordsCount.get());
    }
}

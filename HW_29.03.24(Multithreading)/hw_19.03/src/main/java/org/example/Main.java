package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.example.FileProcess.processFile;
import static org.example.FileProcess.searchFilesAndMerge;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //task 1
//        int[] array = new int[10];
//
//        FillArrayThread fillArrayThread = new FillArrayThread(array);
//        SumThread sumThread = new SumThread(array);
//        AverageThread averageThread = new AverageThread(array);
//
//        fillArrayThread.start();
//        try {
//            fillArrayThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        sumThread.start();
//        averageThread.start();

        //task 2
//        String inputFile = "input.txt";
//        String primeOutputFile = "prime_numbers.txt";
//        String factorialOutputFile = "factorials.txt";
//
//        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(inputFile)))) {
//            for (int i = 0; i < 100; i++) {
//                writer.println((int) (Math.random() * 1000));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Перший потік: заповнення файлу випадковими числами...");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Файл заповнено!");
//            }
//        });
//        executor.submit(new PrimeNumbersThread(inputFile, primeOutputFile));
//        executor.submit(new FactorialThread(inputFile, factorialOutputFile));
//
//        executor.shutdown();
//        try {
//            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Всі потоки завершили роботу.");

        //task 3
//        String sourceDirectoryPath = "path/to/source/directory";
//        String destinationDirectoryPath = "path/to/destination/directory";
//
//        File sourceDirectory = new File(sourceDirectoryPath);
//        File destinationDirectory = new File(destinationDirectoryPath);
//
//        Thread copyThread = new Thread(() -> {
//            try {
//                copyDirectory(sourceDirectory.toPath(), destinationDirectory.toPath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        copyThread.start();
//
//        try {
//            copyThread.join();
//            System.out.println("Копіювання завершено!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //task 4
        System.out.println("Введіть шлях до директорії:");

        String directoryPath = scanner.nextLine();

        System.out.println("Введіть слово для пошуку:");
        String searchWord = scanner.nextLine();

        Thread searchThread = new Thread(() -> {
            try {
                searchFilesAndMerge(directoryPath, searchWord);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        Thread processThread = new Thread(() -> {
            try {
                searchThread.join();
                processFile("merged_file.txt", "forbidden_words.txt");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        searchThread.start();
        processThread.start();

        try {
            processThread.join();
            System.out.println("Операції завершено!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static void copyDirectory(Path sourceDir, Path targetDir) throws IOException {
        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir);
        }
        try {
            Files.walk(sourceDir).forEach(sourcePath -> {
                Path relativePath = sourceDir.relativize(sourcePath);
                Path targetPath = targetDir.resolve(relativePath);
                try {
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

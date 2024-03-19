package org.example;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task 1
        System.out.println("Введіть розмір масиву:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Введіть значення для масиву:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        MaxFinder maxFinder = new MaxFinder(array);
        MinFinder minFinder = new MinFinder(array);

        Thread maxThread = new Thread(maxFinder);
        Thread minThread = new Thread(minFinder);

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимальне значення: " + maxFinder.getMax());
        System.out.println("Мінімальне значення: " + minFinder.getMin());


        //task 2
        System.out.println("Введіть розмір масиву:");;
        System.out.println("Введіть значення для масиву:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        SumCalculator sumCalculator = new SumCalculator(array);
        AverageCalculator averageCalculator = new AverageCalculator(array);

        Thread sumThread = new Thread(sumCalculator);
        Thread averageThread = new Thread(averageCalculator);

        sumThread.start();
        averageThread.start();

        try {
            sumThread.join();
            averageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Сума елементів масиву: " + sumCalculator.getSum());
        System.out.println("Середнє арифметичне значення масиву: " + averageCalculator.getAverage());


        //task 3
        System.out.println("Введіть шлях до файлу:");
        String filePath = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            int[] array3 = new int[100];
            int index = 0;
            while (fileScanner.hasNextInt()) {
                array3[index++] = fileScanner.nextInt();
            }

            int[] actualArray = new int[index];
            System.arraycopy(array3, 0, actualArray, 0, index);

            EvenThread evenThread = new EvenThread(actualArray);
            OddThread oddThread = new OddThread(actualArray);

            evenThread.start();
            oddThread.start();

            evenThread.join();
            oddThread.join();

        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

        //task 4

        System.out.println("Введіть шлях до файлу:");

        System.out.println("Введіть слово для пошуку:");
        String word = scanner.nextLine();

        SearchThread searchThread = new SearchThread(filePath, word);
        searchThread.start();

        try {
            searchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (searchThread.isFound()) {
            System.out.println("Слово '" + word + "' знайдено у файлі.");
        } else {
            System.out.println("Слово '" + word + "' не знайдено у файлі.");
        }
    }

}
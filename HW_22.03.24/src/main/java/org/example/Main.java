package org.example;
import java.io.*;
import java.util.Scanner;
import static org.example.MassiveNumber.*;
import static org.example.Pair.findLongestLine;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //task 1
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введіть шлях до першого файлу:");
            String filePath1 = reader.readLine();
            System.out.println("Введіть шлях до другого файлу:");
            String filePath2 = reader.readLine();
            boolean linesMatch = compareFiles(filePath1, filePath2);
            if (linesMatch) {
                System.out.println("Рядки у файлів збігаються.");
            } else {
                System.out.println("Рядки у файлах не збігаються.");
            }
        } catch (IOException e) {
            System.out.println("Помилка введення/виведення: " + e.getMessage());
        }

      //  task2
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введіть шлях до файлу:");
            String filePath = reader.readLine();

            Pair<String, Integer> longestLineInfo = findLongestLine(filePath);

            if (longestLineInfo != null) {
                System.out.println("Довжина найбільшого рядка: " + longestLineInfo.getValue());
                System.out.println("Найбільший рядок: " + longestLineInfo.getKey());
            } else {
                System.out.println("Файл порожній.");
            }
        } catch (IOException e) {
            System.out.println("Помилка введення/виведення: " + e.getMessage());
        }
    //   task 3
        try {

            int[][] arrays = readArraysFromFile("D:\\Step\\Java\\practic\\number.txt");


            for (int i = 0; i < arrays.length; i++) {
                System.out.println("Масив " + (i + 1) + ":");
                printArray(arrays[i]);
                System.out.println("Максимум: " + findMax(arrays[i]));
                System.out.println("Мінімум: " + findMin(arrays[i]));
                System.out.println("Сума: " + findSum(arrays[i]));
                System.out.println();
            }

            int totalSum = findTotalSum(arrays);
            System.out.println("Загальна сума всіх масивів: " + totalSum);
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }

     //   task 4

        System.out.println("Введіть шлях до файлу:");
        String filePath = scanner.nextLine();
        System.out.println("Введіть масив цілих чисел (розділіть числа пробілами):");
        String input = scanner.nextLine();

        try {
            saveArrayToFile(filePath, input);

            System.out.println("Масив було успішно збережено у файлі.");
        } catch (IOException e) {
            System.out.println("Сталася помилка при збереженні масиву у файлі: " + e.getMessage());
        }

        //task 5
        System.out.println("Введіть шлях до файлу для завантаження / збереження списку співробітників:");
        String filename = scanner.nextLine();

        Corporation corporation = new Corporation(filename);
        corporation.loadEmployeesFromFile();

        corporation.addEmployee(new Employee("Петров", "Іван", 30));
        corporation.addEmployee(new Employee("Іванов", "Петро", 35));
        corporation.addEmployee(new Employee("Сидоров", "Василь", 28));

        System.out.println("Список співробітників:");
        for (Employee employee : corporation.getEmployees()) {
            System.out.println(employee);
        }

        corporation.saveEmployeesToFile();
        System.out.println("Список співробітників було збережено у файл.");

    }



    public static boolean compareFiles(String filePath1, String filePath2) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        int lineNumber = 1;
        boolean linesMatch = true;

        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null || !line1.equals(line2)) {
                System.out.println("Рядок " + lineNumber + ":");
                System.out.println("Файл 1: " + (line1 != null ? line1 : "[Кінець файлу]"));
                System.out.println("Файл 2: " + (line2 != null ? line2 : "[Кінець файлу]"));
                linesMatch = false;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNumber++;
        }

        reader1.close();
        reader2.close();

        return linesMatch;
    }

    public static void saveArrayToFile(String filePath, String input) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        String[] numbers = input.split("\\s+");


        for (String num : numbers) {
            writer.write(num + " ");
        }
        writer.newLine();


        for (String num : numbers) {
            int n = Integer.parseInt(num);
            if (n % 2 == 0) {
                writer.write(num + " ");
            }
        }
        writer.newLine();


        for (String num : numbers) {
            int n = Integer.parseInt(num);
            if (n % 2 != 0) {
                writer.write(num + " ");
            }
        }
        writer.newLine();

        for (int i = numbers.length - 1; i >= 0; i--) {
            writer.write(numbers[i] + " ");
        }

        writer.close();
    }
}
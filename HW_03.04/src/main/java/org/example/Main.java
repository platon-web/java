package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Device.*;
import static org.example.NumberStats.*;

public class Main {
    public static void main(String[] args) {
        //task 1
//        int[] numbers = generateRandomArray(100, -100, 100);
//
//        int positiveCount = countPositiveNumbers(numbers);
//
//        int negativeCount = countNegativeNumbers(numbers);
//
//        int twoDigitCount = countTwoDigitNumbers(numbers);
//
//        int palindromeCount = countPalindromes(numbers);
//
//        System.out.println("Кількість додатних чисел: " + positiveCount);
//        System.out.println("Кількість від'ємних чисел: " + negativeCount);
//        System.out.println("Кількість двозначних чисел: " + twoDigitCount);
//        System.out.println("Кількість дзеркальних чисел: " + palindromeCount);

        //task 2
//
//        List<String> products = new ArrayList<>();
//        products.add("Молоко");
//        products.add("Хліб");
//        products.add("Масло");
//        products.add("Яблука");
//        products.add("Молоко");
//        products.add("Картопля");
//        products.add("Сир");
//        products.add("Кавун");
//        products.add("Молоко");
//
//
//        System.out.println("Всі продукти: " + products);
//
//
//        List<String> shortNamedProducts = new ArrayList<>();
//        for (String product : products) {
//            if (product.length() < 5) {
//                shortNamedProducts.add(product);
//            }
//        }
//        System.out.println("Продукти з назвою менше п'яти символів: " + shortNamedProducts);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введіть назву продукту для пошуку: ");
//        String searchProduct = scanner.nextLine();
//        int count = 0;
//        for (String product : products) {
//            if (product.equalsIgnoreCase(searchProduct)) {
//                count++;
//            }
//        }
//        System.out.println("Продукт \"" + searchProduct + "\" зустрічається " + count + " разів.");
//
//        System.out.print("Введіть першу букву для пошуку: ");
//        String searchLetter = scanner.nextLine();
//        List<String> startsWithLetterProducts = new ArrayList<>();
//        for (String product : products) {
//            if (product.toLowerCase().startsWith(searchLetter.toLowerCase())) {
//                startsWithLetterProducts.add(product);
//            }
//        }
//        System.out.println("Продукти, що починаються на букву \"" + searchLetter + "\": " + startsWithLetterProducts);
//
//        List<String> milkProducts = new ArrayList<>();
//        for (String product : products) {
//            if (product.equalsIgnoreCase("Молоко")) {
//                milkProducts.add(product);
//            }
//        }
//        System.out.println("Продукти з категорії \"Молоко\": " + milkProducts);

        //task 3
//        List<Device> devices = new ArrayList<>();
//        devices.add(new Device("Smartphone", 2020, 999.99, "Black", "Mobile"));
//        devices.add(new Device("Laptop", 2019, 1499.99, "Silver", "Computer"));
//        devices.add(new Device("Smart TV", 2021, 799.99, "Black", "Television"));
//        devices.add(new Device("Tablet", 2020, 499.99, "White", "Mobile"));
//        devices.add(new Device("Desktop PC", 2018, 1999.99, "Black", "Computer"));
//
//        System.out.println("Усі пристрої:");
//        displayDevices(devices);
//
//        System.out.println("\nПристрої чорного кольору:");
//        displayDevicesByColor(devices, "Black");
//
//        System.out.println("\nПристрої випущені в 2020 році:");
//        displayDevicesByYear(devices, 2020);
//
//        System.out.println("\nПрилади дорожче $1000:");
//        displayDevicesMoreExpensiveThan(devices, 1000);
//
//        System.out.println("\nПрилади типу Mobile:");
//        displayDevicesByType(devices, "Mobile");
//
//        System.out.println("\nПрилади випущені в діапазоні від 2019 до 2021 року:");
//        displayDevicesByYearRange(devices, 2019, 2021);

        //task 4
        
    }
}

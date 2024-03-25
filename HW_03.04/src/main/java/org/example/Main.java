package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Device.*;
import static org.example.NumberStats.*;
import static org.example.Projector.*;

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
        List<Projector> projectors = new ArrayList<>();
        projectors.add(new Projector("Epson 3020", 2018, 899.99, "Epson"));
        projectors.add(new Projector("BenQ TK800", 2020, 1299.99, "BenQ"));
        projectors.add(new Projector("Optoma HD146X", 2021, 549.99, "Optoma"));
        projectors.add(new Projector("Sony VPL-HW45ES", 2019, 1999.99, "Sony"));
        projectors.add(new Projector("LG CineBeam HU80KSW", 2021, 2499.99, "LG"));

        System.out.println("Усі проектори:");
        displayProjectors(projectors);

        System.out.println("\nПроектори виробника Epson:");
        displayProjectorsByManufacturer(projectors, "Epson");

        System.out.println("\nПроектори випущені в 2021 році:");
        displayProjectorsByYear(projectors, 2021);

        System.out.println("\nПроектори дорожчі за $1000:");
        displayProjectorsAbovePrice(projectors, 1000);

        System.out.println("\nПроектори, відсортовані за ціною зростання:");
        displayProjectorsSortedByPriceAscending(projectors);

        System.out.println("\nПроектори, відсортовані за ціною спадання:");
        displayProjectorsSortedByPriceDescending(projectors);

        System.out.println("\nПроектори, відсортовані за роком випуску зростання:");
        displayProjectorsSortedByYearAscending(projectors);

        System.out.println("\nПроектори, відсортовані за роком випуску спадання:");
        displayProjectorsSortedByYearDescending(projectors);
    }
}

package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введіть кількість елементів у наборі:");
//        int size = scanner.nextInt();
//
//        Random random = new Random();
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            numbers.add(random.nextInt(101) - 50);
//        }
//
//        System.out.println("Набір випадкових чисел:");
//        System.out.println(numbers);
//
//        int evenCount = 0;
//        int oddCount = 0;
//        int zeroCount = 0;
//
//        System.out.println("Введіть значення для порівняння:");
//        int target = scanner.nextInt();
//
//        int targetCount = 0;
//
//        for (int num : numbers) {
//            if (num == 0) {
//                zeroCount++;
//            } else if (num % 2 == 0) {
//                evenCount++;
//            } else {
//                oddCount++;
//            }
//
//            if (num == target) {
//                targetCount++;
//            }
//        }
//
//        System.out.println("Кількість парних чисел: " + evenCount);
//        System.out.println("Кількість непарних чисел: " + oddCount);
//        System.out.println("Кількість чисел, рівних нулю: " + zeroCount);
//        System.out.println("Кількість чисел, рівних " + target + ": " + targetCount);
//
//
//        scanner.close();

        //task 2

//        List<String> cities = Arrays.asList("Київ", "Львів", "Харків", "Одеса", "Дніпро", "Запоріжжя", "Київ", "Одеса", "Львів");
//
//        System.out.println("Всі міста:");
//        System.out.println(cities);
//
//        System.out.println("Міста довжиною більше шести символів:");
//        cities.stream()
//                .filter(city -> city.length() > 6)
//                .forEach(System.out::println);
//
//        System.out.println("Введіть назву міста для пошуку:");
//        String searchCity = scanner.nextLine();
//        long count = cities.stream()
//                .filter(city -> city.equalsIgnoreCase(searchCity))
//                .count();
//        System.out.println("Місто \"" + searchCity + "\" зустрічається " + count + " раз(и).");
//
//        System.out.println("Введіть букву для пошуку міст:");
//        char letter = scanner.next().charAt(0);
//        long citiesCount = cities.stream()
//                .filter(city -> city.toLowerCase().charAt(0) == Character.toLowerCase(letter))
//                .count();
//        System.out.println("Кількість міст на букву \"" + letter + "\": " + citiesCount);
//
//        scanner.close();

        //task 3
//        List<Automobile> automobiles = new ArrayList<>();
//        automobiles.add(new Automobile("Toyota Camry", 2020, 25000, "black", 2.5));
//        automobiles.add(new Automobile("BMW X5", 2018, 40000, "white", 3.0));
//        automobiles.add(new Automobile("Honda Civic", 2019, 20000, "red", 1.8));
//        automobiles.add(new Automobile("Mercedes-Benz E-Class", 2017, 35000, "silver", 2.0));
//        automobiles.add(new Automobile("Ford Mustang", 2016, 30000, "blue", 5.0));
//
//        System.out.println("Всі автомобілі:");
//        automobiles.forEach(System.out::println);
//
//        String color = "red";
//        System.out.println("\nАвтомобілі кольору " + color + ":");
//        automobiles.stream()
//                .filter(auto -> auto.getColor().equalsIgnoreCase(color))
//                .forEach(System.out::println);
//
//        double engineVolume = 2.0;
//        System.out.println("\nАвтомобілі з об'ємом двигуна " + engineVolume + " л:");
//        automobiles.stream()
//                .filter(auto -> auto.getEngineVolume() == engineVolume)
//                .forEach(System.out::println);
//
//        double minPrice = 30000;
//        System.out.println("\nАвтомобілі дорожчі " + minPrice + " USD:");
//        automobiles.stream()
//                .filter(auto -> auto.getPrice() > minPrice)
//                .forEach(System.out::println);
//
//        int minYear = 2017;
//        int maxYear = 2019;
//        System.out.println("\nАвтомобілі випущені з " + minYear + " по " + maxYear + " рік:");
//        automobiles.stream()
//                .filter(auto -> auto.getYear() >= minYear && auto.getYear() <= maxYear)
//                .forEach(System.out::println);

        //task 4
        List<Television> televisions = new ArrayList<>();
        televisions.add(new Television("Samsung QLED", 2021, 1500, 55, "Samsung"));
        televisions.add(new Television("LG OLED", 2020, 2000, 65, "LG"));
        televisions.add(new Television("Sony Bravia", 2019, 1200, 50, "Sony"));
        televisions.add(new Television("Panasonic Viera", 2021, 1800, 60, "Panasonic"));
        televisions.add(new Television("TCL Roku", 2018, 800, 43, "TCL"));

        System.out.println("Всі телевізори:");
        televisions.forEach(System.out::println);

        double targetDiagonal = 55;
        System.out.println("\nТелевізори з діагоналлю " + targetDiagonal + ":");
        televisions.stream()
                .filter(tv -> tv.getDiagonal() == targetDiagonal)
                .forEach(System.out::println);

        String manufacturer = "Sony";
        System.out.println("\nТелевізори виробника " + manufacturer + ":");
        televisions.stream()
                .filter(tv -> tv.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(System.out::println);

        int currentYear = 2022;
        System.out.println("\nТелевізори поточного року (" + currentYear + "):");
        televisions.stream()
                .filter(tv -> tv.getYear() == currentYear)
                .forEach(System.out::println);

        double minPrice = 1500;
        System.out.println("\nТелевізори дорожчі " + minPrice + " USD:");
        televisions.stream()
                .filter(tv -> tv.getPrice() > minPrice)
                .forEach(System.out::println);

        System.out.println("\nТелевізори, відсортовані по ціні зростання:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice))
                .forEach(System.out::println);

        System.out.println("\nТелевізори, відсортовані по ціні спадання:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice).reversed())
                .forEach(System.out::println);


        System.out.println("\nТелевізори, відсортовані по діагоналі по зростанню:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal))
                .forEach(System.out::println);

        System.out.println("\nТелевізори, відсортовані по діагоналі по спаданню:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal).reversed())
                .forEach(System.out::println);
   }
}


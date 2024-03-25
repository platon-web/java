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

        List<String> cities = Arrays.asList("Київ", "Львів", "Харків", "Одеса", "Дніпро", "Запоріжжя", "Київ", "Одеса", "Львів");

        System.out.println("Всі міста:");
        System.out.println(cities);

        System.out.println("Міста довжиною більше шести символів:");
        cities.stream()
                .filter(city -> city.length() > 6)
                .forEach(System.out::println);

        System.out.println("Введіть назву міста для пошуку:");
        String searchCity = scanner.nextLine();
        long count = cities.stream()
                .filter(city -> city.equalsIgnoreCase(searchCity))
                .count();
        System.out.println("Місто \"" + searchCity + "\" зустрічається " + count + " раз(и).");

        System.out.println("Введіть букву для пошуку міст:");
        char letter = scanner.next().charAt(0);
        long citiesCount = cities.stream()
                .filter(city -> city.toLowerCase().charAt(0) == Character.toLowerCase(letter))
                .count();
        System.out.println("Кількість міст на букву \"" + letter + "\": " + citiesCount);

        scanner.close();

    }
}
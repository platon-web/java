package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість елементів у наборі:");
        int size = scanner.nextInt();

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(101) - 50);
        }

        System.out.println("Набір випадкових чисел:");
        System.out.println(numbers);

        int evenCount = 0;
        int oddCount = 0;
        int zeroCount = 0;

        System.out.println("Введіть значення для порівняння:");
        int target = scanner.nextInt();

        int targetCount = 0;

        for (int num : numbers) {
            if (num == 0) {
                zeroCount++;
            } else if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (num == target) {
                targetCount++;
            }
        }

        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
        System.out.println("Кількість чисел, рівних нулю: " + zeroCount);
        System.out.println("Кількість чисел, рівних " + target + ": " + targetCount);

        scanner.close();


    }
}
package org.example;

import java.util.Random;

public class NumberStats {
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static int countPositiveNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number > 0) {
                count++;
            }
        }
        return count;
    }

    public static int countNegativeNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number < 0) {
                count++;
            }
        }
        return count;
    }


    public static int countTwoDigitNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number >= 10 && number <= 99) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static int countPalindromes(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (isPalindrome(number)) {
                count++;
            }
        }
        return count;
    }
}

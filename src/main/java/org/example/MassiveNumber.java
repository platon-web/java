package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MassiveNumber {
    public static int[][] readArraysFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int[][] arrays = new int[10][];
        int i = 0;

        while ((line = reader.readLine()) != null) {
            String[] elements = line.trim().split(" ");
            int[] array = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                array[j] = Integer.parseInt(elements[j]);
            }
            arrays[i] = array;
            i++;
        }

        reader.close();
        return arrays;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }


    public static int findTotalSum(int[][] arrays) {
        int totalSum = 0;
        for (int[] array : arrays) {
            totalSum += findSum(array);
        }
        return totalSum;
    }
}

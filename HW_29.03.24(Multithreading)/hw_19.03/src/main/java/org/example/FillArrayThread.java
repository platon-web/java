package org.example;

import java.util.Random;

class FillArrayThread extends Thread {
    private int[] array;

    public FillArrayThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Генеруємо випадкове число в діапазоні від 0 до 99
        }
        System.out.println("Масив заповнено: " + java.util.Arrays.toString(array));
    }
}
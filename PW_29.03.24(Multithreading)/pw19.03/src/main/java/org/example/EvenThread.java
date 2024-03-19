package org.example;
import java.io.*;
class EvenThread extends Thread {
    private int[] array;

    public EvenThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("even_numbers.txt"))) {
            int count = 0;
            for (int num : array) {
                if (num % 2 == 0) {
                    writer.println(num);
                    count++;
                }
            }
            System.out.println("Кількість парних елементів: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
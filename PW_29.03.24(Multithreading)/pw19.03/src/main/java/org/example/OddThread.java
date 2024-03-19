package org.example;
import java.io.*;
class OddThread extends Thread {
    private int[] array;

    public OddThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("odd_numbers.txt"))) {
            int count = 0;
            for (int num : array) {
                if (num % 2 != 0) {
                    writer.println(num);
                    count++;
                }
            }
            System.out.println("Кількість непарних елементів: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
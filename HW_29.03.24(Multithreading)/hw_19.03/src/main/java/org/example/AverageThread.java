package org.example;

class AverageThread extends Thread {
    private int[] array;
    private double average;

    public AverageThread(int[] array) {
        this.array = array;
        this.average = 0.0;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        average = (double) sum / array.length;
        System.out.println("Середнє арифметичне значення в масиві: " + average);
    }
}

package org.example;

class AverageCalculator implements Runnable {
    private int[] array;
    private double average;

    public AverageCalculator(int[] array) {
        this.array = array;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        average = (double) sum / array.length;
    }
}
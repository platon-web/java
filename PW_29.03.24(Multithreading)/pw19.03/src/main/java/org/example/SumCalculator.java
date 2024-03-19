package org.example;

public class SumCalculator implements Runnable  {
    private int[] array;
    private int sum;

    public SumCalculator(int[] array) {
        this.array = array;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int num : array) {
            sum += num;
        }
    }
}

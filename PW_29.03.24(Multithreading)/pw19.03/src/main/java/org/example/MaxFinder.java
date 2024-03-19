package org.example;

class MaxFinder implements Runnable {
    private int[] array;
    private int max;

    public MaxFinder(int[] array) {
        this.array = array;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }
}
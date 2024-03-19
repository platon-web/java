package org.example;

class MinFinder implements Runnable {
    private int[] array;
    private int min;

    public MinFinder(int[] array) {
        this.array = array;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
    }
}
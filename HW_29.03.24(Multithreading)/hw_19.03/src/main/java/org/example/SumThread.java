package org.example;

class SumThread extends Thread {
    private int[] array;
    private int sum;

    public SumThread(int[] array) {
        this.array = array;
        this.sum = 0;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int value : array) {
            sum += value;
        }
        System.out.println("Сума елементів масиву: " + sum);
    }
}

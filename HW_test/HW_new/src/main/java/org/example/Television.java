package org.example;

public class Television {
    private String modelName;
    private int year;
    private double price;
    private double diagonal;
    private String manufacturer;

    public Television(String modelName, int year, double price, double diagonal, String manufacturer) {
        this.modelName = modelName;
        this.year = year;
        this.price = price;
        this.diagonal = diagonal;
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Television{" +
                "modelName='" + modelName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", diagonal=" + diagonal +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

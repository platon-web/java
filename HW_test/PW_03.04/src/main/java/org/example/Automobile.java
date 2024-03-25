package org.example;

public class Automobile {
    private String name;
    private int year;
    private double price;
    private String color;
    private double engineVolume;

    public Automobile(String name, int year, double price, String color, double engineVolume) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.engineVolume = engineVolume;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}

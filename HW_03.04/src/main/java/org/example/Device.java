package org.example;

import java.util.List;

public class Device {
    private String name;
    private int year;
    private double price;
    private String color;
    private String type;

    public Device(String name, int year, double price, String color, String type) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public static void displayDevices(List<Device> devices) {
        for (Device device : devices) {
            System.out.println(device.getName() + " - " + device.getYear() + " - $" + device.getPrice() + " - " + device.getColor() + " - " + device.getType());
        }
    }

    public static void displayDevicesByColor(List<Device> devices, String color) {
        for (Device device : devices) {
            if (device.getColor().equalsIgnoreCase(color)) {
                System.out.println(device.getName() + " - " + device.getYear() + " - $" + device.getPrice() + " - " + device.getColor() + " - " + device.getType());
            }
        }
    }

    public static void displayDevicesByYear(List<Device> devices, int year) {
        for (Device device : devices) {
            if (device.getYear() == year) {
                System.out.println(device.getName() + " - " + device.getYear() + " - $" + device.getPrice() + " - " + device.getColor() + " - " + device.getType());
            }
        }
    }

    public static void displayDevicesMoreExpensiveThan(List<Device> devices, double price) {
        for (Device device : devices) {
            if (device.getPrice() > price) {
                System.out.println(device.getName() + " - " + device.getYear() + " - $" + device.getPrice() + " - " + device.getColor() + " - " + device.getType());
            }
        }
    }

    public static void displayDevicesByType(List<Device> devices, String type) {
        for (Device device : devices) {
            if (device.getType().equalsIgnoreCase(type)) {
                System.out.println(device.getName() + " - " + device.getYear() + " - $" + device.getPrice() + " - " + device.getColor() + " - " + device.getType());
            }
        }
    }

    public static void displayDevicesByYearRange(List<Device> devices, int startYear, int endYear) {
        for (Device device : devices) {
            if (device.getYear() >= startYear && device.getYear() <= endYear) {
                System.out.println(device.getName() + " - " + device.getYear() + " - $" + device.getPrice() + " - " + device.getColor() + " - " + device.getType());
            }
        }
    }
}

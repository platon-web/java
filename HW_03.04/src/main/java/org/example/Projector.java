package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Projector {
    private String name;
    private int year;
    private double price;
    private String manufacturer;

    public Projector(String name, int year, double price, String manufacturer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
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

    public String getManufacturer() {
        return manufacturer;
    }
    public static void displayProjectors(List<Projector> projectors) {
        for (Projector projector : projectors) {
            System.out.println(projector.getName() + " - " + projector.getYear() + " - $" + projector.getPrice() + " - " + projector.getManufacturer());
        }
    }

    public static void displayProjectorsByManufacturer(List<Projector> projectors, String manufacturer) {
        for (Projector projector : projectors) {
            if (projector.getManufacturer().equalsIgnoreCase(manufacturer)) {
                System.out.println(projector.getName() + " - " + projector.getYear() + " - $" + projector.getPrice() + " - " + projector.getManufacturer());
            }
        }
    }

    public static void displayProjectorsByYear(List<Projector> projectors, int year) {
        for (Projector projector : projectors) {
            if (projector.getYear() == year) {
                System.out.println(projector.getName() + " - " + projector.getYear() + " - $" + projector.getPrice() + " - " + projector.getManufacturer());
            }
        }
    }
    public static void displayProjectorsAbovePrice(List<Projector> projectors, double price) {
        for (Projector projector : projectors) {
            if (projector.getPrice() > price) {
                System.out.println(projector.getName() + " - " + projector.getYear() + " - $"+ projector.getPrice() + " - " + projector.getManufacturer());
            }
        }
    }

    public static void displayProjectorsSortedByPriceAscending(List<Projector> projectors) {
        projectors.sort(Comparator.comparingDouble(Projector::getPrice));
        displayProjectors(projectors);
    }

    public static void displayProjectorsSortedByPriceDescending(List<Projector> projectors) {
        projectors.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        displayProjectors(projectors);
    }

    public static void displayProjectorsSortedByYearAscending(List<Projector> projectors) {
        projectors.sort(Comparator.comparingInt(Projector::getYear));
        displayProjectors(projectors);
    }

    public static void displayProjectorsSortedByYearDescending(List<Projector> projectors) {
        projectors.sort((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear()));
        displayProjectors(projectors);
    }
}

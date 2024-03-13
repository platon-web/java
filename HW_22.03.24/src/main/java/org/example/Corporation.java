package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Corporation {
    private List<Employee> employees = new ArrayList<>();
    private String filename;

    public Corporation(String filename) {
        this.filename = filename;
    }

    public void loadEmployeesFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (List<Employee>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка завантаження списку співробітників з файлу: " + e.getMessage());
        }
    }

    public void saveEmployeesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Помилка збереження списку співробітників у файл: " + e.getMessage());
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void editEmployee(String lastName, Employee newEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getLastName().equals(lastName)) {
                employees.set(i, newEmployee);
                break;
            }
        }
    }

    public void deleteEmployee(String lastName) {
        employees.removeIf(employee -> employee.getLastName().equals(lastName));
    }

    public Employee findEmployeeByLastName(String lastName) {
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

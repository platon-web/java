package org.example.pw_1004;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.*;

@WebServlet(name = "Notebook", value = "/Notebook")
class HelloServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        String url = "jdbc:mysql://localhost:3306/car_database";
        String username = "username";
        String password = "password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayAllCars(HttpServletResponse response) throws IOException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");

            PrintWriter out = response.getWriter();
            while (resultSet.next()) {
                out.println(resultSet.getString("manufacturer") + " " +
                        resultSet.getString("car_name") + " " +
                        resultSet.getDouble("engine_volume") + " " +
                        resultSet.getInt("year") + " " +
                        resultSet.getString("color") + " " +
                        resultSet.getString("car_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayAllManufacturers(HttpServletResponse response) throws IOException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT manufacturer FROM cars");

            PrintWriter out = response.getWriter();
            while (resultSet.next()) {
                out.println(resultSet.getString("manufacturer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "displayAllCars":
                    displayAllCars(response);
                    break;
                case "displayAllManufacturers":
                    displayAllManufacturers(response);
                    break;
                default:
                    out.println("Invalid action");
            }
        } else {
            out.println("No action specified");
        }
    }
}
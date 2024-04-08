package org.example.hw_1304;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalesServlet")
public class SalesServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sales_db";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.getWriter().println("No action specified.");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (action.equals("viewSellers")) {
                viewSellers(conn, request, response);
            } else if (action.equals("viewBuyers")) {
                viewBuyers(conn, request, response);
            } else if (action.equals("viewProducts")) {
                viewProducts(conn, request, response);
            } else if (action.equals("viewDeals")) {
                viewDeals(conn, request, response);
            } else if (action.equals("viewDealsByDate")) {
                String date = request.getParameter("date");
                viewDealsByDate(conn, date, response);
            } else if (action.equals("viewDealsByDateRange")) {
                String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                viewDealsByDateRange(conn, startDate, endDate, response);
            } else if (action.equals("viewDealsBySeller")) {
                String sellerId = request.getParameter("sellerId");
                viewDealsBySeller(conn, sellerId, response);
            } else if (action.equals("viewDealsByBuyer")) {
                String buyerId = request.getParameter("buyerId");
                viewDealsByBuyer(conn, buyerId, response);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection error: " + e.getMessage());
        }
    }

    // Method to view all deals
    private void viewDeals(Connection conn, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String query = "SELECT * FROM sales";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            response.getWriter().println("Deal ID: " + rs.getInt("deal_id") + ", Seller: " + rs.getString("seller_name") + ", Buyer: " + rs.getString("buyer_name") + ", Product: " + rs.getString("product_name") + ", Price: " + rs.getDouble("price") + ", Date: " + rs.getString("sale_date"));
        }
        rs.close();
        stmt.close();
    }

    // Method to view deals on a specific date
    private void viewDealsByDate(Connection conn, String date, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String query = "SELECT * FROM sales WHERE sale_date = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, date);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            response.getWriter().println("Deal ID: " + rs.getInt("deal_id") + ", Seller: " + rs.getString("seller_name") + ", Buyer: " + rs.getString("buyer_name") + ", Product: " + rs.getString("product_name") + ", Price: " + rs.getDouble("price") + ", Date: " + rs.getString("sale_date"));
        }
        rs.close();
        pstmt.close();
    }

    // Method to view deals within a date range
    private void viewDealsByDateRange(Connection conn, String startDate, String endDate, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String query = "SELECT * FROM sales WHERE sale_date BETWEEN ? AND ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, startDate);
        pstmt.setString(2, endDate);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            response.getWriter().println("Deal ID: " + rs.getInt("deal_id") + ", Seller: " + rs.getString("seller_name") + ", Buyer: " + rs.getString("buyer_name") + ", Product: " + rs.getString("product_name") + ", Price: " + rs.getDouble("price") + ", Date: " + rs.getString("sale_date"));
        }
        rs.close();
        pstmt.close();
    }

    // Method to view deals by a specific seller
    private void viewDealsBySeller(Connection conn, String sellerId, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String query = "SELECT * FROM sales WHERE seller_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, sellerId);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            response.getWriter().println("Deal ID: " + rs.getInt("deal_id") + ", Seller: " + rs.getString("seller_name") + ", Buyer: " + rs.getString("buyer_name") + ", Product: " + rs.getString("product_name") + ", Price: " + rs.getDouble("price") + ", Date: " + rs.getString("sale_date"));
        }
        rs.close();
        pstmt.close();
    }

    // Method to view deals by a specific buyer
    private void viewDealsByBuyer(Connection conn, String buyerId, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String query = "SELECT * FROM sales WHERE buyer_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, buyerId);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            response.getWriter().println("Deal ID: " + rs.getInt("deal_id") + ", Seller: " + rs.getString("seller_name") + ", Buyer: " + rs.getString("buyer_name") + ", Product: " + rs.getString("product_name") + ", Price: " + rs.getDouble("price") + ", Date: " + rs.getString("sale_date"));
        }
        rs.close();
        pstmt.close();
    }
}
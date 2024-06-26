package org.example.hw_1304;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/java_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.getWriter().println("No action specified.");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (action.equals("viewDeals")) {
                viewDeals(conn, response);
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
            } else {
                response.getWriter().println("Invalid action specified.");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection error: " + e.getMessage());
        }
    }


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
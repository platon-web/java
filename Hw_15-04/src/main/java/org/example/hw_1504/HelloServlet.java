package org.example.hw_1504;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
//task 1
//    public void doGet (HttpServletRequest req,
//                       HttpServletResponse res)
//            throws ServletException, IOException
//    {
//        PrintWriter out = res.getWriter();
//
//        out.println("Hello, world!");
//        out.close();
//    }

    //task 2
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//    }


    //task 6
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quotes_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String quote = request.getParameter("quote");
//        String author = request.getParameter("author");
//        String category = request.getParameter("category");
//
//        try {
//            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            String query = "INSERT INTO quotes (quote, author, category) VALUES (?, ?, ?)";
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, quote);
//            pstmt.setString(2, author);
//            pstmt.setString(3, category);
//            pstmt.executeUpdate();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("Error: " + e.getMessage());
//            return;
//        }
//
//        PrintWriter out = response.getWriter();
//        out.println("Quote added successfully!");
//    }

    //task 7
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String id = request.getParameter("id");
//        String quote = request.getParameter("quote");
//        String author = request.getParameter("author");
//        String category = request.getParameter("category");
//
//        try {
//            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            String query = "UPDATE quotes SET quote = ?, author = ?, category = ? WHERE id = ?";
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, quote);
//            pstmt.setString(2, author);
//            pstmt.setString(3, category);
//            pstmt.setString(4, id);
//            pstmt.executeUpdate();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().println("Error: " + e.getMessage());
//            return;
//        }
//
//        PrintWriter out = response.getWriter();
//        out.println("Quote updated successfully!");
//    }

    //task 8

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String query = "DELETE FROM quotes WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
            return;
        }

        PrintWriter out = response.getWriter();
        out.println("Quote deleted successfully!");
    }

    public void destroy() {
    }
}
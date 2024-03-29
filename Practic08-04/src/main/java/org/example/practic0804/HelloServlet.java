package org.example.practic0804;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Установка кодировки відповіді на UTF-8 для коректного відображення кирилиці
        response.setContentType("text/html;charset=UTF-8");

        // Відображення HTML-розмітки для інформації про місто
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Інформація про місто</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Назва міста: Біла Церква</h1>");
        response.getWriter().println("<h2>Назва країни: Україна</h2>");
        response.getWriter().println("<img src='https://cdn.mykyivregion.com.ua/uploads/img/VRLXxqaepZoCan2xSB5tSs2BgmE3XodixI4g7Jlj.jpg' alt='Герб міста'>");
        response.getWriter().println("<p>Кількість мешканців: 210 тисяч</p>");
        response.getWriter().println("<p>Короткий опис міста: Біла Церква — місто обласного підпорядкування в Україні, адміністративний центр Білоцерківського району та Білоцерківської міської громади. Засноване в 1032 році.</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
    public void destroy() {
    }
}
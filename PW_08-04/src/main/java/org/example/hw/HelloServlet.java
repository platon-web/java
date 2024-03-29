package org.example.hw;

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
        response.getWriter().println("<h1>Назва міста: Київ</h1>");
        response.getWriter().println("<h2>Назва країни: Україна</h2>");
        response.getWriter().println("<img src='gerb.jpg' alt='Герб міста'>");
        response.getWriter().println("<p>Кількість мешканців: 2.8 мільйона</p>");
        response.getWriter().println("<p>Короткий опис міста: Ки́їв — столиця та найбільше місто України, його політичний, соціально-економічний, науковий, культурний та історичний центр.</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    public void destroy() {
    }
}
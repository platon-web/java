package org.example.practic0804;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
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

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Інформація про місто</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Назва міста: Біла Церква</h1>");
        response.getWriter().println("<h2>Назва країни: Україна</h2>");
        response.getWriter().println("<img src='https://upload.wikimedia.org/wikipedia/commons/a/a8/Bila_Tserkva_gerb.svg' alt='Герб міста'>");
        response.getWriter().println("<p>Кількість мешканців: 210 тисяч</p>");
        response.getWriter().println("<p>Короткий опис міста: Біла Церква — місто обласного підпорядкування в Україні, адміністративний центр Білоцерківського району та Білоцерківської міської громади. Засноване в 1032 році.</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
        String menu = "<ul>" +
                "<li><a href='#general'>Загальна інформація</a></li>" +
                "<li><a href='#history'>Історія міста</a></li>" +
                "<li><a href='#landmarks'>Визначні пам'ятки</a></li>" +
                "<li><a href='#hotels'>Готелі</a></li>" +
                "<li><a href='#restaurants'>Ресторани</a></li>" +
                "</ul>";

        response.getWriter().println(menu);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    public void destroy() {
    }
}
package org.example.hw_0804;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        request.getRequestDispatcher("/navigation-menu.jsp").forward(request, response);
        request.getRequestDispatcher("/manuFacturer-history.jsp").forward(request, response);
        request.getRequestDispatcher("/news.jsp").forward(request, response);
        request.getRequestDispatcher("/full-news.jsp").forward(request, response);
        request.getRequestDispatcher("/laptop-models.jsp").forward(request, response);
    }


    public void destroy() {
    }
}
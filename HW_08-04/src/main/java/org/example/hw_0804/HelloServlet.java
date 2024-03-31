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
        request.getRequestDispatcher("/manufacturer-info.html").forward(request, response);
        request.getRequestDispatcher("/navigation-menu.html").forward(request, response);
        request.getRequestDispatcher("/manuFacturer-history.html").forward(request, response);
        request.getRequestDispatcher("/news.html").forward(request, response);
        request.getRequestDispatcher("/full-news.html").forward(request, response);
        request.getRequestDispatcher("/laptop-models.html").forward(request, response);
    }


    public void destroy() {
    }
}
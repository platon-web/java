package org.example.hw_0604;

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
    //task 1
//    private static final long serialVersionUID = 1L;
//
//    private static final String QUOTE = "Bad programmers worry about the code. Good programmers worry about data structures and their relationships";
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        response.getWriter().println("<h1>Цитата Лінуса Торвальдса:</h1>");
//        response.getWriter().println("<p>" + QUOTE + "</p>");
//    }
    public void destroy() {
    }
}
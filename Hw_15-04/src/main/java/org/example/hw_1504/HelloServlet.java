package org.example.hw_1504;

import java.io.*;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


    //task 3


    public void destroy() {
    }
}
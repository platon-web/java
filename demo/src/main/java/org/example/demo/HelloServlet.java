package org.example.demo;

import java.io.*;
import java.util.Random;

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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h2>Цитата Мартіна Фаулера:</h2>");
//        out.println("<p>Any fool can write code that a computer can understand. "
//                + "Good programmers write code that humans can understand.</p>");
//        out.println("</body></html>");
//    }

    //task 2
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h2>Табличка множення</h2>");
//
//        out.println("<form>");
//        out.println("Введіть число для таблички множення: <input type='text' name='number'><br>");
//        out.println("<input type='submit' value='Показати табличку'>");
//        out.println("</form>");
//
//        // Отримуємо параметр числа з запиту
//        String numberParam = request.getParameter("number");
//        if (numberParam != null && !numberParam.isEmpty()) {
//            int number = 0;
//            try {
//                number = Integer.parseInt(numberParam);
//            } catch (NumberFormatException e) {
//                out.println("<p>Будь ласка, введіть коректне число.</p>");
//                out.println("</body></html>");
//                return;
//            }
//
//            // Відображаємо табличку множення для введеного числа
//            out.println("<h3>Табличка множення для числа " + number + "</h3>");
//            out.println("<table border='1'>");
//            for (int i = 1; i <= 10; i++) {
//                out.println("<tr><td>" + number + " * " + i + "</td><td>=</td><td>" + (number * i) + "</td></tr>");
//            }
//            out.println("</table>");
//        }
//
//        out.println("</body></html>");
//    }


    //task 3
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Integer randomNumber = (Integer) session.getAttribute("randomNumber");
//        if (randomNumber == null) {
//            randomNumber = (int) (Math.random() * 100) + 1; // Загадане число
//            session.setAttribute("randomNumber", randomNumber);
//        }
//
//        String guessParameter = request.getParameter("guess");
//        Integer guess = null;
//        if (guessParameter != null) {
//            try {
//                guess = Integer.parseInt(guessParameter);
//            } catch (NumberFormatException e) {
//                // Обробка помилки, якщо введене значення не є числом
//            }
//        }
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("<html><head><title>Guess the Number</title></head><body>");
//
//        if (guess == null) {
//            out.println("<h2>Guess the number between 1 and 100</h2>");
//        } else {
//            if (guess > randomNumber) {
//                out.println("<h2>The number is smaller than " + guess + "</h2>");
//            } else if (guess < randomNumber) {
//                out.println("<h2>The number is greater than " + guess + "</h2>");
//            } else {
//                out.println("<h2>Congratulations! You've guessed the number: " + guess + "</h2>");
//                session.removeAttribute("randomNumber");
//            }
//        }
//
//        out.println("<form method=\"get\">");
//        out.println("<input type=\"text\" name=\"guess\">");
//        out.println("<input type=\"submit\" value=\"Guess\">");
//        out.println("</form>");
//
//        out.println("</body></html>");
//    }

    public void destroy() {
    }
}
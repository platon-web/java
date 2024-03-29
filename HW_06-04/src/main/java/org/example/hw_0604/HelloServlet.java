package org.example.hw_0604;


import java.awt.datatransfer.DataFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.System.out;
/* hw task connect 5 */

import jakarta.servlet.annotation.WebServlet;

//@WebServlet("/CalculatorServlet")
/* hw task connect 4 */
//@WebServlet("/TextAnalysisServlet")
/* hw task connect 3 */
//@WebServlet("/CalculateServlet")
/* hw task connect 2 */
//@WebServlet("/MaxNumberServlet")
/* lab task conect */
//@WebServlet("/SurveyServlet")
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    private DataFlavor request;
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


    //task 2
//    String number1Str = request.getParameter("num1");
//    String number2Str = request.getParameter("num2");
//    String number3Str = request.getParameter("num3");
//
//    double number1 = Double.parseDouble(number1Str);
//    double number2 = Double.parseDouble(number2Str);
//    double number3 = Double.parseDouble(number3Str);
//
//    double maxNumber = Math.max(number1, Math.max(number2, number3));
//
//        out.println("<html><head><title>Maximum Number</title></head><body>");
//        out.println("<h2>Entered Numbers:</h2>");
//        out.println("<p>Number 1: " + number1 + "</p>");
//        out.println("<p>Number 2: " + number2 + "</p>");
//        out.println("<p>Number 3: " + number3 + "</p>");
//        out.println("<h2>Maximum Number:</h2>");
//        out.println("<p>" + maxNumber + "</p>");
//        out.println("</body></html>");

    /* task 3 */
//        String number1Str = request.getParameter("number1");
//        String number2Str = request.getParameter("number2");
//        String number3Str = request.getParameter("number3");
//        double number1 = Double.parseDouble(number1Str);
//        double number2 = Double.parseDouble(number2Str);
//        double number3 = Double.parseDouble(number3Str);
//
//        String operation = request.getParameter("operation");
//
//        double result = 0;
//        if ("max".equals(operation)) {
//            result = Math.max(number1, Math.max(number2, number3));
//        } else if ("min".equals(operation)) {
//            result = Math.min(number1, Math.min(number2, number3));
//        } else if ("average".equals(operation)) {
//            result = (number1 + number2 + number3) / 3;
//        }
//
//        response.setContentType("text/html");
//        out.println("<html><head><title>Calculation Result</title></head><body>");
//        out.println("<h2>Entered Numbers:</h2>");
//        out.println("<p>Number 1: " + number1 + "</p>");
//        out.println("<p>Number 2: " + number2 + "</p>");
//        out.println("<p>Number 3: " + number3 + "</p>");
//        out.println("<h2>Calculation Result:</h2>");
//        out.println("<p>" + result + "</p>");
//        out.println("</body></html>");

    /* task 4 */
//        String text = request.getParameter("text");
//
//        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
//        List<Character> consonants = new ArrayList<>();
//        List<Character> separators = new ArrayList<>();
//        int vowelsCount = 0;
//        int consonantsCount = 0;
//        int separatorsCount = 0;
//
//        for (int i = 0; i < text.length(); i++) {
//            char ch = text.charAt(i);
//            if (Character.isLetter(ch)) {
//                if (vowels.contains(ch)) {
//                    vowelsCount++;
//                } else {
//                    consonantsCount++;
//                    consonants.add(ch);
//                }
//            } else if (Character.isWhitespace(ch)) {
//            } else {
//                separatorsCount++;
//                separators.add(ch);
//            }
//        }
//
//        response.setContentType("text/html");
//        out.println("<html><head><title>Text Analysis Results</title></head><body>");
//        out.println("<h2>Text Analysis Results:</h2>");
//        out.println("<p>Text: " + text + "</p>");
//        out.println("<p>Vowels Count: " + vowelsCount + "</p>");
//        out.println("<p>Vowels: " + vowels.toString() + "</p>");
//        out.println("<p>Consonants Count: " + consonantsCount + "</p>");
//        out.println("<p>Consonants: " + consonants.toString() + "</p>");
//        out.println("<p>Separators Count: " + separatorsCount + "</p>");
//        out.println("<p>Separators: " + separators.toString() + "</p>");
//        out.println("</body></html>");

    /* task 5 */
//        double num1 = Double.parseDouble(request.getParameter("num1"));
//        double num2 = Double.parseDouble(request.getParameter("num2"));
//        String operation = request.getParameter("operation");
//
//        double result = 0;
//        String errorMessage = "";
//        switch (operation) {
//            case "add":
//                result = num1 + num2;
//                break;
//            case "subtract":
//                result = num1 - num2;
//                break;
//            case "multiply":
//                result = num1 * num2;
//                break;
//            case "divide":
//                if (num2 != 0) {
//                    result = num1 / num2;
//                } else {
//                    errorMessage = "Error: division by zero!";
//                }
//                break;
//            case "power":
//                result = Math.pow(num1, num2);
//                break;
//            case "percentage":
//                result = (num1 * num2) / 100;
//                break;
//            default:
//                errorMessage = "Error: invalid operation!";
//        }
//
//        response.setContentType("text/html");
//        out.println("<html><head><title>Calculator Result</title></head><body>");
//        if (!errorMessage.isEmpty()) {
//            out.println("<h2>" + errorMessage + "</h2>");
//        } else {
//            out.println("<h2>Calculator Result:</h2>");
//            out.println("<p>" + num1 + " " + operation + " " + num2 + " = " + result + "</p>");
//        }
//        out.println("</body></html>");
//    }
    public void destroy() {
    }
}
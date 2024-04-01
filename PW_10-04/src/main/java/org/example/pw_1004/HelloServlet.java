package org.example.pw_1004;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String url = "jdbc:mysql://localhost:3306/java_db";
       String user="root";
       String password= "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, user, password)){
//String command ="create table product(\n" +
//        "    id int primary key auto_increment,\n" +
//        "    name varchar(255) not null,\n" +
//        "    description varchar(500) null,\n" +
//        "    price decimal\n" +
//        ")";
//                String command = "insert Product (name, description, price) values ('milk' , 'tasty', 20),\n" +
//                        "                                                 ('lemon', 'yellow', 10);";
                String commandRead = "select * from Product";
                Statement stat = connection.createStatement();
                ResultSet result =  stat.executeQuery(commandRead);

                response.setContentType("text/html");

                // Hello
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + "table created" + "</h1>");

                out.println("<table>");
                out.println("<tr> <th> id </th> <th> name </th> <th> description </th> <th> price </th> </tr> ");
                while (result.next()){
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String description = result.getString("description");
                    double price = result.getDouble("price");
                    out.println("<tr> <td> "+id+"</td> <td> "+name+" </td> <td>"+description+"</td> <td>"+price+"</td> </tr> ");
                }
                out.println("</table>");
                out.println("</body></html>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public void destroy() {
    }
}
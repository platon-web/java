import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add_user")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String url = "test";
        String user = "root";
        String dbPassword = "";

        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);

            String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insertUserStatement = con.prepareStatement(insertUserQuery);
            insertUserStatement.setString(1, username);
            insertUserStatement.setString(2, password);
            insertUserStatement.executeUpdate();

            out.println("<h1>Додавання користувача</h1>");
            out.println("<p>Користувач " + username + " успішно доданий.</p>");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
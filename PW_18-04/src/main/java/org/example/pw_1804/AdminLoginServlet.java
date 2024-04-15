import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin_login")
public class AdminLoginServlet extends HttpServlet {
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
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection(url, user, dbPassword);

            String checkAdminQuery = "SELECT * FROM admins WHERE username=? AND password=?";
            PreparedStatement checkAdminStatement = con.prepareStatement(checkAdminQuery);
            checkAdminStatement.setString(1, username);
            checkAdminStatement.setString(2, password);
            ResultSet rs = checkAdminStatement.executeQuery();

            if (rs.next()) {
                response.sendRedirect("admin_panel.jsp");
            } else {
                out.println("<h1>Вхід для адміністратора</h1>");
                out.println("<p>Невірний логін або пароль. Будь ласка, спробуйте знову.</p>");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
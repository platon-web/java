import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/theme_settings")
public class ThemeSettingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String theme = request.getParameter("theme");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<h1>Налаштування теми</h1>");
        out.println("<p>Обрана тема: " + theme + "</p>");
    }
}
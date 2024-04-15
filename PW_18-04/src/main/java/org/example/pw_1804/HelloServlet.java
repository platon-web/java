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

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int TIME_LIMIT_PER_QUESTION_SECONDS = 30;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String category = request.getParameter("category");
        int currentIndex = Integer.parseInt(request.getParameter("currentIndex"));

        String url = "test";
        String user = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String getQuestionsQuery = "SELECT * FROM questions WHERE category=?";
            PreparedStatement getQuestionsStatement = con.prepareStatement(getQuestionsQuery);
            getQuestionsStatement.setString(1, category);
            ResultSet rs = getQuestionsStatement.executeQuery();

            int questionIndex = 0;
            while (rs.next() && questionIndex <= currentIndex) {
                if (questionIndex == currentIndex) {
                    String question = rs.getString("question");
                    int timeLimit = TIME_LIMIT_PER_QUESTION_SECONDS;
                    request.setAttribute("timeLimit", timeLimit);
                    request.setAttribute("currentIndex", currentIndex + 1);
                    request.getRequestDispatcher("quiz.jsp").forward(request, response);
                    break;
                }
                questionIndex++;
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
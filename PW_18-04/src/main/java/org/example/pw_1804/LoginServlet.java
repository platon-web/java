@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String url = "test";
        String user = "root";
        String dbPassword = "";

        try {
            Connection con = DriverManager.getConnection(url, user, dbPassword);

            String checkUserQuery = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement checkUserStatement = con.prepareStatement(checkUserQuery);
            checkUserStatement.setString(1, username);
            checkUserStatement.setString(2, password);
            ResultSet rs = checkUserStatement.executeQuery();

            if (rs.next()) {
                response.sendRedirect("quiz.jsp");
            } else {
                out.println("<h1>Вхід</h1>");
                out.println("<p>Невірний логін або пароль. Будь ласка, спробуйте знову.</p>");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
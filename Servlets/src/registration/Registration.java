package registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Registration")
public class Registration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobbies");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");
        PrintWriter out = response.getWriter();

        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("<p>Sex: " + gender + "</p>");
        out.println("<p>Hobbies: </p>");

        for (String hobby : hobbies) {
            out.println(hobby + "<br>");
        }

        out.println("<p>Country: " + country + "</p>");
        out.println("<p>Languages: </p>");

        for (String language : languages) {
            out.println(language + "<br>");
        }
    }
}

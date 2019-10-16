package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ReadCookiesServlet")
public class GetCookiesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] userData = request.getCookies();
        String guestName = userData[0].getValue();
        String email = userData[1].getValue();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Your Cookies</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Details:</p>");
        out.println("<p>Name: " + guestName);
        out.println("<p>Email: " + email);
        out.println("</body>");
        out.println("</html>");
    }
}
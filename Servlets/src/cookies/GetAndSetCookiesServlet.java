package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetAndSetCookiesServlet")
public class GetAndSetCookiesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] userData = request.getCookies();
        String guestName = userData[0].getValue();

        String email = request.getParameter("email");
        Cookie emailData = new Cookie("email", email);
        response.addCookie(emailData);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Get and Set Cookies</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Name: " + guestName + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<form name='formGetCookieServlet' action='ReadCookiesServlet' method='post'>");
        out.println("<p><input type='submit' value='Read Cookies' name='btnRead' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
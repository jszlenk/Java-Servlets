package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SetCookiesServlet")
public class SetCookiesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String guestName = request.getParameter("guestName");
        Cookie guestData = new Cookie("guestName", guestName);
        guestData.setMaxAge(1800);
        guestData.setComment("Your name");
        response.addCookie(guestData);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>CookieServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Welcome " + guestName + "</p>");
        out.println("<form name='formSetCookieServlet' action='GetAndSetCookiesServlet' method='post'>");
        out.println("<p>Enter Email: <input type='email' name='email' /></p>");
        out.println("<p><input type='submit' value='Get And Set Cookies' name='btnGet' /></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
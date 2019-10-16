package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String guestName = request.getParameter("guestName");
        HttpSession session = request.getSession();
        session.setAttribute("guestName", guestName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>SessionServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Welcome " + guestName + "</p>");
        out.println("<form name='formSetSessionServlet' action='GetAndSetSessionServlet' method='post'>");
        out.println("<p>Enter Email: <input type='email' name='email' /></p>");
        out.println("<p><input type='submit' value='Get And Set Session' name='btnGet' /></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
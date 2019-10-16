package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetAndSetSessionServlet")
public class GetAndSetSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String guestName = (String) session.getAttribute("guestName");

        String email = request.getParameter("email");
        session.setAttribute("email", email);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Get and Set Session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Name: " + guestName + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<form name='formGetSessionServlet' action='GetSessionServlet' method='post'>");
        out.println("<p><input type='submit' value='Read Session' name='btnRead' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
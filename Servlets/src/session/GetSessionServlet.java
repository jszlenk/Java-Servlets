package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String guestName = (String) session.getAttribute("guestName");
        String email = (String) session.getAttribute("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Your Session</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Details:</p>");
        out.println("<p>Name : " + guestName);
        out.println("<p>Email : " + email);
        out.println("</body>");
        out.println("</html>");
    }
}
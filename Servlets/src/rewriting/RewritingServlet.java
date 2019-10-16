package rewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RewritingServlet")
public class RewritingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");
        String queryString = "guestName=" + guestName + "&email=" + email;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Rewriting</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href='PreviewServlet?" + queryString + "'>Preview</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
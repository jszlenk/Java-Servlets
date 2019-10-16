package headers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/RequestHeaders")
public class RequestHeaders extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Headers</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>All Request Headers</h1>");

        out.println("<p><b>Request Method: </b>" + request.getMethod());
        out.println("<p><b>Request URI: </b>" + request.getRequestURI());
        out.println("<p><b>Request Protocol: </b>" + request.getProtocol());
        out.println("<p><b>Request ServerPort: </b>" + request.getServerPort());
        out.println("<p><b>Request ServletPath: </b>" + request.getServletPath());

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<p><b>" + headerName + ": </b>" + request.getHeader(headerName) + "</p>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

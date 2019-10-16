package errorhandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage= (String) request.getAttribute("javax.servlet.error.message");
        String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String exceptionType = (String) request.getAttribute("javax.servlet.error.exception_type");
        String exception = (String) request.getAttribute("javax.servlet.error.exception");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error Handling </title>");
        out.println("</head>");
        out.println("<body>");
        out.println( "<p>Status Code : " + statusCode + "</p>");
        out.println( "<p>Error Message : " + errorMessage + "</p>");
        out.println( "<p>Request URI : " + requestURI + "</p>");
        out.println( "<p>Servlet Name : " + servletName + "</p>");
        out.println( "<p>ExceptionType : " + exceptionType + "</p>");
        out.println( "<p>Exception Name : " + exception + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
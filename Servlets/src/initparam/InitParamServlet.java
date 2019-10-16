package initparam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InitParamServlet", description = "Demo InitParam", urlPatterns = {"/AnnotationsServlet", "/InitParam"},
        initParams = {@WebInitParam(name = "user", value = "Net"), @WebInitParam(name = "email", value = "adress@gmail.com")})
public class InitParamServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>InitParam</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Welcome InitParams</h3>");

        String ename = getServletConfig().getInitParameter("user");
        String email = getServletConfig().getInitParameter("email");

        out.println("<h4>Reading the values from the InitParams</h4>");

        out.println("<p>Name: " + ename + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
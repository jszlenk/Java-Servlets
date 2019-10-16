package userinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h4>URL: http://localhost:8080/UserInfo?firstName=Kuba&lastName=Szlenk</h4>");
        out.println("<h4>String: getParameter()</h4>");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        out.println("<div>");
        out.println("<p>First name " + firstName + "</p>");
        out.println("<p>First name " + lastName + "</p>");
        out.println("</div><hr>");

        out.println("<h4>Enumeration: getParameterNames()</h4>");

        Enumeration<String> paramNames = request.getParameterNames();

        out.println("<div>");
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            out.println("<p>" + paramName + " : " + paramValue + "</p>");
        }
        out.println("</div><hr>");

        out.println("<h4>Map: getParameterMap()</h4>");

        Map<String, String[]> paramMap = request.getParameterMap();
        Set<String> paramNamesSet = paramMap.keySet();

        out.println("<div>");
        for (String paramName : paramNamesSet) {
            String[] paramValues = paramMap.get(paramName);

            out.println("<p>" + paramName + " : ");
            for (String paramValue : paramValues) {
                out.println(paramValue);
            }
            out.println("</p>");
        }
        out.println("</div>");
    }
}

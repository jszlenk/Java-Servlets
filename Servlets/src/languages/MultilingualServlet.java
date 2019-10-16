package languages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MultilingualServlet")
public class MultilingualServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String localLanguage = request.getLocale().getLanguage();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.resourceBundle", Locale.US);

        for (Languages language : Languages.values()) {
            if (language.getLanguage().contains(localLanguage)) {
                resourceBundle = ResourceBundle.getBundle("i18n.resourceBundle", request.getLocale());
            }
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + resourceBundle.getString("Title") + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='" + resourceBundle.getString("Flag") + "'></img>");
        out.println("<p>" + resourceBundle.getString("Title") + "</p>");
        out.println("<form>");
        out.println("<p><input type='text' /> ");
        out.println("<p><input type='submit' name='btnSubmit' value='" + resourceBundle.getString("BtnSubmit") + "' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
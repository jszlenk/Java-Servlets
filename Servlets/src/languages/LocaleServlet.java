package languages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LocaleServlet")
public class LocaleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Locale locale = request.getLocale();

        String language = locale.getLanguage();
        String country = locale.getCountry();
        String displayLanguage = locale.getDisplayLanguage();
        String displayCountry = locale.getDisplayCountry();
        String displayName = locale.getDisplayName();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detecting Locale</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Language : " + language + "</p");
        out.println("<p>Display Language : " + displayLanguage + "</p>");
        out.println("<p>Country : " + country + "</p>");
        out.println("<p>Display Country : " + displayCountry + "</p>");
        out.println("<p>Display Name : " + displayName + "</p>");
        out.println("<hr />");

        Locale[] locations = Locale.getAvailableLocales();

        for (Locale location : locations) {

            out.println("<p>Name of Locale: " + location.getDisplayName() + "</p>");

            out.println("<p>Language Code: " + location.getLanguage() +
                    ", Language Display Name: " + location.getDisplayLanguage() + "</p>");

            out.println("<p>Country Code: " + location.getCountry() +
                    ", Country Display Name: " + location.getDisplayCountry() + "</p>");

            if (!location.getScript().equals("")) {
                out.println("<p>Script Code: " + location.getScript() +
                        ", Script Display Name: " + location.getDisplayScript() + "</p>");
            }

            if (!location.getVariant().equals("")) {
                out.println("<p>Variant Code: " + location.getVariant() +
                        ", Variant Display Name: " + location.getDisplayVariant() + "</p>");
            }
            out.println("<hr />");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
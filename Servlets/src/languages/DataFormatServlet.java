package languages;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataFormatServlet")
public class DataFormatServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>DataFormat nad Locale</title>");
        out.println("</head>");
        out.println("<body>");

        long number = 10000000L;

        NumberFormat numberFormatDefault = NumberFormat.getInstance();
        out.println("<p>Number Format using Default Locale: " + numberFormatDefault.format(number));

        NumberFormat numberFormatLocale = NumberFormat.getInstance(Locale.GERMAN);
        out.println("<p>Number Format using German Locale: " + numberFormatLocale.format(number));

        NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
        out.println("<p>Currency Format using Default Locale: " + numberFormatDefaultCurrency.format(number));

        NumberFormat numberFormatLocaleCurrencyUS = NumberFormat.getCurrencyInstance(Locale.US);
        out.println("<p>Currency Format using US Locale: " + numberFormatLocaleCurrencyUS.format(number));

        NumberFormat numberFormatLocaleCurrencyJapan = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        Currency currency = Currency.getInstance(Locale.JAPAN);
        out.println("<p>Currency Format using Japan Locale: " + numberFormatLocaleCurrencyJapan.format(number)
                + "<br>Currency Display Name : " + currency.getDisplayName()
                + "<br>Currency Code : " + currency.getCurrencyCode());

        Date currentDate = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);

        out.println("<p>Date Format in Germany Locale: " + dateFormat.format(currentDate));
        out.println("</body>");
        out.println("</html>");
    }
}
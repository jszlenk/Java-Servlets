package refresh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/RefreshServlet")
public class RefreshServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setIntHeader("Refresh", 3);

        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        String am_pm;

        if (calendar.get(Calendar.AM_PM) == Calendar.AM){
            am_pm = "am";
        }
        else {
            am_pm = "pm";
        }

        String currentTime = hour + ":" + min + ":" + sec + " " + am_pm;

        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Page using Response Headers</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Page Last refreshed at : " + currentTime + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

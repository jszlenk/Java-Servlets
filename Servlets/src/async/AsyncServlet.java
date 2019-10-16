package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AsyncServlet", urlPatterns = {"/AsyncServlet"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Progress Servlet </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Entering doGet(), Thread Name: " + Thread.currentThread().getName() + "</p>");
        out.println("<progress id='progress' max='100'></progress>");

        AsyncContext acontext = request.startAsync();

        acontext.start(() -> {
            out.print("<p>Executing Long Running Task using Thread : " + Thread.currentThread().getName() + "</p>");

            int i = 0;

            while (i <= 100) {

                out.println("<script>document.getElementById('progress').value = '" + i++ + "' ; </script>");
                out.flush();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }

            out.println("<p>Completed the long running task... </p>");
            acontext.complete();
        });

        out.println("<p>Exiting doGet(), Thread Name : " + Thread.currentThread().getName() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
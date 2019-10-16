package logs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/Log4jServlet")
public class Log4jServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Logger logger = LogManager.getLogger(Log4jServlet.class);
		logger.info("Log Info: Entered the doGet Method for processing the request");
		
		response.setContentType("text/html");
		logger.info("Content Type has been set to text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>Log4j </title></head>");
		out.println("<body>");

		logger.info("Log Info: Started the Document Creation");

		out.println("<p>Logger Name : " + logger.getName() + "</p>");
		String param = request.getParameter("param");

		if (param == null || param.equals("")) {
			out.println("<p>Error : Please Provide the Value for the Parameter </p>");
			logger.error("Error : Please Provide the Value for the Parameter");
		}
		else{
			out.println("<p>Page is requested by : " + param);
			logger.warn("Log Message : Page is requested by " + param);
		}
		out.println("</body>");
		out.println("</html>");
	}
}
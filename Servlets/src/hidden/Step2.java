package hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Step2")
public class Step2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String guest = request.getParameter("guest");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
						
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Step2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Information</h3>");
		out.println("<p>Guest Name : " + guest + "</p>");
		out.println("<p>Email Id : " + email + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
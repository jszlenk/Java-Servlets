package hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Step1")
public class Step1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String guest = request.getParameter("guest");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Step1</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Welcome " + guest + "</h3>");
		out.println("<form name='form2' action='Step2' method='post'>");
		out.println("<input type='hidden' name='guest' value='" + guest +"'/>");
		out.println("<p>Enter Email Id : </p>");
		out.println("<p><input type='email' name='email' /></p>");
		out.println("<p><input type='submit' value='Send to Step2' name='send2' /> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
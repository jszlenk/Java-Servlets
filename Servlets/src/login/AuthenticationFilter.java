package login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Date;

//@WebFilter("/LoginServlet")
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    public void destroy() {
        System.out.println("destroy method is called in " + this.getClass().getName());
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("doFilter method is called in " + this.getClass().getName());
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password  = request.getParameter("password");
        String ipAddress = request.getRemoteAddr();
        String IP = InetAddress.getLocalHost().getHostAddress();


        if( username.equals("user") && password.equals("pass")){
            System.out.println("User logged in " + ipAddress + " IP:" + IP + " at " + new Date().toString());
            chain.doFilter(request, response);
        }
        else{
            PrintWriter out = response.getWriter();
            out.println("<h3>Sorry, You are not authorized to access this resource.</h3>");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init method is called in " + this.getClass().getName());
    }
}
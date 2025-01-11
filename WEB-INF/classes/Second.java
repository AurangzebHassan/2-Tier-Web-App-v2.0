import java.io.*;

import jakarta.servlet.http.*;

import jakarta.servlet.*;



public class Second extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		PrintWriter out = response.getWriter();



		out.println("<html><head><title>My First Servlet</title></head>");

		out.println("<body style=\'display:flex; align-items:center; justify-content:center; background-color:crimson; color:white;\'>");

		out.println("<h1>Welcome to my Second Servlet!</h1>");

		out.println("</body>");

		out.println("</html>");



		out.close();
    }
}
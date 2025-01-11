import java.io.*;

import jakarta.servlet.http.*;

import jakarta.servlet.*;



public class Greeting extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();


        String firstName = request.getParameter("firstName");
	
		
        String surname = request.getParameter("surname");


        boolean userFound = false;



        try 
		{
            // Read from file
			
				File file = new File(getServletContext().getRealPath("/Usernames.txt"));
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line;
				

            while ((line = reader.readLine()) != null) 
			{
                String[] Name_Parts = line.split(" ");


                if (Name_Parts.length == 2) 
				{
                    String f_name = Name_Parts[0];
					
                    String s_name = Name_Parts[1];


                    if (((firstName != null) && (surname != null)) && ((firstName.toUpperCase().equals(f_name.toUpperCase())) && (surname.toUpperCase().equals(s_name.toUpperCase())))) 
					{
                        userFound = true;
						
                        break;
                    }
                }
			}
		
			reader.close();
		} 
		
		
		
		catch (IOException e) 
		{
            System.err.println("ERROR WHILE READING FROM THE FILE: " + e.getMessage());
        }



        if (userFound) 
		{
            out.println("<html>");
            
			out.println("<head>");
            
			out.println("<title>Servlet GreetingServlet</title>");
            
			out.println("</head>");
            
			out.println("<body style=\'display:flex; flex-direction:column; align-items:center; justify-content:center; background-color:crimson; color:white;\'>");
            
			out.println("<h1 style=\'margin-bottom:30px; margin-top:215px;\'> LOGIN SUCCESSFUL! <br> </h1>");

			out.println("<h1> Welcome, <strong>" + firstName.toUpperCase() + "</strong> <strong>" + surname.toUpperCase() + "</strong>! </h1>");
            
			out.println("</body>");
            
			out.println("</html>");
        } 
		
		
		
		else 
		{
            out.println("<html>");
            
			out.println("<head>");
            
			out.println("<title>Servlet GreetingServlet</title>");
            
			out.println("</head>");
            
			out.println("<body style=\'display:flex; flex-direction:column; align-items:center; justify-content:center; background-color:crimson; color:white;\'>");
            
			out.println("<h1 style=\'margin-bottom:30px; margin-top:215px;\'> LOGIN UNSUCCESSFUL! <br> </h1>");

			out.println("<h1> <strong>" + firstName.toUpperCase() + "</strong> <strong>" + surname.toUpperCase() + "</strong> is not signed up! </h1>");
            
			out.println("</body>");
            
			out.println("</html>");
        }

        out.close();
    }
}

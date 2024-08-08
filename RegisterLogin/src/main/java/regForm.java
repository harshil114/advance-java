

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.PrintWriter;


public class regForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public regForm() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		String myname = request.getParameter("name1");
		String myemail = request.getParameter("email1");
		String mypass = request.getParameter("pass1");
		String mygender = request.getParameter("gender1");
		String mycity = request.getParameter("city1");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","1143");
			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");	
			
			ps.setString(1, myname);
			ps.setString(2,myemail);
			ps.setString(3, mypass);
			ps.setString(4, mygender);
			ps.setString(5,mycity);
			
			int count = ps.executeUpdate();
			if(count>0)
			{
				out.print("Register Successfully");
			}
			else 
			{
				out.print("Not Register");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}

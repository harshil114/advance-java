

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class regForm2
 */
public class regForm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regForm2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
//				out.print("Register Successfully");
				response.sendRedirect("regSuccess.jsp");
			}
			else 
			{
//				out.print("Not Register");
				response.sendRedirect("regFaild.jsp");
				
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}

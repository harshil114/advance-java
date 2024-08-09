

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
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
import java.sql.ResultSet;

/**
 * 
 */
public class loginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginForm() {
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
		
//		PrintWriter out = response.getWriter();
		
		String myemail  =request.getParameter("email1");
		String mypassword = request.getParameter("pass1");
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","1143");
			
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				response.sendRedirect("loginSuccess.jsp");

			}
			else
			{
				response.sendRedirect("loginFaild.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}

}

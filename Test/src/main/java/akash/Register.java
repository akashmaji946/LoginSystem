package akash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obtain the parameter values using getParameter()
		
		String uname = request.getParameter("name");
		String upass = request.getParameter("pass");
		String uphone = request.getParameter("phone");
		String uemail = request.getParameter("email");
		
		// try printing the details  so obtained
		response.getWriter().append(uname + "  => " + upass + " => " + uphone + " => " + uemail);
		response.getWriter().append("<br>");
		
		//try printing the connection object
		response.getWriter().println(ConnectionProvider.getConnectionFromMySQL());
		response.getWriter().append("<br>");
		
		// get the connection object and perform query on it
		Connection connection = ConnectionProvider.getConnectionFromMySQL();
		
		try {
			// prepare sql update statement
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Login VALUES(?, ?, ?, ?);");
			
			// set the values
			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, uphone);
			ps.setString(4, uname);
			
			// execute update query
			int status = ps.executeUpdate();
			
			// if executeUpdate() return +ve integer then it means those many rows are updated
			if(status > 0) {
				response.getWriter().append("Data Added" + " Status:" + status);
			}else {
				response.getWriter().append("Data NOT Added" + " Status:" + status);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			response.getWriter().append("<br>");
		}
		
		
		
		
	}

}

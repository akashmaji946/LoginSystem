package akash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("You are successfully logged in");

		// obtain the parameter values using getParameter()

		String upass = request.getParameter("pass");

		String uemail = request.getParameter("email");

		response.getWriter().println(uemail + " " + upass);
		response.getWriter().println("<br>");

		// try printing the connection object
		response.getWriter().println(ConnectionProvider.getConnectionFromMySQL());
		response.getWriter().append("<br>");

		Connection connection = ConnectionProvider.getConnectionFromMySQL();
		response.getWriter().append("<br>");

		try {
			// prepare sql update statement
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Login WHERE email = ? AND pass = ?;");

			// set the values
			ps.setString(1, uemail);
			ps.setString(2, upass);

			// execute the query
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				response.getWriter().append("<h2>You are successfully logged in</h2>");
				response.getWriter().append("<br>");
			} else {
				response.getWriter().append("<h3>You are not valid user. Please retry.</h3>");
				response.getWriter().append("<br>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.getWriter().append("<br>");
		}

	}

}

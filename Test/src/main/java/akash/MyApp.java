package akash;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyApp
 */
public class MyApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("doGet() method").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("doPost() method").append(request.getContextPath());
	}
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.getWriter().append("HttpServlet service() method").append(request.getContextPath());
    } 
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.getWriter().append("GenericServlet service() method");  // no getContextpath();
	}

}

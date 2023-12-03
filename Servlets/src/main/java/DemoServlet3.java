


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DemoServlet3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//model -1 virtual page 
				PrintWriter pw=response.getWriter();
				String user=request.getParameter("user");
				String pwd=request.getParameter("pwd");
				if(user.equals(pwd)) {
					response.sendRedirect("success.html");
				}
				else {
					pw.print("<html>"
							+ "<body>"
							+ "<h1>login failed with username "+user +"</h1>"
							+ "</body>"
							+ "</html>");

				}
				
				
	}

}

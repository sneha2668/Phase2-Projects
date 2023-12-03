
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DemoServlet4() {
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
				pw.print(user+" "+pwd);
				//when we include a physical response with the virtual response it is considered as a text
			    response.setContentType("text/html");
				RequestDispatcher rd=request.getRequestDispatcher("success.html");
			//RequestDispatcher rd=request.getRequestDispatcher("User");
				rd.include(request, response);
				
				
	}

}





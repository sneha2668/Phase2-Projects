import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.HibernateUtil;

@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InitHibernate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            out.println("Attempting to open Hibernate Session...<br>");

            SessionFactory factory = HibernateUtil.getSessionFactory();

            if (factory != null) {
                out.println("Hibernate SessionFactory obtained.<br>");
                Session session = factory.openSession();
                out.println("Hibernate Session opened.<br>");
                session.close();
                out.println("Hibernate Session closed.<br>");
            } else {
                out.println("Error: Hibernate SessionFactory is null.<br>");
            }

            out.println("</body></html>");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}



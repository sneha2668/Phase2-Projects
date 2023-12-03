
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {
            // Load properties file
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/Config.properties");
            if (in == null) {
                throw new IOException("Could not load config.properties file");
            }

            Properties props = new Properties();
            props.load(in);

            // Create DBConnection and execute stored procedure
            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
            CallableStatement stmt = conn.getConnection().prepareCall("{call add_product(?, ?)}");
            stmt.setString(1, "New Product");
            stmt.setBigDecimal(2, new BigDecimal("1900.50"));
            stmt.executeUpdate();

            out.println("Stored procedure has been executed.<br>");
            stmt.close();
            conn.closeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            // Handle database-related exceptions
            e.printStackTrace();
            out.println("Error executing the stored procedure.<br>");
        } catch (IOException e) {
            // Handle file-related exceptions
            e.printStackTrace();
            out.println("Error loading configuration file.<br>");
        } finally {
            out.println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

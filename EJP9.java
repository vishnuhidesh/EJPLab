import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("EJP9")
public class EJP9 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the session
        HttpSession session = request.getSession();

        // Get the current visit count from the session
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        // If it's the first visit, initialize the count to 1
        if (visitCount == null) {
            visitCount = 1;
        } else {
            // Increment the visit count for subsequent visits
            visitCount++;
        }

        // Set the updated visit count back into the session
        session.setAttribute("visitCount", visitCount);

        // Display the visit count
        out.println("<html><head><title>Visit Counter</title></head><body>");
        out.println("<h2>Visit Counter</h2>");
        out.println("<p>Total number of visits to this page: " + visitCount + "</p>");
        out.println("</body></html>");
    }
}

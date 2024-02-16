import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student Details</title></head><body>");
        out.println("<h2>Student Details</h2>");

        String roll = request.getParameter("roll");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String qualification = request.getParameter("qualification");
        String percentage = request.getParameter("percentage");

        out.println("<p><strong>Roll:</strong> " + roll + "</p>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Age:</strong> " + age + "</p>");
        out.println("<p><strong>Sex:</strong> " + sex + "</p>");
        out.println("<p><strong>Qualification:</strong> " + qualification + "</p>");
        out.println("<p><strong>Percentage of Marks:</strong> " + percentage + "%</p>");

        out.println("</body></html>");
    }
}

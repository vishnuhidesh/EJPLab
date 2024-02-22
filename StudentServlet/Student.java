// Student.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Student extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Using GET Method to Read Form Data";
    out.println("<html>");
    out.println("<b>Name</b>: " + request.getParameter("name") + "<br />");
    out.println("<b>Roll No</b>: " + request.getParameter("roll") + "<br />");
    out.println("<b>Age</b>: " + request.getParameter("age") + "<br />");
    out.println("<b>Sex</b>: " + request.getParameter("sex") + "<br />");
    out.println("<b>Qualification</b>: " + request.getParameter("qualification") + "<br />");
    out.println("<b>Percentage of Mark</b>: " + request.getParameter("percent") + "<br />");
    out.println("</html>");
  }
}

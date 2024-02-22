import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class SessionTrack extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String title = "Welcome back to my website";
        Integer visitCount = 0;
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID = "ABCD";

        if (session.isNew()) {
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userID = (String) session.getAttribute(userIDKey);
        }

        session.setAttribute(visitCountKey, visitCount);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2><b>Session Information</h2>");
        out.println("<br><b>Session info:" + session.getId());
        out.println("<br><b>Time of LastAccess:" + lastAccessTime);
        out.println("<br><b>User ID:" + userID);
        out.println("<br><b>Number of visits:" + visitCount);
    }
}

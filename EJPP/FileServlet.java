import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class FileServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        String name = req.getParameter("filename");
        BufferedReader br = new BufferedReader(new FileReader("c:/" + name));
        String str;
        
        while ((str = br.readLine()) != null) {
            pw.println(str + "<br>");
        }
        
        br.close();
        pw.close();
    }
}

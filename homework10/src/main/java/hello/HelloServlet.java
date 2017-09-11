package hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;


public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Writer writer = response.getWriter();

        response.sendRedirect("/JSP/welcome-page.jsp");
//        writer.append("heeeeelllloooo");
//        writer.flush();
//        writer.close();
    }
}

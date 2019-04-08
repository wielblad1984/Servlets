package servlet.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/demo")
public class Level extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestParameter = req.getParameter("requestParameter");

        HttpSession session = req.getSession();

        PrintWriter writer = resp.getWriter();

        if(requestParameter!=null){
            writer.write(requestParameter);
        }

        writer.write(requestParameter);

        Object sessionParameter = session.getAttribute("sessionParameter");

        if (sessionParameter != null) {
            writer.write((String) sessionParameter);
        } else {
            writer.write("No session paramiter");
        }
        session.setAttribute("sessionParameter", requestParameter);
    }
}

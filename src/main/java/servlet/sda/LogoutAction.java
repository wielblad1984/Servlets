package servlet.sda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/LogoutAction")
public class LogoutAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();

        resp.addCookie(generateLogoutCookie());

        resp.sendRedirect("login.jsp");


    }
    private Cookie generateLogoutCookie(){
        Cookie cookie=new Cookie("userCookieId", "");
        cookie.setMaxAge(0);
        return cookie;
    }
}

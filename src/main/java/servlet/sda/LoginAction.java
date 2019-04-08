package servlet.sda;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/LoginAction")
public class LoginAction extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        //logika logowania
        Optional<User> userByLogin = userService.getUserByLogin(login);
        if (userByLogin.isPresent() && isUserPasswordCOrrect(userByLogin.get(), password)) {

            int userId= userByLogin.get().getId();
            req.getSession().setAttribute("loggerUserId", userId);
            Cookie cookie= new Cookie("userCookieId", Integer.toString(userId));
            resp.addCookie(cookie);
            resp.sendRedirect("secret/posts.jsp");

        } else {
            resp.sendRedirect("errorLoginPage.jsp");
        }
    }

    private boolean isUserPasswordCOrrect(User user, String requestedPassword) {
        return user.getPassword().equals(requestedPassword);

    }
}

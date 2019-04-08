package filters;

import model.User;
import service.UserRegisterException;
import service.UserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;


@WebFilter(urlPatterns ="/secret/*" )
public class AuthFilter implements Filter{

    private UserService userService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserService();

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Cookie[] cookies = httpServletRequest.getCookies();
        //sprawdzenie czy w sesji jest ciasteczko
        String cookieValue="";
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("userCookieId")){
                cookieValue=cookies[i].getValue();
            }
        }
        //sprzawdzenie czy w sesji jest user
        Integer loggerUserId=(Integer)httpServletRequest.getSession().getAttribute("loggerUserId");

        if(cookieValue.equals("")||
                !cookieValue.equals(loggerUserId.toString())){

            throw new AuthException();

        }

        filterChain.doFilter(servletRequest,servletResponse);

    }



    @Override
    public void destroy() {

    }
}

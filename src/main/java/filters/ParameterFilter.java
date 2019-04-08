package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = "/")
public class ParameterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        Enumeration<String> atributesNames =servletRequest.getAttributeNames();

        while (atributesNames.hasMoreElements()){
            String attributeName=atributesNames.nextElement();
            String parameterValue=httpServletRequest.getParameter(attributeName);
            System.out.println(parameterValue);
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}

package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(
        filterName = "Logging filter",
        urlPatterns = "/hello",
        initParams = {@WebInitParam(name="name",value="value")}
)

public class LoggingFilter implements Filter {

    private final Logger logger=Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.warning(filterConfig.getInitParameter("name"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("protocol is" + servletRequest.getProtocol());
        logger.info("remote host is " + servletRequest.getRemoteHost());
        logger.info("content type is " + servletRequest.getContentType());
        logger.info("content length is " + servletRequest.getContentLength());

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

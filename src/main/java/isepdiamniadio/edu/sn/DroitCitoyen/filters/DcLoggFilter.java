package isepdiamniadio.edu.sn.DroitCitoyen.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;



@Component
public class DcLoggFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger("loggingFilter");
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String remoteAddr = request.getRemoteAddr();
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String httpMethod = request.getMethod();
        String browser = request.getHeader("User-Agent");
        String language = request.getHeader("Accept-Language");

        logger.info("remoteAddr: " + remoteAddr);
        logger.info("requestURI: " + requestURI);
        logger.info("queryString: " + queryString);
        logger.info("httpMethod: " + httpMethod);
        logger.info("browser: " + browser);
        logger.info("language: " + language);
    }
}

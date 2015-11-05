package no.conduct.resources;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleCORSFilter implements Filter {

    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletResponse r = (HttpServletResponse) response;
        r.setHeader("Access-Control-Allow-Origin", "*");
        chain.doFilter(request, response);

    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}
package com.example.springbootessentials.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * This filter logs every incoming HTTP request with method and URI.
 * It runs before the request reaches any controller or service.
 */
@Component
public class RequestLoggingFilter implements Filter {

    /**
     * Called once when the filter is initialized.
     * Currently unused, but useful for setting up resources.
     */

    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Called for every HTTP request. Logs method and URI, then forwards to next
     * filter or controller.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 🌐 Log the HTTP method and URI of the incoming request
        System.out.println(
                "🚀 Incoming request: " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());

        try {
            // 🔁 Continue the filter chain: pass control to the next filter or ultimately
            // the target controller
            chain.doFilter(request, response);
        } catch (IOException | ServletException ex) {
            // ❌ Exception caught in the filter layer
            System.err.println("❌ Exception caught in Filter: " + ex.getMessage());

            // 📌 Note: If this exception is not caught here, it is automatically handled by
            // the servlet container (like Tomcat),
            // which will generate a default HTTP error response (e.g., 500 Internal Server
            // Error).
            throw ex; // 🔁 Rethrow the exception if you want the default servlet container behavior
        }
    }

    /**
     * Called once when the filter is being destroyed.
     * Useful for cleanup operations.
     */
    @Override
    public void destroy() {
        // No cleanup logic required for now.
    }

}

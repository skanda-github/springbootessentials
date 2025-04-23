package com.example.springbootessentials.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Interceptor that measures the execution time of each HTTP request handled by the application.
 * Implements Spring's HandlerInterceptor interface.
 *
 * Interceptors in Spring MVC allow you to run custom logic before and after controller execution.
 */
public class ExecutionTimeInterceptor implements HandlerInterceptor {

    /**
     * This method is called BEFORE the controller method is invoked.
     * 
     * Here we store the current system time in milliseconds as a request attribute.
     * This will be used later to calculate how long the request took to process.
     *
     * @return true to continue with the next interceptor or controller
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis()); // ⏱️ Mark the start time
        return true; // ✅ Continue with the next interceptor or controller
    }

    /**
     * This method is called AFTER the complete request is finished (including rendering the view).
     *
     * We calculate the difference between the current time and the start time stored earlier.
     * This gives us the total time taken to handle the request.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long start = (long) request.getAttribute("startTime"); // ⏱️ Retrieve start time from request
        long executionTime = System.currentTimeMillis() - start; // 🧮 Calculate execution duration
        System.out.println("🕒 Request to " + request.getRequestURI() + " took " + executionTime + " ms"); // 📤 Log execution time
    }

}

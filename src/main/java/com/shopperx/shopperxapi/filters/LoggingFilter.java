package com.shopperx.shopperxapi.filters;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingFilter extends OncePerRequestFilter{

    @Override
    public void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {  
        System.out.println("the servlet request parsed" + request.getRequestURI());
        filterChain.doFilter(request, response);
     
    }

}

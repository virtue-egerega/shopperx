package com.shopperx.shopperxapi.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {  
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("the servlet request parsed" + httpRequest.getRequestURI());
        filterChain.doFilter(request, response);
    }

}

package net.accounting.filters;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public abstract class BaseFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        doFilter((HttpServletRequest)servletRequest, (HttpServletResponse)servletResponse, filterChain);
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain);

    public void destroy() {
        System.out.println("Filter was destroyed");
    }
}

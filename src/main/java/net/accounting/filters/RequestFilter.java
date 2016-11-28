package net.accounting.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 14-Apr-16.
 */
public class RequestFilter extends BaseFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
        String pattern = " dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String protocol = request.getProtocol();
        String method = request.getMethod();
        String queryString = request.getQueryString();
        String ip = request.getRemoteAddr();
        System.out.println("Request started here >>>>>> " + "\n"
                + "Protocol: " + protocol + "\n"
                + "Method: " + method + "\n"
                + "QueryString: " + queryString + "\n"
                + "IP: " + ip + "\n"
                + "Time" + dateFormat.format(new Date()) + "\n"
                + "The end of request  <<<<<<");

        chain.doFilter(request, response);
    }
}

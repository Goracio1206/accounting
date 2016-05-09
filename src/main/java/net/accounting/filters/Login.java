package net.accounting.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Admin on 28-Apr-16.
 */
public class Login extends BaseFilter {
    public static final String USER_LOGGED_IN = "logged";
    public static final String PAGE_LOGIN = "index.jsp";


    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        if (loggedIn != null) {
            if (!loggedIn.equals("true")){
            request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }
}

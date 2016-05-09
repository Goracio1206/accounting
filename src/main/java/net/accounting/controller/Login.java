package net.accounting.controller;

import net.accounting.Entity.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.UserDao;
import net.accounting.dao.impl.SearchUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by vitalii.nedzelskyi on 18.04.2016.
 */
public class Login extends HttpServlet {
    public static final String USER_LOGGED = "logged";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String ATTRIBUTE_USER_TO_VIEW = "user";
    public static final String PAGE_FOR_USER = "jsp/user.jsp";
    public static final String PAGE_ERROR = "jsp/error.jsp";

    UserDao aUser = new SearchUserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter(USER_EMAIL);
        String userPassword = request.getParameter(USER_PASSWORD);

        HttpSession session = request.getSession();
        String loginCheck = (String) session.getAttribute(USER_LOGGED);
        if(loginCheck == null) {
            session.setAttribute(USER_LOGGED, "true");
        }

        if (userName != null & userPassword != null) {
            try{
                User user = aUser.selectUser(userName, userPassword);
                if (user != null) {
                request.setAttribute(ATTRIBUTE_USER_TO_VIEW, user);
                request.getRequestDispatcher(PAGE_FOR_USER).forward(request, response);
                return;
                } else {
                    response.sendRedirect(PAGE_ERROR);
                }
            } catch (DaoSystemExceptions| NoSuchUserException ignore) {
                /*NOP*/
            }
        }
    }

}

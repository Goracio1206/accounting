package net.accounting.controller;

import net.accounting.Entity.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.UserDao;
import net.accounting.dao.impl.SearchUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii.nedzelskyi on 24.05.2016.
 */

public class Login extends HttpServlet {
    private static final String USER_EMAIL = "email";
    private static final String USER_PASWORD = "password";
    private static final String ATTRIBUTE_TO_VIEW_USER = "user";
    private static final String PAGE_USER = "jsp/user.jsp";
    private static final String PAGE_ERROR = "jsp/error.jsp";

    UserDao aUser = new SearchUserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter(USER_EMAIL);
        String userPassword = request.getParameter(USER_PASWORD);

        try {
            User user = aUser.selectUser(userEmail, userPassword);
            if(user != null) {
                Cookie aCookie = new Cookie("user_id",String.valueOf(user.getId()));
                request.getSession().setAttribute("logged", "true");
                response.addCookie(aCookie);
                response.sendRedirect("/main.com");
                //request.getRequestDispatcher("/main.com").forward(request, response);
                return;
            }
        } catch (DaoSystemExceptions | NoSuchUserException e) {
            /*NOP*/
        }
        response.sendRedirect(PAGE_ERROR);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

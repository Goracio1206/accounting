package net.accounting.controller;

import net.accounting.Users.User;
import net.accounting.dao.Exceptions.NoSuchUserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii.nedzelskyi on 18.04.2016.
 */
public class Login extends HttpServlet {
    public static final String USER_NAME = "name";
    public static final String USER_PASSWORD = "password";
    public static final String ATTRIBUTE_USER_TO_VIEW = "user";
    public static final String PAGE_FOR_USER = "user.jsp";
    public static final String PAGE_ERROR = "error.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter(USER_NAME);
        String userPassword = request.getParameter(USER_PASSWORD);
        if (userName != null & userPassword != null) {
            try{
                User user = new User(5, userName, userPassword);
                request.setAttribute(ATTRIBUTE_USER_TO_VIEW, user);
                request.getRequestDispatcher(PAGE_FOR_USER).forward(request, response);
                return;
            } catch (Exception e){
                /*NOP*/
            }
        }
        response.sendRedirect(PAGE_ERROR);
    }

}

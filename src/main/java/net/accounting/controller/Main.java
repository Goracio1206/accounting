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

public class Main extends HttpServlet {
    private static final String USER_ID_COOKIE = "user_id";

    UserDao userDAO = new SearchUserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie userID_cookie = null;
        Cookie[] aCookies = request.getCookies();
        if (aCookies != null) {
            for (Cookie set : aCookies){
                if (set.getName().equals(USER_ID_COOKIE)){
                    userID_cookie = set;
                }
            }
        }
        User aUser = null;
        try {
            aUser = userDAO.selectByID(Integer.valueOf(1/*userID_cookie.getValue())*/)); // Commented because user id returned incorrect after refresh
        } catch (NoSuchUserException | DaoSystemExceptions e) {
            e.printStackTrace();
        }
        request.setAttribute("user", aUser);
        request.getRequestDispatcher("jsp/user.jsp").forward(request,response);

        response.getWriter().write("bla lba");
    }
}

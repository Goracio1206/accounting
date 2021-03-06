package net.accounting.controller;

import net.accounting.Entity.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.UserDao;
import net.accounting.dao.impl.SearchUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            aUser = userDAO.selectUserByID(Integer.valueOf(userID_cookie.getValue()));
        } catch (NoSuchUserException | DaoSystemExceptions e) {
            e.printStackTrace();
        }
        request.setAttribute("user", aUser);
        request.getRequestDispatcher("jsp/user.jsp").forward(request,response);

    }
}

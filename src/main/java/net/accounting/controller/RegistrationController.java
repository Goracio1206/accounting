package net.accounting.controller;

import net.accounting.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.UserAlreadyExistException;
import net.accounting.dao.UserDao;
import net.accounting.dao.impl.SearchUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii.nedzelskyi on 25.04.2016.
 */
@WebServlet(name = "RegistrationController")
public class RegistrationController extends HttpServlet {
    public static final String USER_NAME = "UserName";
    public static final String USER_PASSWORD = "Password";
    public static final String USER_PASSWORD_CONFIRMARION = "PasswordConfirm";
    public static final String ATTRIBUTE_USER_TO_VIEW = "user";
    public static final String PAGE_OK = "WEB-INF/jsp/user.jsp";
    public static final String PAGE_ERROR = "jsp/error.jsp";

    private UserDao DB = new SearchUserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter(USER_NAME);
        String userPassword = request.getParameter(USER_PASSWORD);
        String userConfirmPassword = request.getParameter(USER_PASSWORD_CONFIRMARION);

        if(firstName != null & userPassword != null & userConfirmPassword != null & userPassword.equals(userConfirmPassword)) {
            try {
                User aUser = new User(firstName, userPassword);
                DB.createNewUser(aUser.getId(), aUser.getFirstName(), aUser.getPassword());

                request.setAttribute(ATTRIBUTE_USER_TO_VIEW, aUser);
                request.getRequestDispatcher(PAGE_OK).forward(request, response);
                return;
            } catch (DaoSystemExceptions | UserAlreadyExistException ignore){
                /*NOP*/
            }
        }
        response.sendRedirect(PAGE_ERROR);

    }

}

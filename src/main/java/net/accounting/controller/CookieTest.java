package net.accounting.controller;

import com.sun.org.apache.bcel.internal.classfile.FieldOrMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii.nedzelskyi on 19.04.2016.
 */
public class CookieTest extends HttpServlet {
    private static final String COOKIE_NAME = "counter";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie fromClient = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie aCookie : cookies ){
                if (COOKIE_NAME.equals(aCookie.getName())){
                    fromClient = aCookie;
                    break;
                }
            }
        }

        if (fromClient == null) {
            response.addCookie(new Cookie(COOKIE_NAME, "" + 1));
            response.getWriter().write("You visit this site: 1 time");
        } else {
            int visitCounter = Integer.valueOf(fromClient.getValue());
            response.addCookie(new Cookie(COOKIE_NAME, "" + (++visitCounter)));
            response.getWriter().write("You visit this site: " + visitCounter + " times");
        }
    }
}

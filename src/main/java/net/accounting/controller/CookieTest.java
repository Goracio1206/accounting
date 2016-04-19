package net.accounting.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii.nedzelskyi on 19.04.2016.
 */
public class CookieTest extends HttpServlet {
    private static final String COOKIE_NAME = "caunter";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie fromClient = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            
        }
    }
}

package net.accounting.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitalii.nedzelskyi on 19.04.2016.
 */

public class SessionDemo extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession aSession = request.getSession();
        AtomicInteger counter = (AtomicInteger) aSession.getAttribute("counter");
        if (counter == null) {
            counter = new AtomicInteger(1);
            aSession.setAttribute("counter", counter );
        }
        int numberOfVisit = counter.getAndIncrement();
        response.getWriter().write("You visit this site: " + numberOfVisit + " times");
    }
}

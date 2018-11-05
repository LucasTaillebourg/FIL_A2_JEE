package com.jee.services;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoggerService {

    public static void verifyLogState(HttpServletRequest request, HttpServletResponse reponse, ServletContext servletContext) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        boolean islogged = httpSession.getAttribute("isLogged") != null;

        if(!islogged){
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/login");
            if ( requestDispatcher != null ) {
                requestDispatcher.forward(request,reponse);
            }
        }
    }

    public static void verifyAlreadyLog(HttpServletRequest request, HttpServletResponse reponse, ServletContext servletContext) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        boolean islogged = httpSession.getAttribute("isLogged") != null;

        if(islogged){
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/home");
            if ( requestDispatcher != null ) {
                requestDispatcher.forward(request,reponse);
            }
        }

    }
}

package com.jee.servlet;

import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.models.User;
import com.jee.services.LoggerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException {
        process(request, reponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException {
        process(request, reponse);
    }

    protected void process(HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        RequestDispatcher requestDispatcher;

        //si on est dejà loggé on va sur /home
        HttpSession httpSession = request.getSession();

        LoggerService.verifyAlreadyLog(request, reponse, getServletContext());

        String login = request.getParameter( "login" );
        String password = request.getParameter( "password" );

        // si les champs n'ont pas été remplis, par exemple premier chargement de la page
        if(login == null || password == null){
            requestDispatcher = request.getRequestDispatcher("/jsp/pages/login.jsp");
            requestDispatcher.include(request, reponse) ;
        }else{
            boolean isLogged = false;

            User user = new User();
            user.setEmail(login);
            user.setPassword(password);
            
            Collection users = user.findPassWordByEmail(user.getEmail());
            Iterator it = users.iterator();
            while (it.hasNext()) {
            	String passwordDb =  (String) it.next();
            	if (passwordDb.equals(user.getPassword())) {
            		isLogged = true;
            		break;
            	}
            }
            if(isLogged){
                requestDispatcher = getServletContext().getRequestDispatcher("/home");

                if(httpSession.getAttribute("isLogged") == null){
                    httpSession.setAttribute("isLogged", "true");
                }
                if ( requestDispatcher != null ) {
                    requestDispatcher.forward(request,reponse);
                }
            }else{
                requestDispatcher = request.getRequestDispatcher("/jsp/pages/login.jsp");
                request.setAttribute("error", "error");
            }
        }

        //request.setAttribute("mapKey", mapApiUrl);

        requestDispatcher.include(request, reponse) ;
    }
}

package com.jee.servlet.login;

import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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

        boolean islogged = httpSession.getAttribute("isLogged") != null;

        if(islogged){
            requestDispatcher = getServletContext().getRequestDispatcher("/home");
            if ( requestDispatcher != null ) {
                requestDispatcher.forward(request,reponse);
            }
        }


        String login = request.getParameter( "login" );
        String password = request.getParameter( "password" );

        // si les champs n'ont pas été remplis, par exemple premier chargement de la page
        if(login == null || password == null){
            requestDispatcher = request.getRequestDispatcher("/jsp/pages/login.jsp");
            requestDispatcher.include(request, reponse) ;
        }else{
            boolean isLogged = true; // TODO bdd
            //TODO vérifier dans la bdd que le mot de passe correspond à l'utilisateur, flemme de crypter :')

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

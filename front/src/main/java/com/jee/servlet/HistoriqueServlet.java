package com.jee.servlet;

import com.jee.services.LoggerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/historique")
public class HistoriqueServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException {
        process(request, reponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException {
        process(request, reponse);
    }

    protected void process(HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        RequestDispatcher requestDispatcher;

        //Avant tout on vérifié si on est connecté :

        HttpSession httpSession = request.getSession();

        LoggerService.verifyLogState(request, reponse, getServletContext());



        //TODO FER DAI TRUKS

        requestDispatcher = request.getRequestDispatcher("/jsp/pages/historique.jsp");

        requestDispatcher.include(request, reponse) ;
    }
}

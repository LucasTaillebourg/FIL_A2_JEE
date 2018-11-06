package com.jee.servlet;

import com.jee.bean.CityBean;
import com.jee.bean.MeasureBean;
import com.jee.bean.Nature;
import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.bean.alertes.Warnings;
import com.jee.services.LoggerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/flags")
public class FlagServlet extends HttpServlet {

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

        List<Warnings> warnings = new ArrayList<>();
        CityBean city = new CityBean("NTE","Nantes",null);
        new SensorBean(1,city);
        warnings.add(new Warnings(new AlerteBean("temp max","temps","30", ">", "grave"), new MeasureBean(null,Nature.TEMPERATURE, (float) 30.5, LocalDateTime.now())));
        warnings.add(new Warnings(new AlerteBean("temp max","temps","50", ">", "grave"), new MeasureBean(null,Nature.TEMPERATURE, (float) 30.5, LocalDateTime.now())));
        
        //TODO Rediriger connexion toussa toussa

     
        request.setAttribute("warnings", warnings);

        requestDispatcher = request.getRequestDispatcher("/jsp/pages/flag.jsp");

        requestDispatcher.include(request, reponse) ;
    }
}

package com.jee.servlet;

import com.jee.bean.MeasureBean;
import com.jee.bean.Nature;
import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.bean.alertes.Warnings;
import com.jee.models.Alerte;
import com.jee.models.Measure;
import com.jee.services.LoggerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
        Alerte alerte = new Alerte();
        Measure measure = new Measure();
        Collection alertes = alerte.getAllAlertes();
        Iterator it = alertes.iterator();
        while (it.hasNext()) {
        	alerte = (Alerte) it.next();
        	AlerteBean alerteBean = new AlerteBean(alerte.getIntitule(), alerte.getType(), alerte.getSeuil(), alerte.getOperande(), alerte.getGravite());
            Collection mesures = measure.findAlertes(alerte, Timestamp.valueOf(LocalDateTime.now()));
            Iterator itMeasure = mesures.iterator();
            while (itMeasure.hasNext()) {
            	measure = (Measure) itMeasure.next();
            	SensorBean sensorBean = new SensorBean(measure.getSensor());
            	warnings.add(new Warnings(alerteBean, new MeasureBean(sensorBean,Nature.TEMPERATURE, (float) 30.5, LocalDateTime.now())));
            }
            
        }

     
        request.setAttribute("warnings", warnings);

        requestDispatcher = request.getRequestDispatcher("/jsp/pages/flag.jsp");

        requestDispatcher.include(request, reponse) ;
    }
}

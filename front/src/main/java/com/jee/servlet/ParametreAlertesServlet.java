package com.jee.servlet;

import com.jee.bean.MeasureBean;
import com.jee.bean.Nature;
import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.bean.alertes.Warnings;
import com.jee.models.Alerte;
import com.jee.models.Measure;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@WebServlet("/parametreAlertes")
public class ParametreAlertesServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        process(request, reponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {
        process(request, reponse);
    }

    protected void process(HttpServletRequest request, HttpServletResponse reponse)
            throws IOException, ServletException {

        RequestDispatcher requestDispatcher;

        List<AlerteBean> alerteBeans = new ArrayList<>();

        //TODO fetch les infos sur une plage horaire

        //TODO trier les infos pour garder des alertes

        //FIXME en dessous alertes à la main à retirer

        Alerte alerte = new Alerte();
        Measure measure = new Measure();
        Collection alertes = alerte.getAllAlertes();
        Iterator it = alertes.iterator();
        while (it.hasNext()) {
        	alerte = (Alerte) it.next();
        	AlerteBean alerteBean = new AlerteBean(alerte.getIntitule(), alerte.getType(), alerte.getSeuil(), alerte.getOperande(), alerte.getGravite());
            alerteBeans.add(alerteBean);
            
        }
        

        request.setAttribute("alertesBeans", alerteBeans);
        requestDispatcher = request.getRequestDispatcher("/jsp/pages/parametreAlertesPage.jsp");

        requestDispatcher.include(request, reponse) ;
    }

}

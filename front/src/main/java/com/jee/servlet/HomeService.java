package com.jee.servlet;

import com.jee.bean.CityBean;
import com.jee.bean.MeasureBean;
import com.jee.bean.Nature;
import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.bean.alertes.Warnings;

//import com.jee.services.LoggerService;
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

@WebServlet("/home")
public class HomeService extends HttpServlet {

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

        List<SensorBean> sensorBeans = new ArrayList<>();
        //TODO get la vrai liste des marker

        SensorBean sensorBean1 = new SensorBean();
        sensorBean1.setLat((float) 40.702147);
        sensorBean1.setLon((float) -74.015794);

        SensorBean sensorBean2 = new SensorBean();
        sensorBean2.setLat((float) 40.711614);
        sensorBean2.setLon((float) -74.012318);

        SensorBean sensorBean3 = new SensorBean();
        sensorBean3.setLat((float) 40.718217);
        sensorBean3.setLon((float) -73.998284);

        sensorBeans.add(sensorBean1);
        sensorBeans.add(sensorBean2);
        sensorBeans.add(sensorBean3);


        StringBuilder mapApiUrl = new StringBuilder();

        mapApiUrl.append("https://maps.googleapis.com/maps/api/staticmap");
        //TODO determiner au dessus de quoi on se place
        mapApiUrl.append("?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap");


        sensorBeans.forEach(sensorBean ->
            mapApiUrl.append("&markers=color:blue%7Clabel:S%7C")
                     .append(sensorBean.getLat())
                     .append(",")
                     .append(sensorBean.getLon())
        );


        mapApiUrl.append("&key=AIzaSyAi63CLYJ_yEODZcRLLvWyixDMDmEougdA"); // Ma clé perso, ne pas réutiliser - Lucas


       //todo fetch dans la table
        List<AlerteBean> alerteConf = new ArrayList<>();
        List<Warnings> warnings = new ArrayList<>();
        CityBean city = new CityBean("NTE","Nantes",null);
        new SensorBean(1,city);
        warnings.add(new Warnings(new AlerteBean("temp max","temps","30", ">", "grave"), new MeasureBean(null,Nature.TEMPERATURE, (float) 30.5, LocalDateTime.now())));
        warnings.add(new Warnings(new AlerteBean("temp max","temps","50", ">", "grave"), new MeasureBean(null,Nature.TEMPERATURE, (float) 30.5, LocalDateTime.now())));
        
        //TODO Rediriger connexion toussa toussa

       
        request.setAttribute("alertesConf", alerteConf);
        request.setAttribute("warnings", warnings);

        request.setAttribute("mapKey", mapApiUrl);
        requestDispatcher = request.getRequestDispatcher("/jsp/pages/home.jsp");

        requestDispatcher.include(request, reponse) ;
    }
}

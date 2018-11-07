package com.jee.servlet;

import com.jee.bean.MeasureBean;
import com.jee.bean.SensorBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.bean.alertes.Warnings;
import com.jee.models.Alerte;
import com.jee.models.Measure;
import com.jee.models.Sensor;
import com.jee.services.LoggerService;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
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

//import com.jee.services.LoggerService;

@WebServlet("/home")
public class HomeService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException {
		process(request, reponse);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse reponse)
			throws IOException, ServletException {
		process(request, reponse);
	}

	protected void process(HttpServletRequest request, HttpServletResponse reponse)
			throws IOException, ServletException {
		RequestDispatcher requestDispatcher;

		// Avant tout on vérifié si on est connecté :

		HttpSession httpSession = request.getSession();

		LoggerService.verifyLogState(request, reponse, getServletContext());


		// todo fetch dans la table
		List<AlerteBean> alerteConf = new ArrayList<>();
		List<Warnings> warnings = new ArrayList<>();

		Alerte alerte = new Alerte();
		Measure measure = new Measure();
		Collection alertes = alerte.getAllAlertes();
		Iterator it = alertes.iterator();
		while (it.hasNext()) {
			alerte = (Alerte) it.next();
			AlerteBean alerteBean = new AlerteBean(alerte.getIntitule(), alerte.getType(), alerte.getSeuil(),
					alerte.getOperande(), alerte.getGravite());
			Collection mesures = measure.findAlertes(alerte, Timestamp.valueOf(LocalDateTime.now().minusHours(2)),
					Timestamp.valueOf(LocalDateTime.now()));
			Iterator itMeasure = mesures.iterator();
			while (itMeasure.hasNext()) {
				measure = (Measure) itMeasure.next();
				SensorBean sensorBean = new SensorBean(measure.getSensor());
				warnings.add(new Warnings(alerteBean,
						new MeasureBean(measure)));
			}

		}

		List<SensorBean> sensorsBean = new ArrayList<>();

		Sensor sensor = new Sensor();
		Collection sensors = sensor.findAllSensors();
		Iterator itSensor = sensors.iterator();
		while (itSensor.hasNext()) {
			sensor = (Sensor) itSensor.next();
			sensorsBean.add(new SensorBean(sensor));

		}

		JsonArrayBuilder sensorsJson =  Json.createArrayBuilder();
		for (SensorBean sensorObject : sensorsBean) {
			sensorsJson.add(
					Json.createObjectBuilder()
					.add("id", sensorObject.getId())
					.add("city", sensorObject.getCity().getName())
					.add("lon", sensorObject.getLon())
					.add("lat", sensorObject.getLat())
					.build());
		}
		request.setAttribute("alertesConf", alerteConf);
		request.setAttribute("warnings", warnings);
		request.setAttribute("sensors", sensorsJson.build());

		requestDispatcher = request.getRequestDispatcher("/jsp/pages/home.jsp");

		requestDispatcher.include(request, reponse);
	}
}

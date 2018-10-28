package com.jee.servlet.parametreAlertes;

import com.jee.bean.alertes.AlerteBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

        AlerteBean alerteBean = new AlerteBean();
        alerteBean.setGravite("pas grave");
        alerteBean.setIntitule("temperature max bean");
        alerteBean.setSeuil("<30");
        alerteBean.setType("temperature");

        AlerteBean alerteBean1 = new AlerteBean();
        alerteBean1.setGravite("grave");
        alerteBean1.setIntitule("temperature min bean");
        alerteBean1.setSeuil(">10");
        alerteBean1.setType("temperature");

        alerteBeans.add(alerteBean);
        alerteBeans.add(alerteBean1);

        request.setAttribute("alertesBeans", alerteBeans);
        requestDispatcher = request.getRequestDispatcher("/jsp/pages/parametreAlertesPage.jsp");

        requestDispatcher.include(request, reponse) ;
    }

}

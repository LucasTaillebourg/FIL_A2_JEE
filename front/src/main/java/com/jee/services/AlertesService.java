package com.jee.services;

import com.jee.bean.MeasureBean;
import com.jee.bean.alertes.AlerteBean;
import com.jee.bean.alertes.Warnings;

import java.util.ArrayList;
import java.util.List;

public class AlertesService {


    public static List<Warnings> getAlertes(List<AlerteBean> paramsAlertes, List<MeasureBean> mesures){
        List<Warnings> alertes = new ArrayList<>();
        paramsAlertes.forEach(alerteBean -> alertes.addAll(AlertesService.getAlertesForParam(alerteBean, mesures)));

        return alertes;
    }

    private static List<Warnings> getAlertesForParam(AlerteBean param, List<MeasureBean> mesures){
        List<Warnings> alertes = new ArrayList<>();

        mesures.forEach(measureEntity -> AlertesService.addMeasureIfRespectParam(alertes, param, measureEntity));

        return alertes;
    }

    private static void addMeasureIfRespectParam(List<Warnings> alertes, AlerteBean param, MeasureBean mesure){
        if(mesure.getNature().toString().equals(param.getType())){
            switch (param.getOperator()){
                case "<" :
                    if(mesure.getValue() < Double.valueOf(param.getSeuil())) alertes.add(new Warnings(param, mesure));
                    break;
                case ">" :
                    if(mesure.getValue() > Double.valueOf(param.getSeuil())) alertes.add(new Warnings(param, mesure));
                    break;
                default: //do-nothing
            }
        }
    }
}

package com.jee.services;

import com.jee.bean.alertes.AlerteBean;
import com.jee.models.Measure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertesService {


    public static Map<Measure, String> getAlertes(List<AlerteBean> paramsAlertes, List<Measure> mesures){
        Map<Measure, String> alertes = new HashMap<>();
        paramsAlertes.forEach(alerteBean -> alertes.putAll(AlertesService.getAlertesForParam(alerteBean, mesures)));

        return alertes;
    }

    private static Map<Measure, String> getAlertesForParam(AlerteBean param, List<Measure> mesures){
        Map<Measure, String> alertes = new HashMap<>();

        mesures.forEach(measureEntity -> AlertesService.addMeasureIfRespectParam(alertes, param, measureEntity));

        return alertes;
    }

    private static void addMeasureIfRespectParam(Map<Measure, String> alertes, AlerteBean param, Measure mesure){
        if(mesure.getNature().equals(param.getType())){
            switch (param.getOperator()){
                case "<" :
                    if(mesure.getValue() < Double.valueOf(param.getSeuil())) alertes.put(mesure, param.getGravite());
                    break;
                case ">" :
                    if(mesure.getValue() > Double.valueOf(param.getSeuil())) alertes.put(mesure, param.getGravite());
                    break;
                default: //do-nothing
            }
        }
    }
}

package com.jee.services;

import com.jee.bean.alertes.AlerteBean;
import com.jee.models.MeasureEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertesService {


    public static Map<MeasureEntity, String> getAlertes(List<AlerteBean> paramsAlertes, List<MeasureEntity> mesures){
        Map<MeasureEntity, String> alertes = new HashMap<>();
        paramsAlertes.forEach(alerteBean -> alertes.putAll(AlertesService.getAlertesForParam(alerteBean, mesures)));

        return alertes;
    }

    private static Map<MeasureEntity, String> getAlertesForParam(AlerteBean param, List<MeasureEntity> mesures){
        Map<MeasureEntity, String> alertes = new HashMap<>();

        mesures.forEach(measureEntity -> AlertesService.addMeasureIfRespectParam(alertes, param, measureEntity));

        return alertes;
    }

    private static void addMeasureIfRespectParam(Map<MeasureEntity, String> alertes, AlerteBean param, MeasureEntity mesures){
        if(mesures.getNature().equals(param.getType())){
            
        }
    }
}

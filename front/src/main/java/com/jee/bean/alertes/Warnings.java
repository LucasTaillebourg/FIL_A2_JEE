package com.jee.bean.alertes;

import com.jee.bean.MeasureBean;

public class Warnings {

	AlerteBean alerte;
	MeasureBean mesure;

	public Warnings(AlerteBean alerte, MeasureBean mesure) {
		super();
		this.alerte = alerte;
		this.mesure = mesure;
	}

	public AlerteBean getAlerte() {
		return alerte;
	}

	public void setAlerte(AlerteBean alerte) {
		this.alerte = alerte;
	}

	public MeasureBean getMesure() {
		return mesure;
	}

	public void setMesure(MeasureBean mesure) {
		this.mesure = mesure;
	}

}

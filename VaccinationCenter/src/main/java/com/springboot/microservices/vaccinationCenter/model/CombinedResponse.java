package com.springboot.microservices.vaccinationCenter.model;

import java.util.List;

import com.springboot.microservices.vaccinationCenter.entity.VaccinationCenter;

public class CombinedResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;

	public VaccinationCenter getCenter() {
		return center;
	}

	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	@Override
	public String toString() {
		return "CombinedResponse [center=" + center + ", citizens=" + citizens + "]";
	}
}

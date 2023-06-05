package com.springboot.microservices.vaccinationCenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String vaccinationCenter;

	@Column
	private String vaccinationAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(String vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	public String getVaccinationAddress() {
		return vaccinationAddress;
	}

	public void setVaccinationAddress(String vaccinationAddress) {
		this.vaccinationAddress = vaccinationAddress;
	}

	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", vaccinationCenter=" + vaccinationCenter + ", vaccinationAddress="
				+ vaccinationAddress + "]";
	}
}

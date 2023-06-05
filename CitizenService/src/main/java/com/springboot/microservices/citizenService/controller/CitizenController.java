package com.springboot.microservices.citizenService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.citizenService.entity.Citizen;
import com.springboot.microservices.citizenService.repository.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	private CitizenRepo citizenRepo;

	@RequestMapping(path = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	@RequestMapping(path = "/id/{id}")
	public ResponseEntity<java.util.List<Citizen>> getById(@PathVariable Integer id) {
		List<Citizen> listCitizen = citizenRepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen,HttpStatus.OK);
	}

	@RequestMapping(path = "/addCitizen")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
		Citizen citizen = citizenRepo.save(newCitizen);
		return new ResponseEntity<>(citizen, HttpStatus.OK);
	}

}

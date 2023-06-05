package com.springboot.microservices.vaccinationCenter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.microservices.vaccinationCenter.entity.VaccinationCenter;
import com.springboot.microservices.vaccinationCenter.model.Citizen;
import com.springboot.microservices.vaccinationCenter.model.CombinedResponse;
import com.springboot.microservices.vaccinationCenter.repository.VaccinationCenterRepo;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterRepo vaccinationCenterRepo;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(path = "/addVaccinationCenter")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter newVaccinationCenter) {
		VaccinationCenter vaccinationCenter = vaccinationCenterRepo.save(newVaccinationCenter);
		return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
	}

	@GetMapping(path = "/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDowntime")
	public ResponseEntity<CombinedResponse> getAllDataBasedOnCenterId(@PathVariable Integer id) {
		CombinedResponse combinedResponse = new CombinedResponse();
		// Get vaccination center details
		VaccinationCenter center = vaccinationCenterRepo.findById(id).get();
		combinedResponse.setCenter(center);

		// Get list of citizens registered to the vaccination center
		java.util.List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/" + id,
				List.class);
		combinedResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<CombinedResponse>(combinedResponse, HttpStatus.OK);
	}

	public ResponseEntity<CombinedResponse> handleCitizenDowntime(@PathVariable Integer id) {
		CombinedResponse combinedResponse = new CombinedResponse();
		VaccinationCenter center = vaccinationCenterRepo.findById(id).get();
		combinedResponse.setCenter(center);
		return new ResponseEntity<CombinedResponse>(combinedResponse, HttpStatus.OK);
	}
}

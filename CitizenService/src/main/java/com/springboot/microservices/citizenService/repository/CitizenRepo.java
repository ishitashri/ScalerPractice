package com.springboot.microservices.citizenService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.microservices.citizenService.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	public List<Citizen> findByVaccinationCenterId(Integer id);
}

package com.springboot.first.rest.app.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.rest.app.jpa.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}

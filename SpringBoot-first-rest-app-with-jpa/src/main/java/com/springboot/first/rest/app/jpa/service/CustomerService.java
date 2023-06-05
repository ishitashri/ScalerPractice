package com.springboot.first.rest.app.jpa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.first.rest.app.jpa.entity.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(Long id);
	public Customer updateCustomer(Customer customer, Long id);
	public void deleteCustomer(Long id);
	
	public ResponseEntity<Object> uploadFileToReseource(MultipartFile file);
}

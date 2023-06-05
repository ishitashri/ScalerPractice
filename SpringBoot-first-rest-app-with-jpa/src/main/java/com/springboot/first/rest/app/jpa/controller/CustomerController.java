package com.springboot.first.rest.app.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.first.rest.app.jpa.entity.Customer;
import com.springboot.first.rest.app.jpa.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable("id") Long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomerByCustomerId(@PathVariable("id") Long id,
			@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomerByCustomerId(Long id) {
		customerService.deleteCustomer(id);
	}
	
	@PostMapping("/uploadFile")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file){
		return new ResponseEntity<Object>(customerService.uploadFileToReseource(file),HttpStatus.OK);
	}
}
 
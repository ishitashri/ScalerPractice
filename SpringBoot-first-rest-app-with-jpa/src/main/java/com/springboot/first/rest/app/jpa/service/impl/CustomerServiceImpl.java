package com.springboot.first.rest.app.jpa.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.first.rest.app.jpa.entity.Customer;
import com.springboot.first.rest.app.jpa.repository.ICustomerRepository;
import com.springboot.first.rest.app.jpa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private String FILE_DIRECTORY = "D:\\Ishita\\Practise\\ScalerPractice\\SpringBoot-first-rest-app-with-jpa\\src\\main\\resources\\static\\UploadFiles";

	private ICustomerRepository customerRepository;

	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.getById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		Customer existingCustomer = customerRepository.getById(id);
		existingCustomer.setName(customer.getName());
		existingCustomer.setAge(customer.getAge());
		existingCustomer.setLocation(customer.getLocation());
		customerRepository.save(existingCustomer);
		return customer;
	}

	@Override
	public void deleteCustomer(Long id) {
		Customer existingCustomer = customerRepository.getById(id);
		if (existingCustomer.getId() == id) {
			customerRepository.deleteById(id);
		}
	}

	@Override
	public ResponseEntity<Object> uploadFileToReseource(MultipartFile file) {
		File myFile = new File(FILE_DIRECTORY + file.getOriginalFilename());
		FileOutputStream fos;
		try {
			myFile.createNewFile();
			fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("File uploaded successfully", HttpStatus.OK);
	}
}

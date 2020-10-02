package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CustomerM>findAll(){
		
		return customerRepository.findAll();
	
}
	@Override
	public CustomerM findById (String cusId) {
		Optional<CustomerM> opt = customerRepository.findById(cusId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	// add 
	@Override
	public CustomerM addCustomer(CustomerM customerM) {
		
		return customerRepository.save(customerM);
	}
	
	//update
	@Override
	public CustomerM updateCustomer(CustomerM customerM) {
		Optional<CustomerM> opt = customerRepository.findById(customerM.getCusId());		
		if(opt.isPresent()) {
			 return customerRepository.save(customerM);
		}
		return null;
	}
	
	//delete 
	@Override
	public String deleteCustomer(String cusId) {
		Optional<CustomerM> opt = customerRepository.findById(cusId);
		if(opt.isPresent()) {
			customerRepository.deleteById(cusId);
			return "deleted";
		}
		return "Customer Does not exist";
	}
}

package com.khatabook.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khatabook.dao.CustomerService;

import com.khatabook.entities.Customer;

import com.khatabook.presentation.CustomCustomer;
import com.khatabook.presentation.CustomCustomerResponse;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getcustomers")
	public ResponseEntity<?> getCustomers(){
		try {
			ArrayList<Customer> customers=customerService.getCustomers();
			ArrayList<CustomCustomer> customCustomerList = new ArrayList<>();
			
			for (Customer customer : customers) {
				CustomCustomer customCustomer = new CustomCustomer(customer.getId(), customer.getName(), customer.getPhone(),
						customer.getUser().getId());
				customCustomerList.add(customCustomer);
		    }
			return ResponseEntity.status(HttpStatus.OK).body(customCustomerList);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}
	
	// ROUTE 2: Add a new Customer using: GET "/api/customer/addcustomers". Login required
	@PostMapping("/addcustomer")
	public ResponseEntity<?> AddCustomer(@RequestBody Map<String, String> reqBody){
	try {
		
		if(!reqBody.containsKey("name") || !reqBody.containsKey("phone"))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Either of name or phone field is missing");
		}
		
		String name= reqBody.get("name");
		String phone=reqBody.get("phone");
		
		Long userId=(long) 1;
		if(customerService.findByUserIdAndPhoneNo(userId, phone))
		{
			Map<String, String> object = new HashMap<>();
		    object.put("danger", "Customer Already Exists");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(object);
		}
		CustomCustomer customer=customerService.addCustomer(name,phone,userId);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	} 
	catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	}
}
	
	@PostMapping("/updatecustomer/{id}")
	public ResponseEntity<?> UpdateCustomer(@PathVariable("id ") Long id, @RequestBody Map<String, String> reqBody)
	{
		try {
			
			if(!reqBody.containsKey("name") && !reqBody.containsKey("phone"))
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Neither of name or phone field is provided");
			}
			
			String name= reqBody.get("name");
			String phone=reqBody.get("phone");
			Object updatedCustomer = customerService.updateCustomer(id,name,phone);
	        if (updatedCustomer instanceof Integer) {
	        	if((Integer)updatedCustomer==409) {
	        		return ResponseEntity.status(HttpStatus.CONFLICT).body("Customer with that Phone number already exist");
	        	}
	        	else {
	        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate name or phone number provided");
	        	}
	        }
//	        else if (updatedCustomer instanceof Optional) {
	        	@SuppressWarnings("unchecked")
				Optional<Customer> optionalUpdatedCustomer= (Optional<Customer>)updatedCustomer;
	        	if(optionalUpdatedCustomer.isPresent()) {
	        		Customer customer = optionalUpdatedCustomer.get();
	        		return ResponseEntity.status(HttpStatus.OK).body(customer);
	        	}
	        	else {
	        		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found with given Id");
	        	}
//	        }
		} 
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}

	@PostMapping("/deletecustomer/{id}")
	public ResponseEntity<CustomCustomerResponse> DeleteCustomer(@PathVariable("id ") Long id)
	{
		try {
			
			CustomCustomerResponse deletedCustomer = customerService.deleteCustomer(id);
			return ResponseEntity.status(deletedCustomer.getStatus_code()).body(deletedCustomer);
		} 
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			CustomCustomerResponse customCustomerResponse =new CustomCustomerResponse(500, "Error", "Internal Server Error", null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customCustomerResponse);
		}
	}

}

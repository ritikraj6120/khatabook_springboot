package com.khatabook.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khatabook.entities.Customer;
import com.khatabook.entities.User;
import com.khatabook.presentation.CustomCustomer;
import com.khatabook.presentation.CustomCustomerResponse;

@Service
public class CustomerService {
	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers= new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public boolean findByUserIdAndPhoneNo(Long userId,String phone) {
		ArrayList<Customer> customers=customerRepository.findByUserIdAndPhone(userId,phone);
		if(customers.isEmpty())
			return false;
		return true;
	}
	
	public CustomCustomer addCustomer(String name,String phone,Long userId)
	{
		Customer customer=new Customer();
		User user = null;
		Optional<User> dbUser=userRepository.findById(userId);
		customer.setName(name);
		customer.setPhone(phone);
		if(dbUser.isPresent()) 
		    user = dbUser.get();
		customer.setUser(user);
		customer = customerRepository.save(customer);
		return new CustomCustomer(customer.getId(), customer.getName(), customer.getPhone(),
		user.getId());
	}
	
	public CustomCustomerResponse updateCustomer(Long customerId,String name,String phone)
	{
		Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			if(name!=null)
			{
				// same name exists do not proceed ahead
				if(customer.getName()==name)
					return 400;
				else customer.setName(name);
			}
			if(phone!=null)
			{
				Optional<Customer> customerByPhoneNo=customerRepository.findByPhone(phone);
				if(customerByPhoneNo.isPresent()) {
					// if new phone number exists with someone do not proceed ahead
					if(customerByPhoneNo.get().getId()!=customer.getId())
						return 409;
					// if id matches that means provided phone number actually exists in DB so duplicate phone number
					// provided by client.
					else return 400;
				}
				customer.setPhone(phone);
			}
			customerRepository.save(customer);
			CustomCustomer customCustomer = new CustomCustomer(customer.getId(), customer.getName(), customer.getPhone(),
			customer.getUser().getId());
			return Optional.of(customCustomer);
		}else {
			CustomCustomer nullableValue = null;
			return Optional.ofNullable(nullableValue);
		}
		
		
	}
	
	
	
	public CustomCustomerResponse deleteCustomer(Long customerId)
	{
		Long userId=1L;
		Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			// Allow deletion only if user owns this customer
			if(customer.getUser().getId()!=userId)
			{
				return new CustomCustomerResponse(403, "Error", "Not Authorized", null);
			}
			 customerRepository.delete(customer);
			 return new CustomCustomerResponse(200, "Success", "Customer has been deleted", 
					 new CustomCustomer(customer.getId(), customer.getName(), customer.getPhone(), userId));
			 // will do it in future
			 // await CustomerTransactions.deleteMany({ customer: id });
			 // await customerNetBalance.deleteMany({ customer: id });
		}else {
			return new CustomCustomerResponse(404, "Error", "Customer not found", null);
		}
	}
	
}

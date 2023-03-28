package com.khatabook.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.khatabook.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	public ArrayList<Customer> findByUserIdAndPhone(Long userId,String phone);
	public Optional<Customer> findByPhone(String phone);
}

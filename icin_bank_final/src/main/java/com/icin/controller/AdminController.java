package com.icin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icin.model.Transaction;
import com.icin.model.User;
import com.icin.service.TransactionService;
import com.icin.serviceImpl.AdminServiceImpl;
import com.icin.exceptions.ResourceNotFoundException;

@RestController
public class AdminController {
	
	 @Autowired
	 private TransactionService transactionService;
	 
	 @Autowired
	    private AdminServiceImpl adminService;
	
	@RequestMapping(path = "/admin/getallusers", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")

	public List<User> getAllUsers() throws Exception
	{
			
			return adminService.getAllUsers();
	}
	
	
	@RequestMapping(path = "/admin/transactions/{accountId}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")

	public List<Transaction> retrieveTransactionsForAccount(int accountId) throws Exception
	{
			
			return transactionService.retrieveTransactionsForAccount(accountId);
	}

	
	
	
	
	
	@RequestMapping(path = "/admin/getuser/{id}", method = RequestMethod.GET)
	public User getuser(@PathVariable("id")int id) throws ResourceNotFoundException{
		User user;
		try {
			user=adminService.getUserById(id);
			return user;
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("User not found for this id :: " + id);
		
		}
	}




	@RequestMapping(path = "/admin/deleteuser/{id}", method = RequestMethod.DELETE)
	public void deleteuser(@PathVariable("id") int id) throws ResourceNotFoundException
	{
		try {
			adminService.deleteUserById(id);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("User not found for this id :: " + id);
			
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

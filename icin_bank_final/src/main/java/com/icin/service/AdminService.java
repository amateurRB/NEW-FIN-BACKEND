package com.icin.service;

import java.util.List;
import java.util.Optional;

import com.icin.model.Transaction;
import com.icin.model.User;

public interface AdminService {
	
	 public List<User> getAllUsers();
		List<Transaction> retrieveTransactionsForAccount(int accountNumber);
		
		
		//void deleteUserById(Long id);
		User getUserById(int id);
		void deleteUserById(int id);

}

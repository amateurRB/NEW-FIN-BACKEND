package com.icin.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.MyRepo;
import com.icin.dao.PrimaryAccountDao;
import com.icin.dao.TransactionRepository;
import com.icin.dao.UserRepo;
import com.icin.model.Transaction;
import com.icin.model.User;
import com.icin.service.AdminService;



@Service
public class AdminServiceImpl implements AdminService{
	
	
	
	  @Autowired
	    private UserRepo userRepoDao;
	  
	  @Autowired
	  private TransactionRepository transactionRepository;
	  
	  @Autowired
	  private MyRepo repo;
	  
	  
	  
	  
	  
	 

	@Override
	  public List<User> getAllUsers(){
			return (List<User>) userRepoDao.findAll();
			
		}

	@Override
public List<Transaction> retrieveTransactionsForAccount(int accountId) {
        
        return transactionRepository.retrieveTransactionsForAccount(accountId);
    }
	
	
	
	@Override
	public User getUserById(int id) {
		return userRepoDao.findById(id);
		
	}
	
	@Override
	public void deleteUserById(int id) {
		userRepoDao.delete(userRepoDao.findById(id));
		
	}
	

}

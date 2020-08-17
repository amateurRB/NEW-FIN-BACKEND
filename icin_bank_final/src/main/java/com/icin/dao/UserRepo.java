package com.icin.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icin.model.Transaction;
import com.icin.model.User;


@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	User findByMailid(String mailid);

	User findByFullname(String name);
	
	List<User> getAllUsers();
	
	User findById(int id);

	User deleteById(User findById);

	void delete(User findById);

	//User findById(Long id);


	//Object delete(Optional<User> findById);
	
	//public Optional<User> findById(Long id);

}

package com.cg.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.repository.UserRepository;

@Service 
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findAllByid(int UserId)
	{
		
		return userRepo.getAllByid(UserId);
	}
 
}
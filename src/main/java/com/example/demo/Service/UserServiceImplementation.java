package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Lesson;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService {
	UserRepository userRepository;
	
@Autowired
	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public String addUser(Users users) {
		
		userRepository.save(users);
		return "student registerd successfully........!";
	}

	@Override
	public boolean checkEmail(String email) {
		
				return userRepository.existsByEmail(email);

	}

	@Override
	public boolean validate(String email, String password) {
		if(userRepository.existsByEmail(email))
		{
			Users user=userRepository.getByEmail(email);
			String dbpassword=user.getPassword();
			if(password.equals(dbpassword))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
		
	}

	@Override
	public Users getUser(String email) {
		return userRepository.getByEmail(email);
	}

	@Override
	public String getUserRole(String email) {
		// TODO Auto-generated method stub
		Users user=userRepository.getByEmail(email);
		return user.getRole();
		
	}

	@Override
	public String updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

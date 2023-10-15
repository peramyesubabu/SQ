package com.example.demo.Service;
import com.example.demo.Entity.Lesson;
import com.example.demo.Entity.Users;

public interface UserService {
	
  String addUser(Users users);
 
  boolean checkEmail( String email);
  
   boolean validate(String email,String password);
   
   Users getUser(String email);
   
   String getUserRole(String email);
   
   String updateUser(Users user);


   
	
}
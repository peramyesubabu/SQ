package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Users;
import com.example.demo.Service.TrainerService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lms")
public class LMSController {
	UserService userService;
	TrainerService trainerService;
	
	@Autowired
public LMSController(UserService userService, TrainerService trainerService) {
		super();
		this.userService = userService;
		this.trainerService = trainerService;
	}

@GetMapping("/register")
public String register()
{
	return "register";
}

@GetMapping("/login")
public String login()
{
	return "login";
}

//user Login
@PostMapping("/validate")
public String validate(@RequestParam("email")String email, @RequestParam("password")String password,HttpSession session)
{
	if(userService.checkEmail(email))
	{
		boolean val=userService.validate(email, password);
		
		if(val==true)
		{
			Users user=userService.getUser(email);
			
			session.setAttribute("loggedInUser" ,user);
			
			if(userService.getUserRole(email).equals("teacher"))
			{
				return "teacherhome";
			}
			else
			{
				return "learnerhome";
			}
			
		}
		else
		{
			System.out.println("incorrect credentials, try again!");
			return "login";
		}
	}
	return "login";
}


@GetMapping("/registerFail")
public String registerFail()
{
	return "registerFail";
}

//User Registration
	@PostMapping("/adduser")
	public String adduser(@RequestParam("name")String name, @RequestParam("email") String email,@RequestParam("password") String password , @RequestParam("role") String role)
	{
		boolean emailExists=userService.checkEmail(email);
		 if(emailExists==false)
		 {
			Users users=new Users();
			users.setName(name);
			users.setEmail(email);
			users.setPassword(password);
			users.setRole(role);
			
			userService.addUser(users);
			
			System.out.println("user registered successfully");
			return "redirect:/lms/login";
			
		 }
		 else
		 {
			 System.out.println("user already registered");
			 return "redirect:/lms/registerFail";
		 }
		 
	}
	
	
	
	
	@GetMapping("/purchase")
	public String showCourses(Model theModel,HttpSession session)
	{
		Users users=(Users) session.getAttribute("loggedInUser");
		List<Course> courseList=trainerService.courseList();
		theModel.addAttribute("courselist", courseList);
		theModel.addAttribute("user", users);
		return "purchase";
	}

	
}

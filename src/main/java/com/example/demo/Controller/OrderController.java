package com.example.demo.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Users;
import com.example.demo.Service.TrainerService;
import com.example.demo.Service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
@RequestMapping("ordercontroller")
public class OrderController {
	
	@Autowired
	UserService userService;
	@Autowired
	TrainerService trainerService;
	


	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("amount") int amount,

	@RequestParam("email") String email,

	@RequestParam("courseId") int courseId) {

	// System.out.println(amount+email+courseId);

	Order order=null;

	try {

	RazorpayClient razorpay=new RazorpayClient("rzp_test_ANiFbfIjOIx3EF", "jgHc0g5bAebbeilwWX1uXP45");

	JSONObject orderRequest = new JSONObject();

	orderRequest.put("amount", amount*100); // amount in the smallest currency unit

	orderRequest.put("currency", "INR");

	orderRequest.put("receipt", "order_rcptid_11");

	order = razorpay.orders.create(orderRequest);

	attachCourse(email, courseId);

	} 
	catch (RazorpayException e) {

	// TODO Auto-generated catch block

	e.printStackTrace();

	}

	finally {

	return order.toString();

	}

	}
	
	
	private void attachCourse(String email, int courseId) {
		
		Course course=trainerService.getCourse(courseId);
		
		Users user =userService.getUser(email);
		
		user.getCourses().add(course);
		
		course.getUserList().add(user);
		
		userService.updateUser(user);
		
		trainerService.saveCourse(course);
		
	}

	

	
	
}



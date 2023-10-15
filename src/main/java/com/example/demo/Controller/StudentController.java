package com.example.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Comments;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.Lesson;
import com.example.demo.Entity.Users;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.TrainerService;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/studentController")
public class StudentController {
	TrainerService trainerService;
	UserService userService;
	
	StudentService studentService;
	CommentService commentService;
@Autowired
	public StudentController(TrainerService trainerService, UserService userService, StudentService studentService, CommentService commentService) {
		super();
		this.trainerService = trainerService;
		this.userService=userService;
		this.studentService=studentService;
		this.commentService=commentService;
	}
	
	
	@GetMapping("/purchase")
	public String showCourses(Model theModel,HttpSession session)
	{
		Users users=(Users) session.getAttribute("loggedInUser");
		List<Course> courselist=trainerService.courseList();
		theModel.addAttribute("courseList", courselist);
		theModel.addAttribute("loggedInUser", users);
		return "purchase";
	}
	
	
	@GetMapping("/fetchCourses")

	public String fetchCourses(Model model, HttpSession session) {

	Users loggedUser=(Users) session.getAttribute("loggedInUser");

	String email=loggedUser.getEmail();

	Users user=userService.getUser(email);

	List<Course> courseList=user.getCourses();

	model.addAttribute("courseList",courseList);

	return "myCourses";
	}
	
	
	
	@GetMapping("/viewLesson")

	public String viewLesson(@RequestParam("lessonId")int lessonId,

	Model model,HttpSession session) {

	 Users user = (Users) session.getAttribute("loggedInUser");

	Lesson lesson= studentService.getLesson(lessonId);

	// Extract the YouTube video id from the URL

	String youtubeUrl = lesson.getLink();

	String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);

	lesson.setLink(videoId);

	model.addAttribute("lesson",lesson);

	List<Comments> commentsList=commentService.commentList();

	model.addAttribute("comments",commentsList);

	return "myLesson";
	}

}

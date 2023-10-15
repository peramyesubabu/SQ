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
import com.example.demo.Entity.Lesson;
import com.example.demo.Service.TrainerService;
@Controller
@RequestMapping("/trainercontroller")
public class TrainerController {
	TrainerService trainerService;
	
@Autowired
	public TrainerController(TrainerService trainerService) {
		super();
		this.trainerService = trainerService;
	}


@GetMapping("/createCourse")
	public String createCourse()
	{
		return "createCourse";
	}
	
	
	//Add courses:-

		@PostMapping("/addCourse")
		public String addCourse(@RequestParam("courseId")int id, @RequestParam("courseName") String name,@RequestParam("coursePrice") int price)
		{
		Course course=new Course();
		course.setCourse_id(id);
		course.setCourse_name(name);
		course.setCourse_price(price);
		Course c=trainerService.addcourse(course);
		if(c!=null)
		{
			return "teacherhome";
		}
		else
		{
			return "createCourseFailed";
		}
		}
		
		
	
	
	@GetMapping("/addLesson")
	public String addLesson()
	{
		return "createLesson";
	}
	
	
	@PostMapping("/addLesson")

	public String lesson(@RequestParam("courseId")int courseId,

	@RequestParam("lessonId")int lessonId,

	@RequestParam("lessonName")String lessonName,

	@RequestParam("topics")String topics,

	@RequestParam("link")String link) {

	Course course=trainerService.getCourse(courseId);
	if(course ==null)
	{
		return "createLessonFailed";
	}
	else
	{

	Lesson lesson=new Lesson(lessonId,lessonName,topics,link,course);

	trainerService.addLesson(lesson);

	course.getLessons().add(lesson);

	trainerService.saveCourse(course);

	return "teacherhome";
	}
	
	}
	
	
	
	
	@GetMapping("/viewCourses")
	public String showCourses(Model theModel)
	{
		List<Course> courselist=trainerService.courseList();
		theModel.addAttribute("courseList", courselist);
		return "showcourses";
		
	}
	


}

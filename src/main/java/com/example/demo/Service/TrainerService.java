package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Lesson;

public interface TrainerService {
	public Course addcourse(Course course);
	
	public String saveCourse(Course course);
	
	public String addLesson(Lesson lesson);
	
	public Course getCourse(int courseId);
	
	public List<Course> courseList();

	public Lesson getLesson(int lessonId);
 
}

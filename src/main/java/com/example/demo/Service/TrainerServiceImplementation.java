package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Lesson;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.LessonRepository;
@Service
public class TrainerServiceImplementation implements TrainerService {
	
CourseRepository courseRepository;

LessonRepository lessonRepository;

@Autowired
public TrainerServiceImplementation(CourseRepository courseRepository, LessonRepository lessonRepository) {
	super();
	this.courseRepository = courseRepository;
	
	this.lessonRepository = lessonRepository;
}




@Override
public Course addcourse(Course course) {
	// TODO Auto-generated method stub
	return courseRepository.save(course);
}


@Override
public String saveCourse(Course course) {
	courseRepository.save(course);
	return "course saved successfully!";
}


@Override
public String addLesson(Lesson lesson) {
	lessonRepository.save(lesson);
	return "lesson added sccessfully!";
}


@Override
public Course getCourse(int courseId) {
	return courseRepository.findById(courseId).get();
}


@Override
public List<Course> courseList() {
	return courseRepository.findAll();
}




@Override
public Lesson getLesson(int lessonId) {
	// TODO Auto-generated method stub
	return null;
}

	

}

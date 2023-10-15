package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Lesson;
import com.example.demo.Repository.LessonRepository;
import com.example.demo.Repository.UserRepository;
@Service
public class StudentServiceImplementation implements StudentService {
	
	UserRepository userRepository;
	
	LessonRepository lessonRepository;
	
@Autowired
	public StudentServiceImplementation(UserRepository userRepository, LessonRepository lessonRepository)
{
		super();
		this.userRepository = userRepository;
		
		this.lessonRepository=lessonRepository;
	}



	@Override
	public Lesson getLesson(int lesson_id)
	{
		
		
		return lessonRepository.findById(lesson_id).get();
	}

}

package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Comments;
import com.example.demo.Repository.CommentRepositroy;

@Service
public class CommentServiceImplementation implements CommentService {
	
	
	CommentRepositroy commentRepositroy;
	
	@Autowired
	public CommentServiceImplementation(CommentRepositroy commentRepositroy) {
		super();
		this.commentRepositroy = commentRepositroy;
	}

	
	
	@Override
	public List<Comments> commentList() {
		// TODO Auto-generated method stub
		return commentRepositroy.findAll();
	}

	@Override
	public String addComment(Comments comment) {
		
		commentRepositroy.save(comment);
		return "comment added";
	}
	
	

	

}

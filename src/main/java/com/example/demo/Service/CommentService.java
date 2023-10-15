package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Comments;

public interface CommentService {
	
	public List<Comments> commentList();
	
	public String addComment(Comments comment);

}

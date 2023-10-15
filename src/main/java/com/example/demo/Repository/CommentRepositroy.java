package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Comments;

public interface CommentRepositroy extends JpaRepository<Comments, Integer> {

}

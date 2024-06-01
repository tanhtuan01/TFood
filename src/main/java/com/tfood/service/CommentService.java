package com.tfood.service;

import java.util.List;

import com.tfood.model.CommentDTO;

public interface CommentService {

	void addNewComment(int user, int food);
	
	int countComment(int id);
	
	float avgcommnet(int id);
	
	int countScore1(int id);
	
	int countScore2(int id);
	
	int countScore3(int id);
	
	int countScore4(int id);
	
	int countScore5(int id);
	
	int checkBought(int user, int food);
	
	int checkExistsComment(int user, int food);
	
	boolean updateComment(String content, int score, int user, int food);
	
	List<CommentDTO> getAllByFood(int food);
	
	double avgScore(int food);
	
	List<CommentDTO> getTop3Comment();
	
	int countCommentNotNull(int food);
}

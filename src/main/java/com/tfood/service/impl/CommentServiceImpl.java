package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.CommentDao;
import com.tfood.entity.Comment;
import com.tfood.model.CommentDTO;
import com.tfood.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDao commentDao;

	@Override
	public int countComment(int id) {
		// TODO Auto-generated method stub
		return commentDao.countComment(id);
	}

	@Override
	public float avgcommnet(int id) {
		// TODO Auto-generated method stub
		return commentDao.avgcommnet(id);
	}

	@Override
	public int countScore1(int id) {
		// TODO Auto-generated method stub
		return commentDao.countScore1(id);
	}

	@Override
	public int countScore2(int id) {
		// TODO Auto-generated method stub
		return commentDao.countScore2(id);
	}

	@Override
	public int countScore3(int id) {
		// TODO Auto-generated method stub
		return commentDao.countScore3(id);
	}

	@Override
	public int countScore4(int id) {
		// TODO Auto-generated method stub
		return commentDao.countScore4(id);
	}

	@Override
	public int countScore5(int id) {
		// TODO Auto-generated method stub
		return commentDao.countScore5(id);
	}

	@Override
	public void addNewComment(int user, int food) {
		// TODO Auto-generated method stub
		commentDao.addNewComment(user, food);
	}

	@Override
	public int checkBought(int user, int food) {
		// TODO Auto-generated method stub
		return commentDao.checkBought(user, food);
	}

	@Override
	public int checkExistsComment(int user, int food) {
		// TODO Auto-generated method stub
		return commentDao.checkExistsComment(user, food);
	}

	@Override
	public boolean updateComment(String content, int score, int user, int food) {
		// TODO Auto-generated method stub
		return commentDao.updateComment(content, score, user, food);
	}

	@Override
	public List<CommentDTO> getAllByFood(int food) {
		List<Comment> list = commentDao.getAllByFood(food);
		List<CommentDTO> list2 = new ArrayList<CommentDTO>();
		for(Comment comment : list) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setId(comment.getId());
			commentDTO.setFood(comment.getFood());
			commentDTO.setDate(comment.getDate());
			commentDTO.setScore(comment.getScore());
			commentDTO.setContent(comment.getContent());
			commentDTO.setImg(comment.getImg());
			commentDTO.setName(comment.getName());
			list2.add(commentDTO);
		}
		return list2;
	}

	@Override
	public double avgScore(int food) {
		// TODO Auto-generated method stub
		return commentDao.avgScore(food);
	}

	@Override
	public List<CommentDTO> getTop3Comment() {
		// TODO Auto-generated method stub
		List<Comment> list = commentDao.getTop3Comment();
		List<CommentDTO> list2 = new ArrayList<CommentDTO>();
		for(Comment comment : list) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setContent(comment.getContent());
			commentDTO.setDate(comment.getDate());
			commentDTO.setName(comment.getName());
			commentDTO.setImg(comment.getImg());
			list2.add(commentDTO);
		}
		return list2;
	}

	@Override
	public int countCommentNotNull(int food) {
		// TODO Auto-generated method stub
		return commentDao.countCommentNotNull(food);
	}

}

package com.tfood.dao;

import java.util.List;

import com.tfood.entity.Slider;

public interface SliderDao {

	List<Slider> getAll();
	
	void addSlider(Slider slider);
	
	void updateSlider(Slider slider);
	
	boolean deleteSlider(int id);
	
	int checkSttExistsBeforeAdd(int stt);
	
	int checkSttExists(int stt, int id);
}

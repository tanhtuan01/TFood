package com.tfood.service;

import java.util.List;

import com.tfood.model.SliderDTO;

public interface SliderService {

	List<SliderDTO> getAll();
	
	void addSlider(SliderDTO sliderDTO);
	
	void updateSlider(SliderDTO sliderDTO);
	
	boolean deleteSlider(int id);
	
	int checkSttExists(int stt, int id);
	
	int checkSttExistsBeforeAdd(int stt);
}

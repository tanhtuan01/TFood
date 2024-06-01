package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.SliderDao;
import com.tfood.entity.Slider;
import com.tfood.model.SliderDTO;
import com.tfood.service.SliderService;

@Service
public class SliderServiceImpl implements SliderService{
	
	@Autowired
	SliderDao sliderDao;
	
	@Override
	public List<SliderDTO> getAll() {
		List<Slider> list = sliderDao.getAll();
		List<SliderDTO> list2 = new ArrayList<SliderDTO>();
		for(Slider slider : list) {
			SliderDTO sliderDTO = new SliderDTO();
			sliderDTO.setId(slider.getId());
			sliderDTO.setDate(slider.getDate());
			sliderDTO.setImg(slider.getImg());
			sliderDTO.setNoiDung(slider.getNoiDung());
			sliderDTO.setStt(slider.getStt());
			list2.add(sliderDTO);
		}
		return list2;
	}

	@Override
	public void addSlider(SliderDTO sliderDTO) {
		// TODO Auto-generated method stub
		Slider slider = new Slider();
		slider.setImg(sliderDTO.getImg());
		slider.setNoiDung(sliderDTO.getNoiDung());
		slider.setStt(sliderDTO.getStt());
		sliderDao.addSlider(slider);
	}

	@Override
	public void updateSlider(SliderDTO sliderDTO) {
		// TODO Auto-generated method stub
		Slider slider = new Slider();
		slider.setImg(sliderDTO.getImg());
		slider.setNoiDung(sliderDTO.getNoiDung());
		slider.setStt(sliderDTO.getStt());
		slider.setId(sliderDTO.getId());
		sliderDao.updateSlider(slider);
	}

	@Override
	public boolean deleteSlider(int id) {
		// TODO Auto-generated method stub
		return sliderDao.deleteSlider(id);
	}

	@Override
	public int checkSttExists(int stt, int id) {
		// TODO Auto-generated method stub
		return sliderDao.checkSttExists(stt, id);
	}

	@Override
	public int checkSttExistsBeforeAdd(int stt) {
		// TODO Auto-generated method stub
		return sliderDao.checkSttExistsBeforeAdd(stt);
	}
	

}

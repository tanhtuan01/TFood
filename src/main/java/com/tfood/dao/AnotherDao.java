package com.tfood.dao;

import java.util.List;

import com.tfood.entity.AnotherAds;

public interface AnotherDao {

	List<AnotherAds> getRandom();
	
	List<AnotherAds> getAll();
	
	void addAds(AnotherAds ads);
	
	boolean deleteAds(int id);
	
	void updateAds(AnotherAds ads);
}

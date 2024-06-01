package com.tfood.service;

import java.util.List;

import com.tfood.model.AnotherAdsDTO;

public interface AnotherService {

	List<AnotherAdsDTO> getRandom();

	List<AnotherAdsDTO> getAll();
	
	void addAds(AnotherAdsDTO adsDTO);
	
	boolean deleteAds(int id);
	
	void updateAds(AnotherAdsDTO adsDTO);
}

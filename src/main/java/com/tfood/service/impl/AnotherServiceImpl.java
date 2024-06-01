package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.AnotherDao;
import com.tfood.entity.AnotherAds;
import com.tfood.model.AnotherAdsDTO;
import com.tfood.service.AnotherService;

@Service
public class AnotherServiceImpl implements AnotherService{

	@Autowired
	AnotherDao anotherDao;
	
	@Override
	public List<AnotherAdsDTO> getRandom() {
		List<AnotherAdsDTO> list = new ArrayList<AnotherAdsDTO>();
		List<AnotherAds> list2 = anotherDao.getRandom();
		for(AnotherAds ads : list2) {
			AnotherAdsDTO adsDTO = new AnotherAdsDTO();
			adsDTO.setContent(ads.getContent());
			adsDTO.setId(ads.getId());
			adsDTO.setLink(ads.getLink());
			adsDTO.setImg(ads.getImg());
			adsDTO.setDate(ads.getDate());
			list.add(adsDTO);
		}
		return list;
	}

	@Override
	public List<AnotherAdsDTO> getAll() {
		List<AnotherAdsDTO> list = new ArrayList<AnotherAdsDTO>();
		List<AnotherAds> list2 = anotherDao.getAll();
		for(AnotherAds ads : list2) {
			AnotherAdsDTO adsDTO = new AnotherAdsDTO();
			adsDTO.setContent(ads.getContent());
			adsDTO.setId(ads.getId());
			adsDTO.setLink(ads.getLink());
			adsDTO.setImg(ads.getImg());
			adsDTO.setDate(ads.getDate());
			list.add(adsDTO);
		}
		return list;
	}

	@Override
	public void addAds(AnotherAdsDTO adsDTO) {
		// TODO Auto-generated method stub
		AnotherAds ads = new AnotherAds();
		ads.setContent(adsDTO.getContent());
		ads.setImg(adsDTO.getImg());
		ads.setLink(adsDTO.getLink());
		anotherDao.addAds(ads);
	}

	@Override
	public boolean deleteAds(int id) {
		// TODO Auto-generated method stub
		return anotherDao.deleteAds(id);
	}

	@Override
	public void updateAds(AnotherAdsDTO adsDTO) {
		// TODO Auto-generated method stub
		AnotherAds ads = new AnotherAds();
		ads.setContent(adsDTO.getContent());
		ads.setLink(adsDTO.getLink());
		ads.setImg(adsDTO.getImg());
		ads.setId(adsDTO.getId());
		anotherDao.updateAds(ads);
	}

}

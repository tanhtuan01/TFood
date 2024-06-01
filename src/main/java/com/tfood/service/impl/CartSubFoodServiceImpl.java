package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.CartSubFoodDao;
import com.tfood.entity.CartSub;
import com.tfood.model.CartSubDTO;
import com.tfood.service.CartSubFoodService;

@Service
public class CartSubFoodServiceImpl implements CartSubFoodService{

	@Autowired
	CartSubFoodDao cartSubFoodDao;

	@Override
	public void addToCartSub(CartSubDTO cartSubDTO) {
		CartSub cartSub = new CartSub();
		cartSub.setFood(cartSubDTO.getFood());
		cartSub.setUser(cartSubDTO.getUser());
		cartSub.setGia(cartSubDTO.getGia());
		cartSub.setSoLuong(cartSubDTO.getSoLuong());
		cartSub.setTongTien(cartSubDTO.getTongTien());
		cartSubFoodDao.addToCartSub(cartSub);
	}

	@Override
	public int checkExistsSubFood(int user, int food) {
		return cartSubFoodDao.checkExistsSubFood(user, food);
	}

	@Override
	public int getQuantifyOfFood(int user, int food) {
		return cartSubFoodDao.getQuantifyOfFood(user, food);
	}

	@Override
	public boolean updateCart(CartSubDTO cartSubDTO) {
		CartSub cartSub = new CartSub();
		cartSub.setFood(cartSubDTO.getFood());
		cartSub.setUser(cartSubDTO.getUser());
		cartSub.setGia(cartSubDTO.getGia());
		cartSub.setSoLuong(cartSubDTO.getSoLuong());
		cartSub.setTongTien(cartSubDTO.getTongTien());
		return cartSubFoodDao.updateCart(cartSub);
	}

	@Override
	public int createSessionSubCart(int user) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.createSessionSubCart(user);
	}
	
  @Override
  public List<CartSubDTO> getAllByUser(int user) {
      List<CartSubDTO> listCartDTO = new ArrayList<CartSubDTO>();
      List<CartSub> listCart = cartSubFoodDao.getAllByUser(user);
      for (CartSub cart : listCart) {
    	  CartSubDTO cartDTO = new CartSubDTO();
    	  cartDTO.setId(cart.getId());
    	  cartDTO.setThoiGianTao(cart.getThoiGianTao());
    	  cartDTO.setThoiGianCapNhat(cart.getThoiGianCapNhat());
    	  cartDTO.setFood(cart.getFood());
    	  cartDTO.setUser(cart.getUser());
    	  cartDTO.setSoLuong(cart.getSoLuong());
    	  cartDTO.setGia(cart.getGia());
    	  cartDTO.setTongTien(cart.getTongTien());
    	  cartDTO.setImg(cart.getImg());
    	  cartDTO.setTenMon(cart.getTenMon());
          listCartDTO.add(cartDTO);
      }
      return listCartDTO;
  }

	@Override
	public boolean lowQuantity(int cart) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.lowQuantity(cart);
	}
	
	@Override
	public boolean upQuantity(int cart) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.upQuantity(cart);
	}
	
	@Override
	public int getQuantityInCart(int cart) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.getQuantityInCart(cart);
	}
	
	@Override
	public int totalQuantity(int user) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.totalQuantity(user);
	}
	
	@Override
	public boolean deleteItems(int cart) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.deleteItems(cart);
	}
	
	@Override
	public int totalPrice(int user) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.totalPrice(user);
	}

	@Override
	public boolean delete(int user) {
		// TODO Auto-generated method stub
		return cartSubFoodDao.delete(user);
	}
}

package com.tfood.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.CartDao;
import com.tfood.entity.Cart;
import com.tfood.model.CartDTO;
import com.tfood.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartDao cartDao;
	
	@Override
	public void addtoCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setFood(cartDTO.getFood());
		cart.setUser(cartDTO.getUser());
		cart.setGia(cartDTO.getGia());
		cart.setSoLuong(cartDTO.getSoLuong());
		cart.setTongTien(cartDTO.getTongTien());
		cartDao.addtoCart(cart);
	}

	@Override
	public int checkExistsFood(int user, int food) {
		return cartDao.checkExistsFood(user, food);
	}

	@Override
	public int getQuantifyOfFood(int user, int food) {
		return cartDao.getQuantifyOfFood(user, food);
	}

	@Override
	public boolean updateCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setFood(cartDTO.getFood());
		cart.setUser(cartDTO.getUser());
		cart.setSoLuong(cartDTO.getSoLuong());
		cart.setGia(cartDTO.getGia());
		cart.setTongTien(cartDTO.getTongTien());
		return cartDao.updateCart(cart);
	}

	@Override
	public int createSessionCart(int user) {
		return cartDao.createSessionCart(user);
	}

  @Override
  public List<CartDTO> getAllByUser(int user) {
      List<CartDTO> listCartDTO = new ArrayList<CartDTO>();
      List<Cart> listCart = cartDao.getAllByUser(user);
      for (Cart cart : listCart) {
    	  CartDTO cartDTO = new CartDTO();
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
    	  cartDTO.setTitle(cart.getTitle());
          listCartDTO.add(cartDTO);
      }
      return listCartDTO;
  }
//
//	@Override
//	public boolean deleteCartItem(int cartid, int userid) {
//		// TODO Auto-generated method stub
//		return cartDao.deleteCartItem(cartid, userid);
//	}
//
//	@Override
//	public int countCart(int id) {
//		// TODO Auto-generated method stub
//		return cartDao.countCart(id);
//	}
//
//	@Override
//	public int checkQuantity(int id_user, int id_food) {
//		// TODO Auto-generated method stub
//		return cartDao.checkQuantity(id_user, id_food);
//	}
//
//	@Override
//	public boolean updateCart(CartDTO cartDTO) {
//		Cart cart = new Cart();
//		cart.setQuantity(cartDTO.getQuantity());
//		cart.setPrice(cartDTO.getPrice());
//		cart.setUser_id(cartDTO.getUser_id());
//		cart.setFood_id(cartDTO.getFood_id());
//		return cartDao.updateCart(cart);
//	}
//
//	@Override
//	public boolean updateQuantity(CartDTO cartDTO) {
//		Cart cart = new Cart();
//		cart.setQuantity(cartDTO.getQuantity());
//		cart.setPrice(cartDTO.getPrice());
//		cart.setId(cartDTO.getId());
//		return cartDao.updateQuantity(cart);
//	}

	@Override
	public boolean lowQuantity(int cart) {
		// TODO Auto-generated method stub
		return cartDao.lowQuantity(cart);
	}
	
	@Override
	public boolean upQuantity(int cart) {
		// TODO Auto-generated method stub
		return cartDao.upQuantity(cart);
	}
	
	@Override
	public int getQuantityInCart(int cart) {
		// TODO Auto-generated method stub
		return cartDao.getQuantityInCart(cart);
	}
	
	@Override
	public boolean deleteItems(int cart) {
		// TODO Auto-generated method stub
		return cartDao.deleteItems(cart);
	}
	
	@Override
	public int totalQuantity(int user) {
		// TODO Auto-generated method stub
		return cartDao.totalQuantity(user);
	}
	
	@Override
	public int totalPrice(int user) {
		// TODO Auto-generated method stub
		return cartDao.totalPrice(user);
	}

	@Override
	public boolean delete(int user) {
		// TODO Auto-generated method stub
		return cartDao.delete(user);
	}

	@Override
	public List<CartDTO> getAllByOrderCode(String orderCode) {
		List<CartDTO> listCartDTO = new ArrayList<CartDTO>();
	      List<Cart> listCart = cartDao.getAllByOrderCode(orderCode);
	      for (Cart cart : listCart) {
	    	  CartDTO cartDTO = new CartDTO();
	    	  cartDTO.setFood(cart.getFood());
	    	  cartDTO.setSoLuong(cart.getSoLuong());
	          listCartDTO.add(cartDTO);
	      }
	      return listCartDTO;
	}

}

package dao;

import java.util.List;

import model.Cart;
import model.fruitinfo;

public interface BusinessService {
	public List<fruitinfo> getAllFruit();
	//获取指定id的书
	public fruitinfo findFruit(String id);
	//删除购物项
	public void deleteCartItem(String sid, Cart cart);
	//清空购物车
	public void clearCart(Cart cart);
	//改变数量
	public void changeQuantity(String sid, String quantity, Cart cart);


}

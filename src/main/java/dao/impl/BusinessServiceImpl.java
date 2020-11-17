package dao.impl;

import dao.BaseDao;
import dao.BusinessService;
import dao.FruitInfoDao;
import model.Cart;
import model.CartItem;
import model.fruitinfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessServiceImpl extends BaseDao implements BusinessService {
    FruitInfoDao dao=new FruitinfoDaoImpl();

    public List<fruitinfo> getAllFruit() {

        return dao.queryAllFruit();
    }

    public void deleteCartItem(String sid, Cart cart) {
        cart.getMap().remove(sid);
    }

    public fruitinfo findFruit(String id) {
        /*return dao.find(id);*/
        fruitinfo list = new fruitinfo();
        try {
            String sql  = "select * from fruits where fruitid="+id+";";
            ResultSet rs = executeSelect(sql);

            System.out.println(sql);
            while(rs.next()){
                list.setFruitid(rs.getInt(1));
                list.setFNAME(rs.getString(2));
                list.setFprice(rs.getDouble(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //closeAll(BaseDao.con, BaseDao.pstat, rst);
        }

        return list;
    }

    public void clearCart(Cart cart) {
        cart.getMap().clear();
    }

    public void changeQuantity(String sid, String quantity, Cart cart) {
        CartItem item=cart.getMap().get(sid);
        item.setQuantity(Integer.parseInt(quantity));
    }

}

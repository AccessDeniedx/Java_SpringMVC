//cart购物车，添加新购物项和计算总价，
// 把getbook和setbook改成你的水果的JAVABean，在domain包中
package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
    private double price;//所有购物项的价格总计

    public void add(fruitinfo fruit){
        CartItem item=map.get(fruit.getFruitid());
        if(item!=null){
            item.setQuantity(item.getQuantity()+1);
        }else{
            item=new CartItem();
            item.setFruit(fruit);
            item.setQuantity(1);
            //把新的购物项添加到map集合中
            map.put(Integer.toString(fruit.getFruitid()),item);
        }
    }
    public Map<String, CartItem> getMap() {
        return map;
    }
    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }
    public double getPrice() {
        double totalprice=0;
        for(Map.Entry<String, CartItem> me:map.entrySet()){
            CartItem item=me.getValue();
            totalprice+=item.getPrice();
        }
        this.price=totalprice;
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}





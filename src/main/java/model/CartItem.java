//cartItem,JAVAB,计算每类书的价格，在domain包中
package model;

//用于代表购买的商品（书）。包括书的数量。（购物项，购物车的一行）
public class CartItem {
    private fruitinfo fruit;
    private int quantity;
    private double price;//对此类书的价格计算（小计）
    public fruitinfo getFruit() {
        return fruit;
    }
    public void setFruit(fruitinfo fruit) {
        this.fruit = fruit;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.price=this.fruit.getFprice()*this.quantity;//书的单价乘以数量
    }
    public double getPrice() {

        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
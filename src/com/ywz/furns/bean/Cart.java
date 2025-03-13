package com.ywz.furns.bean;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 于汶泽
 */
public class Cart {
    private Map<Integer, CartItem> cartItems = new HashMap<>();

    private int totalCount = 0;

    private BigDecimal totalPrice;
    //在主界面添加商品到购物车的方法
    public void addItem(CartItem cartItem) {
        CartItem item = cartItems.get(cartItem.getId());
        if (item == null) {
            cartItems.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + cartItem.getCount());
            item.setTotalPrice(item.getTotalPrice().add(cartItem.getTotalPrice()));
            cartItems.put(cartItem.getId(), item);
        }
    }
    //在购物车直接修改商品数量的方法
    public void setCount(int id,int count){
        CartItem item = cartItems.get(id);
        item.setCount(count);
        item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
        cartItems.put(id,item);
    }

    //获取所有商品总销售额的方法
    public BigDecimal getTotalPrice() {
        totalPrice = new BigDecimal(0);
        for (CartItem item : cartItems.values()){
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }
    //获取所有商品总销售量的方法
    public int getTotalCount() {
        totalCount = 0;
        for (CartItem item : cartItems.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }
    // 用id来删除某一商品
    public void removeItem(int id) {
        cartItems.remove(id);
    }
    public Collection<CartItem> getMapValue(){
        return cartItems.values();
    }


    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}

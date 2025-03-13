package com.ywz.furns.bean;

import java.math.BigDecimal;

/**
 * @author 于汶泽
 */
public class order_item {
    private String name;
    private BigDecimal price;
    private Integer count;
    private BigDecimal total_price;
    private String order_id;

    public order_item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public order_item(String name, BigDecimal price, Integer count, BigDecimal total_price, String order_id) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.total_price = total_price;
        this.order_id = order_id;
    }
}

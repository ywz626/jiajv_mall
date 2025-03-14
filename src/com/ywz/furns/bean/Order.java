package com.ywz.furns.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 于汶泽
 */
public class Order {
    private String number;
    private Date date;
    private BigDecimal price;
    private int status;
    private int mumber_id;
    private Integer total_count = 0;
    private BigDecimal total_price = new BigDecimal(0);

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMumber_id() {
        return mumber_id;
    }

    public void setMumber_id(int mumber_id) {
        this.mumber_id = mumber_id;
    }

    public Order() {
    }

    public Order(String number, Date date, BigDecimal price, int status, int mumber_id) {
        this.number = number;
        this.date = date;
        this.price = price;
        this.status = status;
        this.mumber_id = mumber_id;
    }
}

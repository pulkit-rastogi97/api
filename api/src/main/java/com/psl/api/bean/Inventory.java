package com.psl.api.bean;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Map;

@Component
public class Inventory {

    int inventory_id;
    Map<Integer, String> category;
    Map<Integer, String> product;
    Date mfg_date;
    int quantity;
    double unit_price;

    public Inventory(){

    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Map<Integer, String> getCategory() {
        return category;
    }

    public void setCategory(Map<Integer, String> category) {
        this.category = category;
    }

    public Map<Integer, String> getProduct() {
        return product;
    }

    public void setProduct(Map<Integer, String> product) {
        this.product = product;
    }

    public Date getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(Date mfg_date) {
        this.mfg_date = mfg_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
}

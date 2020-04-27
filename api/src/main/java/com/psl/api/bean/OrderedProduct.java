package com.psl.api.bean;

import org.springframework.stereotype.Component;

@Component
public class OrderedProduct {

    private String productName;
    private double productUnitPrice;
    private int quantity;
    private double productAmount;

    public OrderedProduct(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }
}

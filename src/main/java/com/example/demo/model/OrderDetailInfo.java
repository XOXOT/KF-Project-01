package com.example.demo.model;

public class OrderDetailInfo {
    private String id;
 
    private String productCode;
    private String productName;
 
    private int quanity;
    private int price;
    private int amount;
 
    public OrderDetailInfo() {
 
    }
 
    // Using for JPA/Hibernate Query.
    public OrderDetailInfo(String id, String productCode, //
            String productName, int quanity, int price, int amount) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.quanity = quanity;
        this.price = price;
        this.amount = amount;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getProductCode() {
        return productCode;
    }
 
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public int getQuanity() {
        return quanity;
    }
 
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }
 
    public int getAmount() {
        return amount;
    }
 
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

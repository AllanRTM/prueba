package com.example.Coca_cola_Service;

import org.json.JSONObject;

public class Product {
    public int CartQuantity=0;
    public Double ProductPrice;
    String ProductName;
    //Double ProductPrice;
    int    ProductImage;
    //int    CartQuantity=0;

    public Product(String productName, Double productPrice, int productImage) {
        ProductName = productName;
        ProductPrice = productPrice;
        ProductImage = productImage;
    }
    public String getJsonObject() {
        JSONObject cartItems = new JSONObject();
        try
        {
            cartItems.put("ProductName", ProductName);
            cartItems.put("ProductPrice", ProductPrice);
            cartItems.put("ProductImage",ProductImage);
            cartItems.put("CartQuantity",CartQuantity);
        }
        catch (Exception e) {}
        return cartItems.toString();
    }
}

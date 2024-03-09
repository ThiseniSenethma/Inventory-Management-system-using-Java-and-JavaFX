package com.example.javacw;

import javafx.scene.image.Image;

public class Item {
    private String itemCode;
    private String itemName;
    private String itemBrand;
    private String itemPrice;
    private String itemQuantity;
    private String itemCategory;
    private String itemPurchasedDate;
    private String itemImage;


    public Item(String itemCode, String itemName, String itemBrand, String itemPrice, String itemQuantity, String itemCategory, String itemPurchasedDate, Image itemImage) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemCategory = itemCategory;
        this.itemPurchasedDate = itemPurchasedDate;
        this.itemImage = String.valueOf(itemImage);

    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemPurchasedDate() {
        return itemPurchasedDate;
    }

    public void setItemPurchasedDate(String itemPurchasedDate) {
        this.itemPurchasedDate = itemPurchasedDate;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

}

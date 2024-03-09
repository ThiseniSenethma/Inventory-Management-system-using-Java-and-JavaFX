package com.example.javacw;

public class ItemDetails {
        private static int itemCode;
        private String itemName;
        private String itemBrand;

    public static void getAllItemDetails() {
        return;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    private double itemPrice;
        private int itemQuantity;
        private String itemCategory;
        private String itemPurchasedDate;
        private String itemImage;

        public ItemDetails(int itemCode, String itemName, String itemBrand, double itemPrice, int itemQuantity, String itemCategory, String itemPurchasedDate, String itemImage) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.itemBrand = itemBrand;
            this.itemPrice = itemPrice;
            this.itemQuantity = itemQuantity;
            this.itemCategory = itemCategory;
            this.itemPurchasedDate = itemPurchasedDate;
            this.itemImage = itemImage;
        }

        public static int getItemCode() {
            return itemCode;
        }

        public String getItemName() {
            return itemName;
        }

        public String getItemBrand() {
            return itemBrand;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public int getItemQuantity() {
            return itemQuantity;
        }

        public String getItemCategory() {
            return itemCategory;
        }

        public String getItemPurchasedDate() {
            return itemPurchasedDate;
        }

        public String getItemImage(){return itemImage;}

}


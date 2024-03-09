package com.example.javacw;
import java.util.ArrayList;

public class AddingItems {
    private static ArrayList<Integer> itemCodeList = new ArrayList<>();
    private static ArrayList<String> itemNameList = new ArrayList<>();
    private static ArrayList<String> itemBrandList = new ArrayList<>();
    private static ArrayList<Double> itemPriceList = new ArrayList<>();
    private static ArrayList<Integer> itemQuantityList = new ArrayList<>();
    private static ArrayList<String> itemCategoryList = new ArrayList<>();
    private static ArrayList<String> itemPurchasedDateList = new ArrayList<>();
    private static ArrayList<String> itemImageList = new ArrayList<>();
    public static boolean isItemCodeExists(int itemCode) {
        return itemCodeList.contains(itemCode);
    }

    public static void addItemDetails(int itemCode, String itemName, String itemBrand, double itemPrice, int itemQuantity, String itemCategory, String purchasedDate, String itemImage) {
        itemCodeList.add(itemCode);
        itemNameList.add(itemName);
        itemBrandList.add(itemBrand);
        itemPriceList.add(itemPrice);
        itemQuantityList.add(itemQuantity);
        itemCategoryList.add(itemCategory);
        itemPurchasedDateList.add(purchasedDate);
        itemImageList.add(itemImage);
    }

    public static ArrayList<Integer> getItemCodeList() {
        ArrayList<Integer> icode =itemCodeList;
        return icode;
    }
    public static ArrayList<String> getItemNameList() {
        ArrayList<String> iname = itemNameList;
        return iname;
    }
    public static ArrayList<String> getItemBrandList() {
        ArrayList<String> ibrand = itemBrandList;
        return ibrand;
    }
    public  static ArrayList<Double> getItemPriceList() {
        ArrayList<Double> iPrice =  itemPriceList;
        return iPrice;
    }
    public  static ArrayList<Integer> getItemQuantityList() {
        ArrayList<Integer> iQuantity = itemQuantityList;
        return iQuantity;
    }
    public  static ArrayList<String> getItemCategoryList() {
        ArrayList<String> iCategory = itemCategoryList;
        return iCategory;
    }
    public static ArrayList<String> getItemPurchasedDateList(){
        ArrayList<String> iDate = itemPurchasedDateList;
        return iDate;
    }
    public static ArrayList<String> getItemImageList() {
        ArrayList<String> iImage = itemImageList;
        return iImage;
    }
}

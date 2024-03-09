package com.example.javacw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class HelloControllerTest {

    private boolean isValidString(String text) {
        boolean result = text.matches("[a-zA-Z]+");
        return result;
    }

    @Test
    void onSubmitButton1Click_validItemCode(){
        try{
        String newitemcode = "50";
        int itemCode = Integer.parseInt(newitemcode);
        } catch (NumberFormatException e) {
            fail("Item code must be an Integer" + e.getMessage());
        }

    }
    @Test
    void onSubmitButton1Click_validItemName(){
        String itemName = "Thisa";
        if(itemName.isEmpty()) {
            fail("Item name must not be empty");
        }
    }

    @Test
    void onSubmitButton1Click_validItemBrand(){
        String itemBrand = "samsung";
        if (!isValidString(itemBrand)) {
            fail("Item brand \ncan only contain letters\n (No special symbols or spaces)");
        }
    }

    @Test
    void onUpdateItemButton1Click_validItemPrice(){
        double newItemPrice;
        String updateitemprice = "76.3";
        try {
            newItemPrice = Double.parseDouble(updateitemprice);
            } catch (NumberFormatException e) {
                fail("Price must be a valid number.");
            }
        }

    @Test
    void onUpdateItemButton1Click_validItemQuantity(){
        int newItemQuantitity;
        String updateitemquantity = "5";
        try{
            newItemQuantitity = Integer.parseInt(updateitemquantity);
            } catch(NumberFormatException e ){
            fail("Quantity must be an Integer");
        }
    }
}


package com.example.javacw;

public class ViewingItemsTable {

   //calculate current total
   public static String calculateCurrentTotal(){
      double currenttotal=0.0;
      for(int j=0;j<AddingItems.getItemCodeList().size();j++)
      {
      double total=AddingItems.getItemPriceList().get(j)*AddingItems.getItemQuantityList().get(j);
      currenttotal=currenttotal+total;
      }
      String ct = String.valueOf(currenttotal);
      System.out.println("current total is : "+ct);
      return ct;
   }
}



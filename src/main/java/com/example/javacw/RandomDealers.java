//package com.example.javacw;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class RandomDealers {
//
//    public static void main(String[] args) {
//        List<ItemDetails> randomDealerData = generateRandomDealerData();
//        printRandomDealerData(randomDealerData);
//    }
//
//    public static List<ItemDetails> generateRandomDealerData() {
//        List<ItemDetails> randomDealerData = new ArrayList<>();
//        String[][] dealeritem = readArrayFromFile("dealersitems.txt");
//
//        // Randomly select 4 unique dealer numbers
//        List<Integer> selectedDealerNumbers = new ArrayList<>();
//        Random random = new Random();
//        while (selectedDealerNumbers.size() < 4) {
//            int randomIndex = random.nextInt(LoadingData.dealerlocation.length);
//            int dealerNumber = Integer.parseInt(LoadingData.dealerlocation[randomIndex][0]);
//            if (!selectedDealerNumbers.contains(dealerNumber)) {
//                selectedDealerNumbers.add(dealerNumber);
//            }
//        }
//
//        // Filter the data for the selected dealer numbers and populate the List
//        for (String[] row : dealeritem) {
//            int dealer = Integer.parseInt(row[0]);
//            if (selectedDealerNumbers.contains(dealer)) {
//                String type = row[1];
//                String brand = row[2];
//                int price = Integer.parseInt(row[3]);
//                int quantity = Integer.parseInt(row[4]);
//                randomDealerData.add(new ItemDetails(dealer, type, brand, price, quantity));
//            }
//        }
//
//        return randomDealerData;
//    }
//
//    public static void printRandomDealerData(List<ItemDetails> randomDealerData) {
//        for (ItemDetails item : randomDealerData) {
//            System.out.println("Dealer: " + item.getItemCode());
//            System.out.println("Type: " + item.getItemName());
//            System.out.println("Brand: " + item.getItemBrand());
//            System.out.println("Price: " + item.getItemPrice());
//            System.out.println("Quantity: " + item.getItemQuantity());
//            System.out.println();
//        }
//    }
//
//    // Your ItemData class definition here
//    public static class ItemDetails {
//        private int itemCode;
//        private String itemName;
//        private String itemBrand;
//        private double itemPrice;
//        private int itemQuantity;
//
//        public ItemDetails(int itemCode, String itemName, String itemBrand, double itemPrice, int itemQuantity) {
//            this.itemCode = itemCode;
//            this.itemName = itemName;
//            this.itemBrand = itemBrand;
//            this.itemPrice = itemPrice;
//            this.itemQuantity = itemQuantity;
//        }
//
//        public int getItemCode() {
//            return itemCode;
//        }
//
//        public String getItemName() {
//            return itemName;
//        }
//
//        public String getItemBrand() {
//            return itemBrand;
//        }
//
//        public double getItemPrice() {
//            return itemPrice;
//        }
//
//        public int getItemQuantity() {
//            return itemQuantity;
//        }
//    }
//
//    // Your readArrayFromFile method here
//    public static String[][] readArrayFromFile(String filePath) {
//        String[][] array;
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filePath));
//            int rows = 0;
//            String line;
//
//            // Count no of lines = no of rows
//            while ((line = br.readLine()) != null) {
//                rows++;
//            }
//
//            br.close();
//
//            array = new String[rows][];
//
//            br = new BufferedReader(new FileReader(filePath));
//            int currentRow = 0;
//            while ((line = br.readLine()) != null) {
//                // Removing []
//                line = line.trim().replaceAll("\\[|\\]", "");
//                // Divide by ,
//                String[] elements = line.split(",");
//                array[currentRow] = elements;
//                currentRow++;
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            array = new String[0][0];
//        }
//        return array;
//    }
//}

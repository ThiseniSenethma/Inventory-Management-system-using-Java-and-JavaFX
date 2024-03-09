package com.example.javacw;
import java.io.*;
import java.util.ArrayList;

public class SavingItems {
    ArrayList<ArrayList<Object>> dataToSave = new ArrayList<>();

    public SavingItems() {
        // Adding an empty ArrayList into dataToSave
        dataToSave.add(new ArrayList<>());
        ArrayList<Object> loadedData = new ArrayList<>();
        loadedData.add(AddingItems.getItemCodeList());
        loadedData.add(AddingItems.getItemNameList());
        loadedData.add(AddingItems.getItemBrandList());
        loadedData.add(AddingItems.getItemPriceList());
        loadedData.add(AddingItems.getItemQuantityList());
        loadedData.add(AddingItems.getItemCategoryList());
        loadedData.add(AddingItems.getItemPurchasedDateList());
        loadedData.add(AddingItems.getItemImageList());

        dataToSave.add(loadedData);

        // Writing data to a text file
        saveDataToFile("data.txt");
    }

    private void saveDataToFile(String fileName) {
        // Writing data to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (ArrayList<Object> data : dataToSave) {
                for (int i = 0; i < data.size(); i++) {
                    Object item = data.get(i);
                    writer.write(item.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.javacw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LoadingData {
    public void loadDataFromFile(String fileName) {
        Object[] array1 = new Object[1];
        Object[] array2 = new Object[1];
        Object[] array3 = new Object[1];
        Object[] array4 = new Object[1];
        Object[] array5 = new Object[1];
        Object[] array6 = new Object[1];
        Object[] array7 = new Object[1];
        Object[] array8 = new Object[1];

        // path to the text file
        String filePath = "data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            for(int lineNumber =0;lineNumber<9;lineNumber++){
                line = br.readLine();
                switch (lineNumber) {
                    case 0:
                        array1 = new String[]{line};
                        break;
                    case 1:
                        array2 = new String[]{line};
                        break;
                    case 2:
                        array3 = new String[]{line};
                        break;
                    case 3:
                        array4 = new String[]{line};
                        break;
                    case 4:
                        array5 = new String[]{line};
                        break;
                    case 5:
                        array6 = new String[]{line};
                        break;
                    case 6:
                        array7 = new String[]{line};
                        break;
                    case 7:
                        array8 = new String[]{line};
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Printing all arrays to check
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Array 3: " + Arrays.toString(array3));
        System.out.println("Array 4: " + Arrays.toString(array4));
        System.out.println("Array 5: " + Arrays.toString(array5));
        System.out.println("Array 6: " + Arrays.toString(array6));
        System.out.println("Array 7: " + Arrays.toString(array7));
        System.out.println("Array 8: " + Arrays.toString(array8));

        System.out.println();
        String inputString = Arrays.toString(array1);
        String[] elements = inputString.split("[\\[\\],]");
        for (String element : elements) {
            if (!element.isEmpty()) {
//                System.out.println(element.trim());
                AddingItems.getItemCodeList().add(Integer.valueOf(element.trim()));
            }
        }
        String inputString1 = Arrays.toString(array2);
        String[] elements1 = inputString1.split("[\\[\\],]");
        for (String element1 : elements1) {
            if (!element1.isEmpty()) {
//                System.out.println(element1.trim());
                AddingItems.getItemNameList().add(String.valueOf(element1.trim()));
            }
        }
        String inputString2 = Arrays.toString(array3);
        String[] elements2 = inputString2.split("[\\[\\],]");
        for (String element2 : elements2) {
            if (!element2.isEmpty()) {
//                System.out.println(element2.trim());
                AddingItems.getItemBrandList().add(String.valueOf(element2.trim()));
            }
        }
        String inputString3 = Arrays.toString(array4);
        String[] elements3 = inputString3.split("[\\[\\],]");
        for (String element3 : elements3) {
            if (!element3.isEmpty()) {
//                System.out.println(element3.trim());
                AddingItems.getItemPriceList().add(Double.valueOf(element3.trim()));
            }
        }
        String inputString4 = Arrays.toString(array5);
        String[] elements4 = inputString4.split("[\\[\\],]");
        for (String element4 : elements4) {
            if (!element4.isEmpty()) {
//                System.out.println(element4.trim());
                AddingItems.getItemQuantityList().add(Integer.valueOf(element4.trim()));
            }
        }
        String inputString5 = Arrays.toString(array6);
        String[] elements5 = inputString5.split("[\\[\\],]");
        for (String element5 : elements5) {
            if (!element5.isEmpty()) {
//                System.out.println(element5.trim());
                AddingItems.getItemCategoryList().add(String.valueOf(element5.trim()));
            }
        }
        String inputString6 = Arrays.toString(array7);
        String[] elements6 = inputString6.split("[\\[\\],]");
        for (String element6 : elements6){
            if (!element6.isEmpty()){
//                System.out.println(element6.trim());
                AddingItems.getItemPurchasedDateList().add(String.valueOf(element6.trim()));
            }
        }
        String inputString7 = Arrays.toString(array8);
        String[] elements7 = inputString7.split("[\\[\\],]");
        for (String element7 : elements7) {
            if (!element7.isEmpty()) {
//                System.out.println(element7.trim());
                AddingItems.getItemImageList().add(String.valueOf(element7.trim()));
            }
        }
    }

    //creating a 2d array to store dealer details
    static String [][] dealerlocation = new String[4][2]; //4 dealers 2 fields (code and location)
    static String[][] twoDArray = readArrayFromFile("dealersnames.txt");
    static String[][] dealeritem = readArrayFromFile("dealersitems.txt");
    static ArrayList<Object[]> dealerDetails = new ArrayList<>();
public static void RandomlySelecting() {
    Random random = new Random();
    int status = random.nextInt(2);
    int count = random.nextInt(2);
    // Output the numbers to check
//    System.out.println("Status: " + status); //check if numbers are generating properly
//    System.out.println("Count: " + count);

    if (status == 0 && count == 0) {
        dealerlocation[0][0] = twoDArray[0][0];
        dealerlocation[0][1] = twoDArray[0][3];
        dealerlocation[1][0] = twoDArray[1][0];
        dealerlocation[1][1] = twoDArray[1][3];
        dealerlocation[2][0] = twoDArray[2][0];
        dealerlocation[2][1] = twoDArray[2][3];
        dealerlocation[3][0] = twoDArray[3][0];
        dealerlocation[3][1] = twoDArray[3][3];
    }
    else if (status == 0 && count == 1) {
        dealerlocation[0][0] = twoDArray[4][0];
        dealerlocation[0][1] = twoDArray[4][3];
        dealerlocation[1][0] = twoDArray[5][0];
        dealerlocation[1][1] = twoDArray[5][3];
        dealerlocation[2][0] = twoDArray[0][0];
        dealerlocation[2][1] = twoDArray[0][3];
        dealerlocation[3][0] = twoDArray[1][0];
        dealerlocation[3][1] = twoDArray[1][3];
    }
    else if (status == 1 && count == 0) {
        dealerlocation[0][0] = twoDArray[2][0];
        dealerlocation[0][1] = twoDArray[2][3];
        dealerlocation[1][0] = twoDArray[3][0];
        dealerlocation[1][1] = twoDArray[3][3];
        dealerlocation[2][0] = twoDArray[4][0];
        dealerlocation[2][1] = twoDArray[4][3];
        dealerlocation[3][0] = twoDArray[5][0];
        dealerlocation[3][1] = twoDArray[5][3];
    } else {
        dealerlocation[0][0] = twoDArray[4][0];
        dealerlocation[0][1] = twoDArray[4][3];
        dealerlocation[1][0] = twoDArray[2][0];
        dealerlocation[1][1] = twoDArray[2][3];
        dealerlocation[2][0] = twoDArray[5][0];
        dealerlocation[2][1] = twoDArray[5][3];
        dealerlocation[3][0] = twoDArray[3][0];
        dealerlocation[3][1] = twoDArray[3][3];
    }

//    System.out.println(Arrays.toString(dealerlocation[0]));
//    System.out.println(Arrays.toString(dealerlocation[1]));
//    System.out.println(Arrays.toString(dealerlocation[2]));
//    System.out.println(Arrays.toString(dealerlocation[3]));

    String[] locations = new String[4];
    String location1 = dealerlocation[0][1];
    String location2 = dealerlocation[1][1];
    String location3 = dealerlocation[2][1];
    String location4 = dealerlocation[3][1];

    locations[0] = location1;
    locations[1] = location2;
    locations[2] = location3;
    locations[3] = location4;

    bubbleSortLocations(locations);
    System.out.println(Arrays.toString(locations)); //print the sorted location list
}

    public static ArrayList<String[]> randomlySelectedDetails = new ArrayList<String[]>();
    public static void bubbleSortLocations(String[] locations) {
        int n = locations.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (locations[j].compareTo(locations[j + 1]) > 0) {
                    String temp = locations[j];
                    locations[j] = locations[j + 1];
                    locations[j + 1] = temp;
                    swapped = true;
                }
            }
            // If nothing was swapped already sorted
            if (!swapped) {
                break;
            }
        }
        for(int i=0; i< locations.length;i++){                  //print dealer details of randomley selected dealers
            for(int j=0; j< dealerlocation.length;j++){
                if(locations[i].equals(dealerlocation[j][1])){
                    for(int k=0;k< twoDArray.length;k++){
                        if(dealerlocation[j][0].equals(twoDArray[k][0])){
                            System.out.println(Arrays.toString(twoDArray[k]));
                            randomlySelectedDetails.add(twoDArray[k]);
                        }
                    }
                }
            }
        }
        }





    public static String[][] readArrayFromFile(String filePath) {
        String[][] array;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int rows = 0;
            String line;

            // Count no of lines = no of rows
            while ((line = br.readLine()) != null) {
                rows++;
            }

            br.close();

            array = new String[rows][];

            br = new BufferedReader(new FileReader(filePath));
            int currentRow = 0;
            while ((line = br.readLine()) != null) {
                // Removing []
                line = line.trim().replaceAll("\\[|\\]", "");
                // Divide by ,
                String[] elements = line.split(",");
                array[currentRow] = elements;
                currentRow++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            array = new String[0][0];
        }
        return array;
    }
}

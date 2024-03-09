package com.example.javacw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelloController {
    @FXML
    private Label errormsg1;
    @FXML
    private Label errormsg2;
    @FXML
    private Label deletemsg;
    @FXML
    private TextField deleteitemcode;
    private String itemImage = "";
    String updatedItemImage = null;

    @FXML
    private Label showmsg;

//    @FXML
//    private TableColumn<DealerDetails,String> Location;
//
//    @FXML
//    private TableColumn<DealerDetails,String> dealerCode;
//
//    @FXML
//    private TableColumn<DealerDetails,String> dealerName;
//
//    @FXML
//    private TableColumn<DealerDetails, String> phoneNo;

    //load adding items page
    @FXML
    public void onAddButtonClick(ActionEvent e1) throws IOException {
        Stage previousStage = (Stage) ((Node) e1.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("add-detail-page.fxml"));
        previousStage.setScene(new Scene(root,911,711));
    }

    //load deleting items page
    @FXML
    public void onDeleteButtonClick(ActionEvent e2) throws IOException {
        Stage previousStage = (Stage) ((Node) e2.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("delete-detail-page.fxml"));
        previousStage.setScene(new Scene(root,911,711));
    }

    //load saving items page
    @FXML
    public void onSaveButtonClick(ActionEvent e3) throws IOException {
        Stage previousStage = (Stage) ((Node) e3.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("save-detail-page.fxml"));
        previousStage.setScene(new Scene(root, 600, 400));

        SavingItems savingItems = new SavingItems();
        System.out.println("Data has been saved to the text file.");
    }

    //load viewing items page
    @FXML
    public void onViewButtonClick(ActionEvent e4) throws IOException {
        Stage previousStage = (Stage) ((Node) e4.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("view-detail-page.fxml"));
        previousStage.setScene(new Scene(root, 911, 711));

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int index = 0;index<AddingItems.getItemCodeList().size();index++){
            temp.add(AddingItems.getItemCodeList().get(index));
        }

        int n = temp.size();  //using bubble sort to sort item codes
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {    //bubble sort goes in pairs check with immediate next element
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (temp.get(j) > temp.get(j + 1)) {
                    int tempt = temp.get(j);
                    temp.set(j, temp.get(j + 1));
                    temp.set(j + 1, tempt);
                    swapped = true;
                }
            }
            // checks if two elements were swapped or not
            if (!swapped) {
                break;
            }
        }
        System.out.println("Sorted item codes : "+temp); //sout the sorted item codes
        for(int x=0;x<temp.size();x++){

            for(int y=0;y<AddingItems.getItemCodeList().size();y++){

                if(temp.get(x)==AddingItems.getItemCodeList().get(y)){
                    System.out.println(AddingItems.getItemCodeList().get(y));
                }
            }
        }

//        Stage previousStage = (Stage) ((Node) e4.getSource()).getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("view-detail-page.fxml"));
//        previousStage.setScene(new Scene(root, 1000, 800));
//        dealerCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
//        dealerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        phoneNo.setCellValueFactory(new PropertyValueFactory<>("Phone"));
//        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
//
//        ViewingItemsTable.calculateCurrentTotal();  //calculating current total of items
//        DealerDetails dealerDetails = new DealerDetails("dealercode","dealername","123456","kaduwela");
//        dealerDetails.dealertable.getItems().add(dealerDetails);
    }

    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private TableColumn<Item, String> imageColumn;
    @FXML
    private TableColumn<Item, String> itemBrandColumn;
    @FXML
    private TableColumn<Item, String> itemCategoryColumn;
    @FXML
    private TableColumn<Item, Integer> itemCodeColumn;
    @FXML
    private TableColumn<Item, String> itemNameColumn;
    @FXML
    private TableColumn<Item, String> itemPriceColumn;
    @FXML
    private TableColumn<Item, Integer> itemQuantityColumn;
    @FXML
    private TableColumn<Item, Date> purchasedDateColumn;

    // Defining the table and columns
//    public void initialize() {
//        imageColumn.setCellValueFactory(new PropertyValueFactory<>("itemImage"));
//        itemBrandColumn.setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
//        itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
//        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
//        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
//        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
//        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
//        purchasedDateColumn.setCellValueFactory(new PropertyValueFactory<>("itemPurchasedDate"));
//        List<Item> savingItems = savingItemsToView();
//        itemsTable.getItems().addAll(savingItems);
//    }

    // Getting old values and creating duplicates to view in table
    private List<Item> savingItemsToView() {
        ObservableList<Item> savedItems = FXCollections.observableArrayList();
        for (int i = 0; i < AddingItems.getItemCodeList().size(); i++) {
            String itemCodeString = String.valueOf(AddingItems.getItemCodeList().get(i));
            String itemNameString = String.valueOf(AddingItems.getItemNameList().get(i));
            String itemBrandString = String.valueOf(AddingItems.getItemBrandList().get(i));
            String itemPriceString = String.valueOf(AddingItems.getItemPriceList().get(i));
            String itemQuantityString = String.valueOf(AddingItems.getItemQuantityList().get(i));
            String itemCategoryString = String.valueOf(AddingItems.getItemCategoryList().get(i));
            String itemPurchasedDateString = String.valueOf(AddingItems.getItemPurchasedDateList().get(i));
            String imagePath = AddingItems.getItemImageList().get(i);

            Image image = new Image("file:" + imagePath); // Create an Image object from the path
            Image itemImageString = image;

            savedItems.add(new Item(itemCodeString, itemNameString, itemBrandString, itemPriceString, itemQuantityString, itemCategoryString, itemPurchasedDateString, itemImageString));
        }
        return savedItems;
    }

    //load updating items page
    @FXML
    public void onUpdateButtonClick(ActionEvent e5) throws IOException {
        Stage previousStage = (Stage) ((Node) e5.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("update-detail-page.fxml"));
        previousStage.setScene(new Scene(root, 911, 711));
    }

    //load selecting four random dealers page
    @FXML
    public void onSelectDealerButtonClick(ActionEvent e6) throws IOException {
        Stage previousStage = (Stage) ((Node) e6.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("select-dealer-page.fxml"));
        previousStage.setScene(new Scene(root, 600, 400));
    }

    //load display dealer details page
    @FXML
    public void onDisplayDealerButtonClick(ActionEvent e7) throws IOException {
        Stage previousStage = (Stage) ((Node) e7.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("display-dealer-page.fxml"));
        previousStage.setScene(new Scene(root, 911, 711));
//        String firstElement = Arrays.toString(LoadingData.randomlySelectedDetails.get(0));
    }

    @FXML
    public void onItemDealerButtonClick(ActionEvent e8) throws IOException {
        Stage previousStage = (Stage) ((Node) e8.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("dealer-item-page.fxml"));
        previousStage.setScene(new Scene(root, 911, 711));

    }

    //Exit button in menu view
    @FXML
    public void onExitButtonClick(MouseEvent e9){
        Stage stage = (Stage) ((Node) e9.getSource()).getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    //When user does not want to continue with the program - exit buttons in other pages
    @FXML
    public void onExitButton2Click(ActionEvent e9){
        Stage stage = (Stage) ((Node) e9.getSource()).getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    //When user wants to continue with the program
    @FXML
    public void onContinueButtonClick(ActionEvent e10) throws IOException {
        Stage previousStage = (Stage) ((Node) e10.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("menu-view.fxml"));
        previousStage.setScene(new Scene(root, 911, 711));
    }

    //letting user choose a picture of the adding item
    @FXML
    public void onSelectImageButton(ActionEvent e11){
        FileChooser choosingImage = new FileChooser();
        choosingImage.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        Stage stage = (Stage) ((Node) e11.getSource()).getScene().getWindow();
        File selectedFile = choosingImage.showOpenDialog(stage);

        if (selectedFile != null) {
            itemImage = selectedFile.toURI().toString(); //The location of the image/image path is taken
            // Creating an Image object with the selected image
            Image image = new Image(itemImage);
            // Setting and displaying to the ImageView
            newitemimage.setImage(image);
        }
    }

    //adding new items
    private AddingItems storeItem = new AddingItems();
    @FXML
    private TextField newitemcode;
    @FXML
    private TextField newitemname;
    @FXML
    private TextField newitembrand;
    @FXML
    private TextField newitemprice;
    @FXML
    private TextField newitemquantity;
    @FXML
    private TextField newitemcategory;
    @FXML
    private TextField newitempurchaseddate;
    @FXML
    private ImageView newitemimage;

    //updating old records
    @FXML
    private TextField olditemcode;
    @FXML
    private TextField updateitemcode;
    @FXML
    private TextField updateitemname;
    @FXML
    private TextField updateitembrand;
    @FXML
    private TextField updateitemprice;
    @FXML
    private TextField updateitemcategory;
    @FXML
    private TextField updateitemquantity;
    @FXML
    private TextField updateitempurchaseddate;
    @FXML
    private ImageView updateitemimage;

    //clicking submit button after adding new items
    @FXML
    private void onSubmitButton1Click(ActionEvent e12) {
        int itemCode;
        String itemName = newitemname.getText();
        String itemBrand = newitembrand.getText();
        double itemPrice;
        int itemQuantity;
        String itemCategory = newitemcategory.getText();
        String itemPurchasedDate;

        //checking if item code entered is an integer
        try {
            itemCode = Integer.parseInt(newitemcode.getText());
        } catch (NumberFormatException e) {
            errormsg1.setText("Item code must be an Integer");
            return;
        }

        // Checking if the item code already exists
        if (AddingItems.isItemCodeExists(itemCode)) {
            errormsg1.setText("Item code already exists.");
            return;
        }

        //checking if item name is blank (can enter spaces or special characters)
        if (itemName.isEmpty()) {
            errormsg1.setText("Item name can not be empty");
            return;
        }

        // checking if item Brand is a valid string
        if (!isValidString(itemBrand)) {
            errormsg1.setText("Item brand \ncan only contain letters\n (No special symbols or spaces)");
            return;
        }

        // checking if item category is a valid string
        if (!isValidString(itemCategory)) {
            errormsg1.setText("Item category \ncan only contain letters\n (No special symbols or spaces)");
            return;
        }

        // checking if price is a double
        try {
            itemPrice = Double.parseDouble(newitemprice.getText());
        } catch (NumberFormatException e) {
            errormsg1.setText("Price must be\n an integer/float");
            return;
        }

        // checking if quantity is an integer
        try {
            itemQuantity = Integer.parseInt(newitemquantity.getText());
        } catch (NumberFormatException e) {
            errormsg1.setText("Quantity must be an integer");
            return; // Exit the method if input is invalid.
        }

        // Checking if valid date is entered
        itemPurchasedDate = newitempurchaseddate.getText();
        if (itemPurchasedDate.isEmpty()) {
            errormsg1.setText("Purchased date cannot be empty.");
            return;
        } else {
            String[] dateDividedParts = itemPurchasedDate.split("-");
            if (dateDividedParts.length != 3) {
                errormsg1.setText("Please enter a valid date\n in the form\n dd-mm-yy");
                return;
            }

            int day, month, year;
            try {
                day = Integer.parseInt(dateDividedParts[0]);
                month = Integer.parseInt(dateDividedParts[1]);
                year = Integer.parseInt(dateDividedParts[2]);
            } catch (NumberFormatException e) {
                errormsg1.setText("Please enter a valid date.");
                return;
            }

            // checking if all 3 parts are in valid range
            if (!(1 <= day && day <= 31 && 1 <= month && month <= 12 && 1 <= year && year <= 2023)) {
                errormsg1.setText("Please enter a valid date.");
                return;
            }
        }

        //error message label is cleared when there is no error
        errormsg1.setText("");

        // Storing item details
        AddingItems.addItemDetails(itemCode, itemName, itemBrand, itemPrice, itemQuantity, itemCategory, itemPurchasedDate, itemImage);

        newitemcode.setText("");
        newitemname.setText("");
        newitembrand.setText("");
        newitemprice.setText("");
        newitemquantity.setText("");
        newitemcategory.setText("");
        newitempurchaseddate.setText("");
        newitemimage.setImage(null);
    }

    private boolean isValidString(String text) {
        boolean result = text.matches("[a-zA-Z]+");
        return result;
    }

    //deleting item records
    public void onDeleteItemButtonClick(ActionEvent actionEvent) { //deleteitembuttonclick is enter button to search for that item
        int deletingItemCode = Integer.parseInt(deleteitemcode.getText());//deleteitemcode is the code of the item to be deleted
        int deletingIndex = -1;
        for(int j = 0; j< AddingItems.getItemCodeList().size(); j++){
            if(AddingItems.getItemCodeList().get(j)== deletingItemCode){
                deletingIndex=j;
                System.out.println(deletingIndex); //checking if deletingindex is correct
                break;
            }
        }

        if (deletingIndex==-1) {
            deletemsg.setText("Item code does not exist.");
            return;
        }

        AddingItems.getItemCodeList().remove(deletingIndex);
        AddingItems.getItemNameList().remove(deletingIndex);
        AddingItems.getItemBrandList().remove(deletingIndex);
        AddingItems.getItemPriceList().remove(deletingIndex);
        AddingItems.getItemQuantityList().remove(deletingIndex);
        AddingItems.getItemCategoryList().remove(deletingIndex);
        AddingItems.getItemPurchasedDateList().remove(deletingIndex);
        AddingItems.getItemImageList().remove(deletingIndex);

        System.out.println(AddingItems.getItemCodeList());  //sout remaining item codes
        deletemsg.setText("Item details successfully deleted !");
    }

    //letting user update the item image
    public void onSelectUpdatedItemImageButtonClick(ActionEvent actionEvent) {
        FileChooser choosingUpdatedImage = new FileChooser();
        choosingUpdatedImage.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File selectedFile = choosingUpdatedImage.showOpenDialog(stage);

        if (selectedFile != null) {
            updatedItemImage = selectedFile.toURI().toString();
            //Creating an image object with the selected image
            Image image1 = new Image(updatedItemImage);
            updateitemimage.setImage(image1);
        }
    }

    //Asking user what the item code of the item he wants to update is
    @FXML
    public void onItemToUpdateButtonClick(ActionEvent event){
        int updatingItemCode = Integer.parseInt(olditemcode.getText());
        if (!AddingItems.isItemCodeExists(updatingItemCode)) {
            errormsg2.setText("Item code does not exist.");
            return;
        }
        else{errormsg2.setText("Item code exist.");}
        int updatingIndex = -1;
        for(int k = 0; k< AddingItems.getItemCodeList().size(); k++){
            if(AddingItems.getItemCodeList().get(k)== updatingItemCode){
                updatingIndex=k;
                System.out.println(updatingIndex);
            }
        }

        int checkingItemCode = AddingItems.getItemCodeList().get(updatingIndex);
        System.out.println(checkingItemCode);
    }

    //after filled and update button is clicked
    @FXML
    public void onUpdateItemButtonClick(ActionEvent actionEvent) throws ParseException {
        int updatingItemCode = Integer.parseInt(olditemcode.getText());
        if (!AddingItems.isItemCodeExists(updatingItemCode)) {
            errormsg2.setText("Item code does not exist.");
            return;
        }

        int updatingIndex = -1;
        for (int k = 0; k < AddingItems.getItemCodeList().size(); k++) {
            if (AddingItems.getItemCodeList().get(k) == updatingItemCode) {
                updatingIndex = k;
                break;
            }
        }

        // Validate only if user enters something if not preserve previous data
        int newItemCode;
        if (updateitemcode.getText().isEmpty()) {
            newItemCode = AddingItems.getItemCodeList().get(updatingIndex);
        } else {
            try {
                newItemCode = Integer.parseInt(updateitemcode.getText());
                // Checking if the item code already exists
                if (AddingItems.isItemCodeExists(newItemCode)) {
                    errormsg2.setText("Item code already exists.");
                    return;
                }
            } catch (NumberFormatException e) {
                errormsg2.setText("Item code must be an integer.");
                return;
            }
        }

        String newItemName = updateitemname.getText();
        if (newItemName.isEmpty()) {
            newItemName = AddingItems.getItemNameList().get(updatingIndex);
        }

        String newItemBrand = updateitembrand.getText();
        if (newItemBrand.isEmpty()) {
            newItemBrand = AddingItems.getItemBrandList().get(updatingIndex);
        }  else {
            if (!isValidString(newItemBrand)) {
                errormsg2.setText("Item brand \ncan only contain letters\n (No special symbols or spaces)");
                return;
            }
        }

        double newItemPrice;
        if (updateitemprice.getText().isEmpty()) {
            newItemPrice = AddingItems.getItemPriceList().get(updatingIndex);
        } else {
            try {
                newItemPrice = Double.parseDouble(updateitemprice.getText());
            } catch (NumberFormatException e) {
                errormsg2.setText("Price must be a valid number.");
                return;
            }
        }

        int newItemQuantity;
        if (updateitemquantity.getText().isEmpty()) {
            newItemQuantity = AddingItems.getItemQuantityList().get(updatingIndex);
        } else {
            try {
                newItemQuantity = Integer.parseInt(updateitemquantity.getText());
            } catch (NumberFormatException e) {
                errormsg2.setText("Quantity must be an integer.");
                return;
            }
        }

        String newItemCategory = updateitemcategory.getText();
        if (newItemCategory.isEmpty()) {
            newItemCategory = AddingItems.getItemCategoryList().get(updatingIndex);
        } else {
            // Validate the category if user enters something
            if (!isValidString(newItemCategory)) {
                errormsg2.setText("Item category \ncan only contain letters\n (No special symbols or spaces)");
                return;
            }
        }

        String newItemPurchasedDate = updateitempurchaseddate.getText();
        if (newItemPurchasedDate.isEmpty()) {
            newItemPurchasedDate = AddingItems.getItemPurchasedDateList().get(updatingIndex);
        } else {
            // If user enters a date, validate it
            String[] dateDividedParts = newItemPurchasedDate.split("-");
            if (dateDividedParts.length != 3) {
                errormsg2.setText("Please enter a valid date\n in the form\n dd-mm-yy");
                return;
            }

            int day, month, year;
            try {
                day = Integer.parseInt(dateDividedParts[0]);
                month = Integer.parseInt(dateDividedParts[1]);
                year = Integer.parseInt(dateDividedParts[2]);
            } catch (NumberFormatException e) {
                errormsg2.setText("Please enter a valid date.");
                return;
            }

            // checking if all 3 parts are in valid range
            if (!(1 <= day && day <= 31 && 1 <= month && month <= 12 && 1 <= year && year <= 2023)) {
                errormsg2.setText("Please enter a valid date.");
                return;
            }
        }

        // Only update the item details in AddingItems if all input values are valid
        AddingItems.getItemCodeList().set(updatingIndex, newItemCode);
        AddingItems.getItemNameList().set(updatingIndex, newItemName);
        AddingItems.getItemBrandList().set(updatingIndex, newItemBrand);
        AddingItems.getItemPriceList().set(updatingIndex, newItemPrice);
        AddingItems.getItemQuantityList().set(updatingIndex, newItemQuantity);
        AddingItems.getItemCategoryList().set(updatingIndex, newItemCategory);
        AddingItems.getItemPurchasedDateList().set(updatingIndex, newItemPurchasedDate);

        // Update the item image if it was changed
        if (updatedItemImage != null) {
            AddingItems.getItemImageList().set(updatingIndex, updatedItemImage);
        }

        errormsg2.setText("Item updated successfully.");

        // Clear all text fields and the image view after update button is clicked
        updateitemcode.clear();
        updateitemname.clear();
        updateitembrand.clear();
        updateitemprice.clear();
        updateitemquantity.clear();
        updateitemcategory.clear();
        updateitempurchaseddate.clear();
        updateitemimage.setImage(null);
    }

    //Selecting 4 random dealers out of 6 dealers
    public void onRandomSelectButtonClick(ActionEvent actionEvent) {
        LoadingData.RandomlySelecting();
        showmsg.setText("Four random dealers are selected ! ");
    }

}
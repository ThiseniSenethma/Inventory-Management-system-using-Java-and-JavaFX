package com.example.javacw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class NewController {
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
    @FXML
    protected Label itemTotal;

    // Defining the table and columns
    public void initialize() {
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("itemImage"));
        itemBrandColumn.setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
        itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
        purchasedDateColumn.setCellValueFactory(new PropertyValueFactory<>("itemPurchasedDate"));
        List<Item> savingItems = savingItemsToView();
        itemsTable.getItems().addAll(savingItems);
    }

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


    public void onCurrentTotalButtonClick(ActionEvent actionEvent) {
        String ct = ViewingItemsTable.calculateCurrentTotal();
        itemTotal.setText("The Current Total : Rs."+ct);
    }

    public void onContinueButton2Click(ActionEvent e10) throws IOException {
        Stage previousStage = (Stage) ((Node) e10.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("menu-view.fxml"));
        previousStage.setScene(new Scene(root, 911, 711));
    }

    public void onExitButton3Click(ActionEvent e9) {
        Stage stage = (Stage) ((Node) e9.getSource()).getScene().getWindow();
        stage.close();
        System.exit(0);
    }

}




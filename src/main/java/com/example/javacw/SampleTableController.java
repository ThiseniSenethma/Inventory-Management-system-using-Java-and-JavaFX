//package com.example.javacw;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class SampleTableController {
//    @FXML
//    private TableView<RandomDealers> tableView;
//
//    @FXML
//    private TableColumn<RandomDealers, String> c1;
//
//    @FXML
//    private TableColumn<RandomDealers, String> c2;
//
//    @FXML
//    private TableColumn<RandomDealers, String> c3;
//
//    @FXML
//    private TableColumn<RandomDealers, String> c4;
//
//    @FXML
//    private Button continuebutton7;
//
//    @FXML
//    private Button exitbutton8;
//
//    public void initialize() {
//        // Set cell value factories for each column to map to the SampleDetails properties
//        c1.setCellValueFactory(new PropertyValueFactory<>("c1"));
//        c2.setCellValueFactory(new PropertyValueFactory<>("c2"));
//        c3.setCellValueFactory(new PropertyValueFactory<>("c3"));
//        c4.setCellValueFactory(new PropertyValueFactory<>("c4"));
//
//        // Create sample data
//        ObservableList<RandomDealers> data = FXCollections.observableArrayList();
//        data.add(new RandomDealers("1", "John", "123.45", "Location 1"));
//        data.add(new RandomDealers("2", "Alice", "678.90", "Location 2"));
//        data.add(new RandomDealers("3", "Bob", "543.21", "Location 3"));
//        data.add(new RandomDealers("4", "Emma", "987.65", "Location 4"));
//
//        tableView.setItems(data);
//    }
//
//    @FXML
//    void onContinueButtonClick(ActionEvent event) {
//        // Add your code for the Continue button click event here
//    }
//
//    @FXML
//    void onExitButton2Click(ActionEvent event) {
//        // Add your code for the Exit button click event here
//    }
//}
//

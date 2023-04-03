package realestate.realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditProperty {
    Stage stage;
    Scene scene;
    @FXML
    private TextField districtField;

    @FXML
    private Label districtLabel;

    @FXML
    private Button editButton;

    @FXML
    private Label loattionLabel;

    @FXML
    private TextField locationField;

    @FXML
    private Button rentSearchButton;

    @FXML
    private Button rentSearchButton1;

    @FXML
    private Button rentSearchButton11;

    @FXML
    private Button saleSearchButton;

    @FXML
    private Button saleSearchButton1;

    @FXML
    private Button saleSearchButton11;

    @FXML
    private Button saleSearchButton111;

    @FXML
    private Button saleSearchButton112;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private TextField sellerField;

    @FXML
    private Label sellerNameLabel;

    @FXML
    private TextField typeFiled;

    @FXML
    private Label typeLabel;

    @FXML
    void addProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddProperty.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void byArea(ActionEvent event) {

    }

    @FXML
    void byType(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("byType.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void edit(ActionEvent event) {

    }
    @FXML
    void removeProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("removeProp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void editProperty(ActionEvent event) {

    }

    @FXML
    void loanCalc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loanCalc.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void toRent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Availabilty.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toSale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

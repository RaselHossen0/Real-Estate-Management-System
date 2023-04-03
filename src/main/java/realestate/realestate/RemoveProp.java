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

public class RemoveProp {
    Stage stage;
    Scene scene;
    @FXML
    private Label districtField;

    @FXML
    private Label loattionField;

    @FXML
    private Button removeButton;

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
    private TextField searchFiled;

    @FXML
    private Label sellerNameField;

    @FXML
    private Label typeField;

    @FXML
    void addProperty(ActionEvent event) {

    }

    @FXML
    void byArea(ActionEvent event) {

    }

    @FXML
    void byType(ActionEvent event) {

    }

    @FXML
    void editProperty(ActionEvent event) {

    }

    @FXML
    void loanCalc(ActionEvent event) {

    }

    @FXML
    void removeProperty(ActionEvent event) {

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

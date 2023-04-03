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

public class LoanCalc {
Stage stage;
Scene scene;
    @FXML
    private Button calcButton;

    @FXML
    private TextField downField;

    @FXML
    private Label monthlyLabel;

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
    private TextField searchFiled;

    @FXML
    private TextField tenureField;
    @FXML
    private TextField interestFild;


    @FXML
    void addProperty(ActionEvent event) {

    }

    @FXML
    void byArea(ActionEvent event) {

    }
void calculation(){
        Integer propID= Integer.valueOf(searchFiled.getText());
    double propertyPrice = PropertyManager.getPriceOf(propID)* 100000;
    double downPayment = Double.parseDouble(downField.getText())* 100000;
    double loanAmount = propertyPrice - downPayment;

    double tenure = Double.parseDouble(tenureField.getText());

    double annualInterestRate = Double.parseDouble(interestFild.getText());

    double monthlyInterestRate = annualInterestRate / 12.0;
    int numberOfPayments = (int) (tenure * 12);

    double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
            / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

    monthlyLabel.setText(String.valueOf(monthlyPayment));

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
    void loanCalc(ActionEvent event) {
calculation();
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
    void editProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("editProperty.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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




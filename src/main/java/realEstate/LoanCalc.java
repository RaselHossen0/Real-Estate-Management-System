package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import realEstate.Main_Classes.PropertyManager;

public class LoanCalc extends Scene_Change{
Stage stage;
Scene scene;
    @FXML
    private Button calcButton;

    @FXML
    private TextField downField;

    @FXML
    private Label monthlyLabel;

    @FXML
    private TextField searchFiled;

    @FXML
    private TextField tenureField;
    @FXML
    private TextField interestFild;

void monthlyLoan(){
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
    void loanCalc(ActionEvent event) {
monthlyLoan();
    }

}




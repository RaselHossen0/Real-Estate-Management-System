package realestate.realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ByType implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> typeBox;

    @FXML
    void addProperty(ActionEvent event) {

    }
    void boxValue() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("byType.txt"));
        writer.write(typeBox.getValue());
        writer.close();
    }

    @FXML
    void backtoDash(ActionEvent event) {

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
    void search(ActionEvent event) throws IOException {
        boxValue();
        Parent root = FXMLLoader.load(getClass().getResource("byTypeResult.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toRent(ActionEvent event) {

    }

    @FXML
    void toSale(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeBox.getItems().addAll("Flat","Land");
    }
}

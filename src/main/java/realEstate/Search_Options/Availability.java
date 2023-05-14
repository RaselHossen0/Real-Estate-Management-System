package realEstate.Search_Options;

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
import realEstate.Scene_Change;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Availability  extends Scene_Change implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private ChoiceBox<String> availabiltyBox;

    @FXML
    private Button backButton;

    @FXML
    private Button searchButton;


    @FXML
    void toRent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml_files/Availabilty.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backtoDash(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml_files/DashBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        availabiltyBox.getItems().addAll("Rent", "Sale");
    }

    void boxValue() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("Availability.txt"));
        List<String> list=new ArrayList<>();
        writer.write(availabiltyBox.getValue());
        writer.close();
    }

    @FXML
    void search(ActionEvent event) throws IOException {
        boxValue();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_files/AvaiabiltyResult.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

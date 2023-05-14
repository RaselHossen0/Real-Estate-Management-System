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
import java.util.Objects;
import java.util.ResourceBundle;

public class ByType extends Scene_Change implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> typeBox;

    void boxValue() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("byType.txt"));
        writer.write(typeBox.getValue());
        writer.close();
    }

    @FXML
    void search(ActionEvent event) throws IOException {
        boxValue();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml_files/byTypeResult.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeBox.getItems().addAll("Flat","Land");
    }

}

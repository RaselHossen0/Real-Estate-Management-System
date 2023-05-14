package realEstate.AgentCreation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private ChoiceBox<String> areaBox;

    @FXML
    private CheckBox buyerTick;

    @FXML
    private ChoiceBox<String> districtBox;

    @FXML
    private TextField emailField;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox sellerTick;

    @FXML
    private Button signupButton;

    @FXML
    void signup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml_files/Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        writingTOfile();


    }

    public void writingTOfile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("new-user.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("new-user.txt", true));
        try {
            String nam = nameField.getText();
            String pass = passwordField.getText();
            String buyerTICK;
            if (buyerTick.isSelected())
                buyerTICK = "Yes";
            else
                buyerTICK = "No";
            String sellerTICK;
            if (sellerTick.isSelected())
                sellerTICK = "Yes";
            else
                sellerTICK = "No";
            String email = emailField.getText();
            String mobile = mobileField.getText();
            String area = areaBox.getValue();
            String district = districtBox.getValue();
            writer.write(nam + "/" + pass + "/" + email + "/" + area + "/" + district + "/" + mobile + "/" + sellerTICK + "/" + buyerTICK + "\n");
            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        areaBox.getItems().addAll("Dhanmondi", "Gulshan", "Uttara", "Motijheel", "Chawkbazar", "Old Dhaka", "Shahbagh");
        districtBox.getItems().addAll("Dhaka", "Barishal", "Rajshahi", "Sylhet", "Mymenshinh", "Chattogram", "Rajbari");
    }
}

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
import realEstate.DashBoard;
import realEstate.Main_Classes.PropertyManager;
import realEstate.Scene_Change;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InArea extends Scene_Change implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private Button saleSearchButton1;


    @FXML
    ChoiceBox<String> locationBox;

    @FXML
    ChoiceBox<String> districtBox;


    @FXML
    void backtoDash(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml_files/DashBoard.fxml"));
        Parent root = loader.load();
        DashBoard ds=loader.getController();
        Integer totProp= PropertyManager.getTotalProperties();
        ds.listeddPropLabel.setText(String.valueOf(totProp));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        locationBox.getItems().addAll("Dhanmondi", "Gulshan", "Uttara", "Motijheel", "Chawkbazar", "Old Dhaka", "Shahbagh", "Mohammadpur", "Mirpur", "Banani", "Baridhara", "Bashundhara", "Nikunja", "Khilgaon", "Panthapath", "Farmgate", "Malibagh", "New Eskaton", "Siddheswari", "Jatrabari", "Wari", "Gendaria", "Mugda", "Kamrangirchar", "Keraniganj", "Demra", "Kadamtali", "Sabujbagh", "Shyampur", "Badda", "Tejgaon", "Basabo", "Basundhara Residential Area", "Shantinagar", "Hazaribagh", "Lalbagh", "Sutrapur", "Ramna", "Palton", "Dakhshinkhan", "Bimanbandar", "Khilkhet", "Nakhalpara", "Mirpur DOHS", "Rampura", "Merul Badda", "Dhaka Cantonment", "Banglamotor", "Gulistan", "Armanitola", "Postogola", "Chak Bazar", "Banga Bazar", "Shampur", "Kalyanpur", "Uttar Khan", "Azimpur", "Nawabganj", "Tongi", "Kafrul", "Mohakhali", "Bijoynagar", "Gandaria Thana", "Hajipara", "Jatrabari Thana", "Sayedabad", "Sukrabad", "Turag", "Wari Thana");
        districtBox.getItems().addAll("Dhaka", "Barishal", "Rajshahi", "Sylhet", "Mymenshinh", "Chattogram", "Rajbari");
    }


    void boxValue() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("inArea.txt"));
        List<String> list=new ArrayList<>();
        writer.write(districtBox.getValue()+"/"+locationBox.getValue());
        list.add(districtBox.getValue());
        list.add(locationBox.getValue());
        writer.close();
    }


    @FXML
    void search(ActionEvent event) throws IOException {
        boxValue();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml_files/InAreaResult.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

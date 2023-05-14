package realEstate.Search_Options;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import realEstate.Main_Classes.Property;
import realEstate.Main_Classes.PropertyManager;
import realEstate.Scene_Change;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class InAreaResult extends Scene_Change implements Initializable {

    Stage stage;
    Scene scene;



        @FXML

        Label test;
        @FXML
        private TableColumn<Property, String> sellerNameCol;
        @FXML
        private TableColumn<Property, String> locationCol;
        @FXML
        private TableColumn<Property, Integer> priceCol;
        @FXML
        private TableColumn<Property, Integer> serialCol;

        @FXML
        private TableColumn<Property, String> districtCol;
        @FXML
        private TableColumn<Property, String> typeCol;


        @FXML
        private TableView<Property> table;

        ObservableList<Property> list = FXCollections.observableArrayList();


        void search () throws FileNotFoundException {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("inArea.txt"));
                String whole = reader.readLine();
                ArrayList<String> row = new ArrayList<String>(20);  //to store all info of a user
                row.add((Arrays.toString(whole.split("/"))));
                String[] splitString = row.get(0).replaceAll("\\[", "").replaceAll("\\]", "").split(", ");
                String district = splitString[0];
                String location = splitString[1];
                List<Property> list1;
                list1 = PropertyManager.getArea(district,location);
                list.addAll(list1);
                reader.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public void initialize (URL location, ResourceBundle resources){
            try {
                search();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            locationCol.setCellValueFactory(new PropertyValueFactory<Property, String>("location"));
            sellerNameCol.setCellValueFactory(new PropertyValueFactory<Property, String>("sellerName"));
            serialCol.setCellValueFactory(new PropertyValueFactory<Property, Integer>("propertyID"));
            priceCol.setCellValueFactory(new PropertyValueFactory<Property, Integer>("price"));
            districtCol.setCellValueFactory(new PropertyValueFactory<Property, String>("district"));
            typeCol.setCellValueFactory(new PropertyValueFactory<Property, String>("type"));
            table.setItems(list);
        }
}

package realEstate.Search_Options;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import realEstate.Main_Classes.Property;
import realEstate.Main_Classes.PropertyManager;
import realEstate.Scene_Change;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AvailabilityResult extends Scene_Change implements Initializable {

    @FXML
    private TableColumn<Property, String> availabilityCol;

    @FXML
    private TableColumn<Property, String> districtCol;

    @FXML
    private TableColumn<Property,Integer> idCol;

    @FXML
    private TableColumn<Property,String> locationCol;

    @FXML
    private TableColumn<Property,String> nameCol;

    @FXML
    private TableColumn<Property,Integer> priceCol;

    @FXML
    private TableView<Property> table;
    ObservableList<Property> list = FXCollections.observableArrayList();


    Stage stage;
    Scene scene;


    void searchAvailability(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/fxml_files/Availability.txt"));
            String whole = reader.readLine();
            List<Property> list1;
            PropertyManager.retrieve();
            list1 = PropertyManager.getAvailAbility(whole);
            list.addAll(list1);
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        try {
            searchAvailability();
        }
        catch (Exception e){
            System.out.println(e);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<Property,Integer>("propertyID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Property,String>("sellerName"));
        districtCol.setCellValueFactory(new PropertyValueFactory<Property,String>("district"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Property,String>("location"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<Property,String>("availability"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Property,Integer>("price"));
        table.setItems(list);
    }

}

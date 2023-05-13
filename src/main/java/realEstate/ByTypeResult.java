package realEstate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import realEstate.classes.Property;
import realEstate.classes.PropertyManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ByTypeResult implements Initializable {
    Stage stage;
    Scene scene;




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

    @FXML
    void addCustomer(ActionEvent event) {

    }

    @FXML
    void addProperty(ActionEvent event) {

    }

    @FXML
    void byArea(ActionEvent event) {

    }

    @FXML
    void dashBoard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    void toAvailability(ActionEvent event) {

    }
    @FXML
    void byType(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("byType.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    void search () throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("byType.txt"));
            String whole = reader.readLine();
            List<Property> list1;
            list1 = PropertyManager.getType(whole);
            list.addAll(list1);
            reader.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

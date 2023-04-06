package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import realEstate.classes.Property;
import realEstate.classes.PropertyManager;

import java.io.IOException;

public class RemoveProp {

    public Label typeLabel;
    public Label locationLabel;
    public Label districtLabel;
    public Label sellerNameLabel;
    public TextField searchFiled;
    Stage stage;
    Scene scene;
    public Property searchID(){
        Integer id= Integer.valueOf(searchFiled.getText());
        Property toBEedited;
        toBEedited= PropertyManager.getbyID(id);
        try{
            if(toBEedited.getPropertyID()==null){
//                idLabel.setText("Please enter correct id!!");
//                idLabel.setTextFill(Color.WHITE);
//                idLabel.setPrefWidth(153);
                return null;
            }
            else{
//                idLabel.setText("Enter Property ID");
//                idLabel.setTextFill(Color.BLACK);
                sellerNameLabel.setText(toBEedited.getSellerName());
                typeLabel.setText(toBEedited.getType());
                districtLabel.setText(toBEedited.getDistrict());
                locationLabel.setText(toBEedited.getLocation());

            }
        }catch (Exception e){
            // System.out.println(e);
        }
        return toBEedited;
    }

    @FXML
    void addProperty(ActionEvent event) {

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

    public void search(ActionEvent event) {
        searchID();
    }

    public void remove(ActionEvent event) {
        PropertyManager.deleteFromFile(searchID(),"Delete");
    }
}

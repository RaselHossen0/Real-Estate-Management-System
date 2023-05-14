package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import realEstate.Main_Classes.Property;
import realEstate.Main_Classes.PropertyManager;

public class EditProperty extends Scene_Change {
    Stage stage;
    Scene scene;
    @FXML
    private TextField districtField;

    @FXML
    private Label districtLabel;

    @FXML
    private Button editButton;

    @FXML
    private Label loattionLabel;
    @FXML
    private Label  errorMessage;

    @FXML
    private TextField locationField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private TextField sellerField;

    @FXML
    private Label sellerNameLabel;

    @FXML
    private TextField typeFiled;

    @FXML
    private Label typeLabel;
    @FXML
    private TextField priceFild;

    @FXML
    private Label priceLabel;
    @FXML
    private Label idLabel;






    @FXML
    void edit(ActionEvent event) {
        edit(serachbyID());
        districtField.clear();
        locationField.clear();
        sellerField.clear();
        priceFild.clear();
        typeFiled.clear();

    }





   public Property serachbyID(){
        Integer id= Integer.valueOf(searchField.getText());
        Property toBEedited;
        toBEedited=PropertyManager.getByID(id);
        try{

            if(toBEedited.getPropertyID()==null){
                return null;
            }
            else{
                sellerNameLabel.setText(toBEedited.getSellerName());
                typeLabel.setText(toBEedited.getType());
                districtLabel.setText(toBEedited.getDistrict());
                loattionLabel.setText(toBEedited.getLocation());
                priceLabel.setText(String.valueOf(toBEedited.getPrice()));
            }
        }catch (Exception e){
           System.out.println(e);
        }
        return toBEedited;
    }
    public void edit(Property prp){
        prp.setSellerName(sellerField.getText());
       prp.setType(typeFiled.getText());
        prp.setDistrict(districtField.getText());
        prp.setLocation(locationField.getText());
       prp.setPrice(Integer.valueOf(priceFild.getText()));
       PropertyManager.deleteFromFile(prp,"Edit");
    }
    @FXML
    void search(ActionEvent event) {
        if(serachbyID()==null) {
            errorMessage.setVisible(true);
            errorMessage.setText("No property with this ID!");
        }
        else {
            serachbyID();
            errorMessage.setVisible(false);
           errorMessage.setText("");
        }
    }




}

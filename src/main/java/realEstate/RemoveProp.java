package realEstate;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import realEstate.Main_Classes.Property;
import realEstate.Main_Classes.PropertyManager;

public class RemoveProp extends  Scene_Change{

    public Label typeLabel;
    public Label locationLabel;
    public Label districtLabel;
    public Label sellerNameLabel;
    public Label errorMessage;
    public TextField searchFiled;
    Stage stage;
    Scene scene;
    public Property searchID(){
        Integer id= Integer.valueOf(searchFiled.getText());
        Property toBEedited;
        toBEedited= PropertyManager.getByID(id);
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
    public void search(ActionEvent event) {
        if(searchID()==null) {
            errorMessage.setVisible(true);
            errorMessage.setText("Please Enter Correct ID!");
            errorMessage.setTextFill(Color.RED);
            errorMessage.setStyle("-fx-background-color: white;");
            clear();
        }
        else {
            errorMessage.setVisible(false);
            searchID();
        }
    }
    public void clear(){
        sellerNameLabel.setText("");
        typeLabel.setText("");
        districtLabel.setText("");
        locationLabel.setText("");

    }

    public void remove(ActionEvent event) {
        PropertyManager.deleteFromFile(searchID(),"Delete");
    }
}

package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import realEstate.classes.Property;
import realEstate.classes.PropertyManager;

import java.io.IOException;
import java.util.Objects;

public class EditProperty {
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
    void addProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddProperty.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void byArea(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inArea.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void byType(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("byType.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void edit(ActionEvent event) {
        edit(serachbyID());
        districtField.clear();
        locationField.clear();
        sellerField.clear();
        priceFild.clear();
        typeFiled.clear();

    }
    @FXML
    void removeProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("removeProp.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void editProperty(ActionEvent event) {

    }

    @FXML
    void loanCalc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loanCalc.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        if(serachbyID()==null)
            errorMessage.setText("No property with this ID!");
        else {
            serachbyID();
            errorMessage.setText("");
        }
    }

    @FXML
    void toDash(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("DashBoard.fxml"));
        Parent root = loader.load();
        DashBoard ds=loader.getController();
        Integer totProp= PropertyManager.getTotalProperties();
        ds.listeddPropLabel.setText(String.valueOf(totProp));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void addCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddCustomer.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

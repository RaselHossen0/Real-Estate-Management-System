package realestate.realestate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddProperty {
    Stage stage;
    Scene scene;
    @FXML
    private TextField contactFild;

    @FXML
    private TextField propIDFild;

    @FXML
    private TextField desFild;

    @FXML
    private TextField districtField;

    @FXML
    private RadioButton flatTick;

    @FXML
    private RadioButton landTick;

    @FXML
    private TextField locationField;

    @FXML
    private TextField pathFild;

    @FXML
    private Button postSubmitButton;

    @FXML
    private TextField priceField;

    @FXML
    private Button rentSearchButton;

    @FXML
    private Button rentSearchButton1;

    @FXML
    private Button rentSearchButton11;

    @FXML
    private RadioButton rentTick;

    @FXML
    private Button saleSearchButton;

    @FXML
    private Button saleSearchButton1;

    @FXML
    private Button saleSearchButton11;

    @FXML
    private Button saleSearchButton111;

    @FXML
    private Button saleSearchButton112;

    @FXML
    private RadioButton saleTick;

    @FXML
    private TextField sellNamFild;

    @FXML
    private TextField sizeFild;
    @FXML
    void listed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("listedProperties.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void post(ActionEvent event) {

    }
    PropertyManager retrieveFromFile() throws IOException {
        PropertyManager allProp=new PropertyManager();
        BufferedReader reader=new BufferedReader(new FileReader("addProperty.txt"));
        String  Name;
        String whole;
        while ((whole = reader.readLine()) != null) {
            ArrayList<String> row = new ArrayList<String>(10);  //to store all info of a user
            row.add((Arrays.toString(whole.split("/"))));
            String[] splitString = row.get(0).replaceAll("\\[", "").replaceAll("\\]", "").split(", ");

            try {
                if (splitString[6].equals("Yes")) {
                   // type = 1;
                    //two[1] = type;
                } else if (splitString[7].equals("Yes")) {
                   // type = 2;
                    //two[1] = type;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        reader.close();
        return  allProp;
    }

    @FXML
    void postSubmit(ActionEvent event) throws IOException {
        writeFile();
        formClear();
    }


    void writeFile() throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter("addProperty.txt",true));

        Integer price= Integer.valueOf(priceField.getText());
        String propertyID=propIDFild.getText();
        String district=districtField.getText();
        String location=locationField.getText();


        String type=null;
        String selRent = null;
        if (saleTick.isSelected() && !rentTick.isSelected())
           selRent = "Sale";
        else if (!saleTick.isSelected() && rentTick.isSelected())
           selRent = "Rent";
        if (flatTick.isSelected() && !landTick.isSelected())
            type = "Flat";
        else if (!flatTick.isSelected() && landTick.isSelected())
            type = "Land";

        String size=sizeFild.getText();
        String description=desFild.getText();
        String sellerName=sellNamFild.getText();
        String contact=contactFild.getText();
        String imagePath=pathFild.getText();
        writer.write(price+"/"+propertyID+"/"+district+"/"+location+"/"+type+"/"+selRent+"/"+size+"/"
        +description+"/"+sellerName+"/"+contact+"/"+imagePath+"\n");
        writer.close();
    }
    int savingPost() throws IOException {
        int flag = 1;        //general case
        Property newProperty = new Property();
        newProperty.district = districtField.getText();
        //newProperty.price = ((priceField.getText()));
        //newProperty.country = countryFiled.getText();
        newProperty.location = locationField.getText();
        newProperty.landArea = sizeFild.getText();

        if (flatTick.isSelected() && !landTick.isSelected())
            newProperty.type = "Flat";
        else if (!flatTick.isSelected() && landTick.isSelected())
            newProperty.type = "land";
        else {
            flag = 0;
            System.out.println("Please select property type");
        }
        //to determine if property is for sale or rent
        if (saleTick.isSelected() && !rentTick.isSelected())
            newProperty.availability = "Sale";
        else if (!saleTick.isSelected() && rentTick.isSelected())
            newProperty.availability = "Rent";
        else {
            flag = 0;
            System.out.println("Please select only one type");
        }

//        if (newProperty.price == null || newProperty.country == null || newProperty.type == null ||
//                newProperty.availability == null || newProperty.location == null || newProperty.landArea == null
//        )
            flag = 0;
      //  if (flag == 1) {
            newProperty.writingFile();
       // }
        //properties.addProperty(newProperty);
        return flag;
    }
    @FXML
    void addProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddProperty.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void byArea(ActionEvent event) {

    }

    @FXML
    void byType(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("byType.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void editProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("editProperty.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loanCalc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loanCalc.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void removeProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("removeProp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
    void formClear() {
        priceField.clear();
        propIDFild.clear();
        districtField.clear();
        sizeFild.clear();
        locationField.clear();
        flatTick.setSelected(false);
        landTick.setSelected(false);
        rentTick.setSelected(false);
        saleTick.setSelected(false);
    }







}

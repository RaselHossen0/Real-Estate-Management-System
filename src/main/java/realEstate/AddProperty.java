package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import realEstate.Main_Classes.Property;
import realEstate.Main_Classes.PropertyManager;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AddProperty extends Scene_Change {
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
    private Button pathFild;
    String path;

    @FXML
    private RadioButton saleTick;

    @FXML
    private TextField sellNamFild;

    @FXML
    private TextField sizeFild;
    @FXML
    void listed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml_files/listedProperties.fxml")));
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
        String imagePath=path;
        writer.write(price+"/"+propertyID+"/"+district+"/"+location+"/"+type+"/"+selRent+"/"+size+"/"
        +description+"/"+sellerName+"/"+contact+"/"+imagePath+"\n");
        writer.close();
    }
    int savingPost() throws IOException {
        int flag = 1;        //general case
        Property newProperty = new Property();
        newProperty.setDistrict(districtField.getText());
        //newProperty.price = ((priceField.getText()));
        //newProperty.country = countryFiled.getText();
        newProperty.setLocation(locationField.getText());
        newProperty.setSize(sizeFild.getText());

        if (flatTick.isSelected() && !landTick.isSelected())
            newProperty.setType("Flat");
        else if (!flatTick.isSelected() && landTick.isSelected())
            newProperty.setType("land");
        else {
            flag = 0;
            System.out.println("Please select property type");
        }
        //to determine if property is for sale or rent
        if (saleTick.isSelected() && !rentTick.isSelected())
            newProperty.setAvailability("Sale");
        else if (!saleTick.isSelected() && rentTick.isSelected())
            newProperty.setAvailability("Rent");
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
    void  chooseDirectory() {
        // Create a file chooser
        FileChooser fileChooser = new FileChooser();

        // Set the initial directory
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        String file=null;
        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(stage);

            System.out.println("Selected file: " + selectedFile.getPath());

            // Get the path of the directory where the file will be saved
        try {
            File targetDirectory = new File("src/main/resources/images/");

            // Copy the file to the target directory
            path = new File(targetDirectory, selectedFile.getName()).getPath();
                Files.copy(selectedFile.toPath(), new File(targetDirectory, selectedFile.getName()).toPath());
           // System.out.println(copiedFilePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        // If the user selected a file, print its path

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

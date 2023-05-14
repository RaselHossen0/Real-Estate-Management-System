package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AddCustomer extends Scene_Change implements Initializable {
    String url = "jdbc:mysql://localhost:3306/CUSTOMER";
    String user = "rasel";
    String password = "Rasel2003@";


    @FXML
    private ChoiceBox<String> AreaBox;

    @FXML
    private RadioButton buyerTik;

    @FXML
    private TextField contactFild;

    @FXML
    private ChoiceBox<String> districtBox;

    @FXML
    private TextField idFild;

    @FXML
    private TextField nameFild;

    @FXML
    private RadioButton sellerTik;
    public void setDataTOtable(){
        String name=nameFild.getText();
        Integer id= Integer.valueOf(idFild.getText());
        String district=districtBox.getValue();
        String location=AreaBox.getValue();
        String type = "";
        if(sellerTik.isSelected()) type="Seller";
        else if(buyerTik.isSelected()) type="Buyer";
        String contact=contactFild.getText();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO `customer data` (Name,Contact,District,Location,Property_ID,Customer_Type) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setInt(2, Integer.parseInt(contact));
                stmt.setString(3,district);
                stmt.setString(4,location);
                stmt.setInt(5,id);
                stmt.setString(6,type);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error inserting values: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }




    @FXML
    void add(ActionEvent event) {
        setDataTOtable();
    }
    @FXML
    private ChoiceBox<String> costBox;
    @FXML
    private ChoiceBox<String> countryBox;
    Stage stage;
    Scene scene;





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        AreaBox.getItems().addAll("Dhanmondi", "Gulshan", "Uttara", "Motijheel", "Chawkbazar", "Old Dhaka", "Shahbagh");
        districtBox.getItems().addAll("Dhaka", "Barishal", "Rajshahi", "Sylhet", "Mymenshinh", "Chattogram", "Rajbari");
    }




}

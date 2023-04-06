package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.sql.*;


public class AddCustomer implements Initializable {
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

    public AddCustomer() throws SQLException {
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

    @FXML
    void toListed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inArea.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toRent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Availabilty.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toSale(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddCustomer.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        AreaBox.getItems().addAll("Dhanmondi", "Gulshan", "Uttara", "Motijheel", "Chawkbazar", "Old Dhaka", "Shahbagh");
        districtBox.getItems().addAll("Dhaka", "Barishal", "Rajshahi", "Sylhet", "Mymenshinh", "Chattogram", "Rajbari");
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
    void addProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddProperty.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void editProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("editProperty.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void loanCalc(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loanCalc.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void removeProperty(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("removeProp.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}

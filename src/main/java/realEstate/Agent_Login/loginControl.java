package realEstate.Agent_Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import realEstate.DashBoard;
import realEstate.Main_Classes.PropertyManager;

import java.io.IOException;

public class loginControl {
    @FXML
    private Button dashboard;
    Stage stage;
    Scene scene;
    @FXML
    void dashboardOnAction(ActionEvent event) throws IOException {
        try{
            //dashboard.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml_files/DashBoard.fxml"));
            Parent root = loader.load();
            DashBoard ds=loader.getController();
            Integer totProp= PropertyManager.getTotalProperties();
            ds.listeddPropLabel.setText(String.valueOf(totProp));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
        catch (Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void profileOnAction(ActionEvent event) throws IOException {
        try{

            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml_files/profile.fxml"));
            Parent root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
        catch (Exception e){
            System.out.println(e);
        }
    }
}

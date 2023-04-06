package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import realEstate.classes.PropertyManager;

import java.io.IOException;

public class startControl {
    Stage stage;
    Scene scene;

    @FXML
    void enter(ActionEvent event) throws IOException {
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("DashBoard.fxml"));
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

}

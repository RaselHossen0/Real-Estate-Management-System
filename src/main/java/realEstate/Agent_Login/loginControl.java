package realEstate.Agent_Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import realEstate.Scene_Change;

import java.io.IOException;

public class loginControl extends Scene_Change {
    @FXML
    private Button dashboard;
    Stage stage;
    Scene scene;

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

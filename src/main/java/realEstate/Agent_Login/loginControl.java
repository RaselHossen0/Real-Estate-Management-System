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

    /*public class SlidingMenuBar {
    @FXML
    private VBox menuBar;
    private TranslateTransition slideInTransition;
    private TranslateTransition slideOutTransition;

    @FXML
    private void initialize() {
        // Create and configure the slide-in transition
        slideInTransition = new TranslateTransition(Duration.millis(300), menuBar);
        slideInTransition.setFromX(-menuBar.getWidth());
        slideInTransition.setToX(0);

        // Create and configure the slide-out transition
        slideOutTransition = new TranslateTransition(Duration.millis(300), menuBar);
        slideOutTransition.setFromX(0);
        slideOutTransition.setToX(-menuBar.getWidth());
    }

    @FXML
    private void toggleMenu() {
        if (menuBar.getTranslateX() == 0) {
            // Slide out the menu
            slideOutTransition.play();
        } else {
            // Slide in the menu
            slideInTransition.play();
        }
    }

    @FXML
    private void openNewWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("new_window.fxml"));
        Parent root = loader.load();

        // Get the controller of the new window
        NewWindowController newWindowController = loader.getController();

        // Pass any necessary data to the new window controller

        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
}*/
    @FXML
    void profileOnAction(ActionEvent event) throws IOException {
        try{

            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml_files/profile.fxml"));
            Parent root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root,1200,700);
            stage.setScene(scene);
            stage.show();}
        catch (Exception e){
            System.out.println(e);
        }
    }
}

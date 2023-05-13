package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import realEstate.classes.PropertyManager;

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

            FXMLLoader loader=new FXMLLoader(getClass().getResource("profile.fxml"));
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

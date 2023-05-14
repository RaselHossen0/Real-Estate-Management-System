package realEstate;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class profileControl {
    @FXML
    private Button cancelButton;
    @FXML
    private Label Username;
    @FXML
    private Label Number;
    @FXML
    private Label Mail;
    @FXML
    private AnchorPane menuBar;
    private TranslateTransition slideInTransition;
    private TranslateTransition slideOutTransition;



    public void initialize() {


        try {

            // Read data from file
            BufferedReader reader = new BufferedReader(new FileReader("signup.txt"));
            String line = reader.readLine();
            String[] data = line.split(",");

            // Set label text
            Username.setText(data[1]);
            Mail.setText(data[0]);
            Number.setText(data[2]);


            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Create and configure the slide-in transition
        slideInTransition = new TranslateTransition(Duration.millis(1000), menuBar);
        slideInTransition.setFromX(-menuBar.getWidth());
        slideInTransition.setToX(415);





        // Create and configure the slide-out transition
        slideOutTransition = new TranslateTransition(Duration.millis(1000), menuBar);
        slideOutTransition.setFromX(400);
        slideOutTransition.setToX(menuBar.getWidth());





    }
    @FXML
    private void menuButOnAction() {
        if (menuBar.getTranslateX() == 0) {
            // Slide out the menu
            //slideOutTransition.play();
            slideInTransition.play();
        } else {
            // Slide in the menu
            slideInTransition.play();
        }
    }
    @FXML
    private void slideButtonOnAction() {
        if (menuBar.getTranslateX() == 0) {
            // Slide out the menu
            slideOutTransition.play();
        } else {
            // Slide in the menu
            slideOutTransition.play();
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
    private void homeOnAction(){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
                Parent root = loader.load();

                // Get the current stage
                Stage currentStage = (Stage) menuBar.getScene().getWindow();

                // Create a new stage for the new FXML
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root,1200,700));
                newStage.show();

                // Close the current stage
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
    @FXML
    private void canOnAction(){
        Stage currentStage = (Stage) menuBar.getScene().getWindow();
        currentStage.close();
    }







    Stage stage;
    Scene scene;
    @FXML
    void dashOnAction(ActionEvent event) throws IOException {
        try{

            FXMLLoader loader=new FXMLLoader(getClass().getResource("login.fxml"));
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

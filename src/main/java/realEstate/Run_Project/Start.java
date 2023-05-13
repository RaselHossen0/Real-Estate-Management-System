package realEstate.Run_Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import realEstate.Main_Classes.PropertyManager;

import java.io.IOException;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(startControl.class.getResource("/fxml_files/start.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
           // scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setTitle("Real Estate Management");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        PropertyManager.retrieve();
        launch();
    }
}

package realEstate;

import javafx.application.Application;
import javafx.stage.Stage;
import realEstate.classes.PropertyManager;

import java.io.IOException;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        PropertyManager.retrieve();
        launch();
    }
}

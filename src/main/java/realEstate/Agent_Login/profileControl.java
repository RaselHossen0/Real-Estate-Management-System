package realEstate.Agent_Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class profileControl {
    @FXML
    private Label Username;
    @FXML
    private Label Number;
    @FXML
    private Label Mail;


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

    }



    Stage stage;
    Scene scene;
    @FXML
    void dashOnAction(ActionEvent event) throws IOException {
        try{

            FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml_files/login.fxml"));
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

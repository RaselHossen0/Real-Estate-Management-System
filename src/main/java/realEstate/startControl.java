package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class startControl {
    @FXML
    private Button cancelBut;
    @FXML
    private Button forgetPassBut;

    @FXML
    private TextField username;
    //username changed to email
    @FXML
    private PasswordField password;
    @FXML
    private Label loginMsg;



    @FXML
    private void forgetPassOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forgetPass.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("SECURITY");
            stage.initModality(Modality.APPLICATION_MODAL); // Set modality to make it a pop-up window
            stage.initOwner(forgetPassBut.getScene().getWindow()); // Set the owner window
            stage.setX(forgetPassBut.getScene().getWindow().getX()+300);
            stage.setY(forgetPassBut.getScene().getWindow().getY()+26);
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Show the pop-up window and wait until it's closed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loginButOnAction(ActionEvent event){
        // loginMsg.setText("Please enter username and password");

        if(username.getText().isBlank()==false&&password.getText().isBlank()==false) {
            validatelogin();
            // loginMsg.setText("Please enter ");
        }
        else
            loginMsg.setText("Please enter username and password");

    }


    public void cancelButOnAction(ActionEvent event) {
        Stage stage=(Stage) cancelBut.getScene().getWindow();
        stage.close();
    }



    public void validatelogin(){
        String filename = "users.txt";
        String line;
        boolean valid = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String uname = parts[0].trim();
                String pass = parts[1].trim();

                if (username.getText().equals(uname) && password.getText().equals(pass)) {
                    valid = true;
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (valid) {
           // loginMsg.setText("Congratulations");
            try (FileWriter fileWriter = new FileWriter("login.txt", false);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write the data from the text fields and password fields to the file
                bufferedWriter.write( username.getText());
                bufferedWriter.newLine();

            } catch (IOException e) {
                // Handle any exceptions that might occur while writing to the file
                e.printStackTrace();
            }
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Close the login window
                Stage loginStage = (Stage) username.getScene().getWindow();
                loginStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader loginReader = new BufferedReader(new FileReader("login.txt"));
                String loginText = loginReader.readLine(); // read the entire line from login.txt
                loginReader.close();

                BufferedReader dataReader = new BufferedReader(new FileReader("profileInfo.txt"));
                String finalline;
                while ((finalline = dataReader.readLine()) != null) {
                    String[] parts = finalline.split(","); // split the line by comma
                    if (parts[0].equals(loginText)) { // check if the first element matches the login text
                        BufferedWriter loginWriter = new BufferedWriter(new FileWriter("signup.txt", false));
                        loginWriter.write(finalline); // write the entire line from data.txt to signup.txt
                        loginWriter.newLine(); // write a new line character to separate multiple lines
                        loginWriter.close();
                        break; // stop searching once a match is found
                    }
                }
                dataReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }





            //  FXMLLoader loader=new FXMLLoader(getClass().getResource("DashBoard.fxml"));


        } else {
            loginMsg.setText("Invalid login, please try again.");
        }
    }

    Stage stage;
    Scene scene;


    @FXML
    void signup(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("signupnow.fxml"));
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

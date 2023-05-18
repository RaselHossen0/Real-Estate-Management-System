package realEstate.AgentCreation;

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
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class signupController {
    @FXML
    private Button CreateAccount;


    @FXML
    private TextField Firstname;
    @FXML
    private TextField Lastname;
    @FXML
    private TextField ContactNumber;
    @FXML
    private TextField Email;
    @FXML
    private TextField securityQ;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPassword;
    @FXML
    private Label msg1;
    @FXML
    private Label msg2;


    private boolean accountCreated = false;
    Stage stage;
    Scene scene;

    public void CreateAccountOnAction(ActionEvent event){
        // loginMsg.setText("Please enter username and password");
        if (accountCreated) {
            // handle second click

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

        else if(Firstname.getText().isBlank()==false&&Lastname.getText().isBlank()==false&&ContactNumber.getText().isBlank()==false&&Email.getText().isBlank()==false&&securityQ.getText().isBlank()==false&&Password.getText().isBlank()==false&&ConfirmPassword.getText().isBlank()==false) {
            validateSignup();



        }
        else {
            msg2.setVisible(false);
            msg1.setVisible(true);

            msg1.setText("Please fill out all required fields to continue");
        }


    }

    private void validateSignup() {


        if (Password.getText().equals(ConfirmPassword.getText())) {

            msg2.setVisible(false);
            msg1.setVisible(true);

            msg1.setText("Congratulations!! You are ready to create your account");
            CreateAccount.setText("Create Account");
            CreateAccount.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            // clickableBut.setDisable(false);
            accountCreated = true;
            // CreateAccount.setDisable(true);
            // Open a FileWriter and BufferedWriter to write to the file
            try (FileWriter fileWriter = new FileWriter("data.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write the data from the text fields and password fields to the file
                bufferedWriter.write(Firstname.getText() + "," + Lastname.getText() + "," +
                        ContactNumber.getText() + "," + Email.getText() + ","+ securityQ.getText() + "," + Password.getText());
                bufferedWriter.newLine();

            } catch (IOException e) {
                // Handle any exceptions that might occur while writing to the file
                e.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter("users.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write the data from the text fields and password fields to the file
                bufferedWriter.write( Email.getText() + "," + Password.getText());
                bufferedWriter.newLine();

            } catch (IOException e) {
                // Handle any exceptions that might occur while writing to the file
                e.printStackTrace();
            }

            try (FileWriter fileWriter = new FileWriter("profileInfo.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write the data from the text fields and password fields to the file
                bufferedWriter.write( Email.getText()+","+Firstname.getText() +" "+ Lastname.getText() + "," +
                        ContactNumber.getText());
                bufferedWriter.newLine();

            } catch (IOException e) {
                // Handle any exceptions that might occur while writing to the file
                e.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter("signup.txt", false);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write the data from the text fields and password fields to the file
                bufferedWriter.write( Email.getText()+","+Firstname.getText() +" "+ Lastname.getText() + "," +
                        ContactNumber.getText());
                bufferedWriter.newLine();

            } catch (IOException e) {
                // Handle any exceptions that might occur while writing to the file
                e.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter("forgetpass.txt", true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write the data from the text fields and password fields to the file
                bufferedWriter.write( Email.getText()+","+securityQ.getText());
                bufferedWriter.newLine();

            } catch (IOException e) {
                // Handle any exceptions that might occur while writing to the file
                e.printStackTrace();
            }





        } else {
            msg1.setVisible(false);
            msg2.setVisible(true);
            msg2.setText("Password confirmation doesn't match ");
        }


    }




































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































}



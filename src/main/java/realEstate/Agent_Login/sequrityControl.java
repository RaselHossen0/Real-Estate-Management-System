package realEstate.Agent_Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class sequrityControl {

    @FXML
    private TextField sqrtMail;

    @FXML
    private PasswordField sqrtPass;

    @FXML
    private PasswordField  sqrtConPass;

    @FXML
    private TextField sqrtQsn;
    @FXML
    private Label answerMsg;
    @FXML
    private Label answerMsg2;



    public void continueButOnAction(ActionEvent event){
        // loginMsg.setText("Please enter username and password");

        if(sqrtMail.getText().isBlank()==false&&sqrtQsn.getText().isBlank()==false) {

            if(sqrtPass.getText().isBlank()==false&&sqrtConPass.getText().isBlank()==false){
                validatelogin();

            }
            else
                answerMsg2.setText("Password didn't match");
        }
        else
            answerMsg.setText("Please answer the questions correctly.");

    }
    Stage stage;
    Scene scene;
    public void validatelogin() {
        if (sqrtPass.getText().equals(sqrtConPass.getText())) {
            String filename = "forgetpass.txt";
            String email = sqrtMail.getText();
            String question = sqrtQsn.getText();
            boolean matchFound = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                int lineNumber = 1;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 2 && email.equals(data[0])) {
                        // Email match found, check security question
                        if (question.equals(data[1])) {
                            // Email and security question match found
                            matchFound = true;
                            break;
                        } else {
                            answerMsg.setText("Invalid security question.");
                            return; // Exit the method
                        }
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (matchFound) {
                // Close the current window
                Stage stage = (Stage) sqrtMail.getScene().getWindow();
                stage.close();

                // Open the profile.fxml file
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent root = fxmlLoader.load();
                    Stage profileStage = new Stage();
                    profileStage.setTitle("Profile");
                    profileStage.setScene(new Scene(root));
                    profileStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filename2 = "users.txt";
                //String email = sqrtMail.getText();
                StringBuilder fileContent2 = new StringBuilder();

                try (BufferedReader reader = new BufferedReader(new FileReader(filename2))) {
                    String line2;
                    while ((line2 = reader.readLine()) != null) {
                        String[] data2 = line2.split(",");
                        if (data2.length >= 2 && email.equals(data2[0])) {
                            // Email match found, skip this line
                            continue;
                        }
                        fileContent2.append(line2).append(System.lineSeparator());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try (FileWriter fileWriter = new FileWriter(filename2);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(fileContent2.toString());
                    bufferedWriter.write(sqrtMail.getText() + "," + sqrtPass.getText());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                            /*
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename2))) {
                                writer.write(fileContent2.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                             */


                // Replace the password with the new password
                ///line2 = email + "," + sqrtPass.getText();

























































































                ///fileContent2.append(line2);
                ///fileContent2.append(System.lineSeparator());

            } else {
                answerMsg.setText("Invalid email or security question.");
            }
        } else {
            answerMsg2.setText("Password didn't match");
        }
    }




































































































































































































































































































































}



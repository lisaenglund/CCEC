/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lisa
 */
public class SettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordAgain;

    @FXML
    private TextField employeeID;

    @FXML
    private Label employeeIDError;

    @FXML
    private Label passwordError;

    ObjectOutputStream output;
    ObjectInputStream input;

    Path pathClient = Paths.get("userOfEmployee.txt");

    Path pathAd = Paths.get("userOfManager.txt"); //userOfad.txt

    @FXML
    private void handleButtonLogInAction(ActionEvent event) throws IOException {
        /* labelAd.setText("");//clear administrator label
         if (textUserClient.getText().equalsIgnoreCase("") || textPassClient.getText().equalsIgnoreCase("")) {
         labelClient.setText("input username and password");
         } else {*/

        ArrayList<String> createTemp = new ArrayList<>();

        boolean userNameExist = false;//user name not exist

        createTemp.add(employeeID.getText());

        createTemp.add(password.getText());

        Accounts accounts = new Accounts();

        if (Files.exists(pathClient)) {//it may the username be used
            ArrayList<String> tempLoad = (ArrayList<String>) Files.readAllLines(pathClient);
            for (int i = 0; i < tempLoad.size(); i = i + 2) {
                if (createTemp.get(0).equalsIgnoreCase(tempLoad.get(i))) {
                    employeeID.setText("Account aldready exists");
                    password.clear();
                    userNameExist = true;
                    break;
                } else if (!userNameExist) {//create the user name and save
                    Files.write(pathClient, createTemp, StandardOpenOption.APPEND);
                    accounts.setEmployeeID(employeeID.getText()); //CHANGED
                    accounts.setPassword(password.getText());       //CHANGED
                    //goToScene(event, "FXMLDocument.fxml");
                }
            } /* else {//no usernames because no files
             Files.write(pathClient, createTemp, StandardOpenOption.CREATE);
             addToStorage(employeeID.getText());
             //goToScene(event, "FXMLDocument.fxml");
             } */

        }
    }

    private void addToStorage(String e, String p) {//save string to use it in other scenes
        DataStorage.getInstance().setEmployeeID(e);
        DataStorage.getInstance().setPassword(p);
    }

    private void goToScene(ActionEvent event, String name) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Scene1LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

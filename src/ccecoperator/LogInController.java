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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Lokes
 */
public class Scene1LogInController implements Initializable {

    @FXML
    private TextField usernameLogIn;

    @FXML
    private PasswordField passwordLogIn;

    @FXML
    private Label labelLogIn;

    ObjectOutputStream output;
    ObjectInputStream input;

    private String[] userAd = new String[3];

    private String[] passAd = new String[3];

    private ArrayList<String> userClient = new ArrayList<>();

    private ArrayList<String> passClient = new ArrayList<>();

    Path pathClient = Paths.get("userOfEmployee.txt");

    Path pathAd = Paths.get("userOfManager.txt"); //userOfad.txt

    ArrayList<String> managerAccounts = new ArrayList<>();

    ArrayList<String> userAccounts = new ArrayList<>();

    /*private void addDefaultAccount() {
        Path path = Paths.get("userOfManager.txt");

        String employeeID = "admin";

        String password = "admin";

        managerAccounts.add(employeeID + password);

        Files.write(pathAd, managerAccounts, StandardOpenOption.APPEND);
        addToStorage(0);

    } */

    private void addToStorage(String s) {//save string to use it in other scenes
        DataStorage.getInstance().setEmployeeID(s);
    }

    @FXML
    private void handleButtonLogInAction(ActionEvent event) {

        try {
            if (usernameLogIn.getText().equalsIgnoreCase("") || passwordLogIn.getText().equalsIgnoreCase("")) {
                labelLogIn.setText("Please enter username and password");//if 1 of two are fields empty
            } else {
                boolean userNameExistance = false;

                String[] loginTemp = new String[2];

                loginTemp[0] = usernameLogIn.getText();

                loginTemp[1] = passwordLogIn.getText();

                if (Files.exists(pathAd)) {
                    ArrayList<String> tempLoad = (ArrayList<String>) Files.readAllLines(pathAd);//load

                    for (int i = 0; i < tempLoad.size(); i = i + 2) {//going thrue usernames
                        if (loginTemp[0].equalsIgnoreCase(tempLoad.get(i)) && loginTemp[1].equalsIgnoreCase(tempLoad.get(i + 1))) {
                            //check usernam and pass matching

                            System.out.println("Username and password is correct!");

                            goToScene(event, "Scene2.fxml");

                            userNameExistance = true;

                        }
                    }
                    if (!userNameExistance) {
                        passwordLogIn.clear();

                        labelLogIn.setText("WRONG USERNAME OR PASSWORD");
                    }
                } else {//file not exist
                    labelLogIn.setText("WRONG USERNAME OR PASSWORD");
                }
            }
        } catch (Exception ex) {
            System.out.println("ERROR!");
        }
    }

    @FXML
    private void handleButtonExitAction(ActionEvent event) {
        System.out.println("You clicked EXIT!");
        System.exit(0);

    }

    /*  private void addToStorage(String s) {//save string to use it in other scenes
     DataStorage.getInstance().setClientName(s);
     }
     */
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

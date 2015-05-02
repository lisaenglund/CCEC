/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lokes
 */
public class Scene2Controller implements Initializable {

     @FXML 
    private void handleButtonStudentsAction(ActionEvent event) {

        try {
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Students.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked STUDENTS!");
        } catch (Exception ex) {
        }

        System.out.println("ERROR!");
    }

    @FXML
    private void handleButtonCountriesAction (ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
            try (Connection c = DriverManager.getConnection(URL)) {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM country");
                while(rs.next()){
                    int nbr = rs.getInt("visaCharge");
                    String name = rs.getString("countryName");
                    System.out.println("Country Name: " + name + " \n and our service charge in SEK  " + nbr + "\n\n");
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    
    }
    @FXML
    private void handleButtonLogOutAction(ActionEvent event) {

        try {
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1LogIn.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked LOG OUT!");
        } catch (Exception ex) {
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

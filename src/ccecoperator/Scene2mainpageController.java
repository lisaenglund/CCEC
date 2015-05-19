/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccecoperator;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static javax.management.remote.JMXConnectorFactory.connect;

/**
 * FXML Controller class
 *
 * @author Lokes
 */
public class Scene2mainpageController extends ControllerClass {

   
    @FXML
    private Label accessDenied;

    @FXML
    public void handleButtonSqlConnectionAction(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            String URL = "jdbc:mysql://127.0.0.1:3306/ccec?user=root&password=root";
            try (Connection c = DriverManager.getConnection(URL)) {
                System.out.println("SQL connection has been established");
                /*Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM country");
                 while(rs.next()){
                 int nbr = rs.getInt("visaCharge");
                 String name = rs.getString("countryName");
                 System.out.println("Country Name: " + name + " \n and our service charge in SEK  " + nbr + "\n\n");
                 } */

            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println("ERROR: " + e);
        }

    }

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

            System.out.println("ERROR!");
        }
    }

    @FXML
    private void handleButtonEmployeesAction(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Employees.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked EMPLOYEES!");
        } catch (Exception ex) {

            System.out.println("ERROR!");
        }
    }

    @FXML
    private void handleButtonUniversityAction(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("University.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked University!");
        } catch (Exception ex) {

            System.out.println("ERROR!");
        }
    }

    @FXML
    private void handleButtonCountryAction(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Country.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked Countries!");
        } catch (Exception ex) {

            System.out.println("ERROR!");
        }
    }

    @FXML
    private void handleButtonSettingsAction(ActionEvent event) throws IOException {
        Path path = Paths.get("userOfManager.txt");

        List<String> managers = Files.readAllLines(path);
        
        DataStorage.getInstance().getUserLoggedIn();
        
        if (!DataStorage.getInstance().getUserLoggedIn().equals(managers)) {

            accessDenied.setText("MANAGER ACCESS REQUIRED");
            System.out.println("You do not have access!");
        
        } else {

            try {

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                System.out.println("You clicked Settings!");
            } catch (Exception ex) {

                System.out.println("ERROR!");
            }
        }

    }

    @FXML
    private void handleButtonScholarshipAction(ActionEvent event) {

        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scholarship.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("You clicked Scholarships!");
        } catch (Exception ex) {

            System.out.println("ERROR!");
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
    /* @Override
     public void initialize(URL url, ResourceBundle rb) {
     // TODO
     }*/

}

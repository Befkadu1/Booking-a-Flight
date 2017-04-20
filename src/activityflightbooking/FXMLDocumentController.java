/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityflightbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Befkadu Degefa
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label labelAlert;

    @FXML
    public TextField nameText;

    @FXML
    public TextField addressText;

    @FXML
    public TextField telText;

    @FXML
    public static ArrayList<Passangers> passangersArrayList= new ArrayList();

    //I used arrays here because I could not initialize arrayList here
    //Other option is to initialize the ArrayList in the initialize method
    @FXML
    public String[] arraySource =
    {
        "Lund", "Malmö", "Stockholm", "Berlin", "Paris", "Barcelona"
    };

    Passangers passanger;
    //static to save the lists all the time
   
    public static ObservableList<String> sourceObservable;
    //static to save the lists all the time
    @FXML
    public static ObservableList<String> destinationObservable;

    
    public static String[] arrayDestination =
    {
        "Lund", "Malmö", "Stockholm", "Berlin", "Paris", "Barcelona"
    };

    @FXML
    public static ObservableList<String> passangerObservable = FXCollections.observableArrayList();

    @FXML
    private void nextButtonAction(ActionEvent event) throws IOException
    {
        //A message shown if the user clicks the next button without filling the boxes
        if (nameText.getText().isEmpty() || addressText.getText().isEmpty() || telText.getText().isEmpty())
        {
            labelAlert.setText("You must fill all the boxes");
        } else
        {
            //Creating objects of the class Passangers
            passanger = new Passangers(nameText.getText(), addressText.getText(), telText.getText());

            //adding objects to the arrayList
            passangersArrayList.add(passanger);

            //Adding passanger names to the ObservableList
            passangerObservable.add(passanger.getName());

            //For testing
            System.out.println(passangerObservable);

            //adding the source cities to the observable
            for (String sourceCities : arraySource)
            {
                sourceObservable.add(sourceCities); //sourceObservable.addAll(Arrays.asList(array));
            }

            for (String destinationCities : arraySource)
            {
                destinationObservable.add(destinationCities); //sourceObservable.addAll(Arrays.asList(array));
            }

            Parent root1 = FXMLLoader.load(getClass().getResource("Booking.fxml"));
            Scene scene = new Scene(root1);
            //brings the old Stage, Node? to get the source-> getScene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Flight");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        sourceObservable = FXCollections.observableArrayList();
        destinationObservable = FXCollections.observableArrayList();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityflightbooking;

import static activityflightbooking.FXMLDocumentController.passangerObservable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

/**
 * FXML Controller class
 *
 * @author Befkadu Degefa
 */
public class GoodbyeController implements Initializable
{

    @FXML
    private Label fromLabel;
    
    @FXML
    private Label toLabel;
    
    @FXML
    private Label nameLabel;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        nameLabel.setText(FXMLDocumentController.passangerObservable.get(0));
        fromLabel.setText(BookingController.sourceSelection);
        toLabel.setText(BookingController.destinationSelection);
    }    
    
    public void backToStart(ActionEvent event)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Booking.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();        
        stage.setScene(scene);
        
    }
    
}

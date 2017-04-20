/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityflightbooking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 *
 * @author Befkadu Degefa
 */
public class BookingController implements Initializable
{

    @FXML
    private Label alertSelection;
    
    @FXML
    public ListView sourceListView;
    
    @FXML
    private ListView destinationListView;
    
    public static String sourceSelection;
    public static String destinationSelection;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        sourceListView.setItems(FXMLDocumentController.sourceObservable);
        destinationListView.setItems(FXMLDocumentController.destinationObservable);
        
        
    }
    
    public void backToStart(ActionEvent event)throws IOException
    {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();        
        stage.setScene(scene);
        
    }
    
    public void book(ActionEvent event)throws IOException
    {
        sourceSelection = (String)sourceListView.getSelectionModel().getSelectedItem();
        destinationSelection = (String)destinationListView.getSelectionModel().getSelectedItem();
        if(sourceSelection == null || destinationSelection == null)
        {
            alertSelection.setText("Select source & destination");
        }
        else if(sourceSelection.equals(destinationSelection))
        {
            alertSelection.setText("Source & destination should be different");
        }
        else
        {
        Parent root = FXMLLoader.load(getClass().getResource("Goodbye.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();        
        stage.setScene(scene);
        }
        
    }
    
}

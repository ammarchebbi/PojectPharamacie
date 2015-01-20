/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author HAwK
 */
public class   LOGINController implements Initializable {
    
    @FXML private javafx.scene.control.Button closeButton;
    
    @FXML  private Label lblMessage;
    
    @FXML
    private TextField txtUsername;
    
    @FXML
    private TextField txtPassword;
    @FXML void quitter(ActionEvent event)throws IOException{
        
    }
    
    @FXML 
    private ProgressBar prog;
    
    private Timeline timeline;
    private static final Integer STARTTIME = 5;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME*100);

    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException{
        if(txtUsername.getText().equals("CHEF")&& txtPassword.getText().equals("CHEF")){
            
   
            prog.progressProperty().bind(
            timeSeconds.divide(STARTTIME*100.0).subtract(1).multiply(-1));
            
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/modilisationprojet/Administrateur.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("BIENVENUE A PHARMAC");
            stage.show();
            
        }else if(txtUsername.getText().equals("EMPLOYEE")&& txtPassword.getText().equals("EMPLOYEE")){ 

            prog.progressProperty().bind(
            timeSeconds.divide(STARTTIME*100.0).subtract(1).multiply(-1));
                timeSeconds.set((STARTTIME+1)*100);
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(STARTTIME+1),
                new KeyValue(timeSeconds, 0)));
                timeline.playFromStart();
                Parent parent = FXMLLoader.load(getClass().getResource("/modilisationprojet/EmployeesMenu.fxml"));

                timeline.setOnFinished(new EventHandler<ActionEvent>(){
 
                  @Override
            public void handle(ActionEvent arg0) {
                       ((Node) (event.getSource())).getScene().getWindow().hide();
                        Stage stage = new Stage();
                          Scene scene = new Scene(parent);
                          stage.setScene(scene);
                          stage.setResizable(false);
                              stage.setTitle("BIENVENUE A PHARMAC");
                                //scene.getStylesheets().add("employeemenu.css");

                stage.show();
                

            }
                     });
               
            
        }else{
            lblMessage.setText("UserName or Password incorrect ");
        }
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

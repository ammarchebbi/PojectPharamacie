/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class AJOUTERCLIENTController implements Initializable {

    @FXML private TextField nom;
    @FXML private TextField id;
    @FXML private TextField adress;
    @FXML private DatePicker date;
    @FXML private Label confirmation;


    
    
    
    public Connection con2 = Connexion.ConnexionBD();

    @FXML private void nvclient(ActionEvent event) throws IOException {
        try{
            ResultSet resultat = null;
            Statement instruction = con2.createStatement();
            String requet = "INSERT INTO preparateur(prepid,prepnom,prepadresse,prepnaiss)"
                        + " values("+id.getText()+",'"+nom.getText()+"','"+adress.getText()+"',to_date('"+date.getValue()+"','yyyy-mm-dd'))";
            resultat = instruction.executeQuery(requet);
            confirmation.setText("NOUVEAU CLIENT EST INSERER");
            
            }
                catch(SQLException e){
                e.printStackTrace();
            }
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;



import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author HAwK
 */
public class StockMenuController implements Initializable {

    @FXML private Button btnstock;
    @FXML private TableView table;
    @FXML private StackedBarChart chart;
     public Connection con2 = Connexion.ConnexionBD();
     XYChart.Series series1 = new XYChart.Series();


    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            ResultSet resultat2= null;

            
            Statement instruction = con2.createStatement();
            String requet2 = "SELECT NOMPRODUIT , CONTITE from PRODUIT  ORDER BY CONTITE";

            resultat2 = instruction.executeQuery(requet2);


            series1.setName("Nombre");
            while(resultat2.next()){
             series1.getData().add(new XYChart.Data(resultat2.getString("NOMPRODUIT"), resultat2.getInt("CONTITE")));
            }
          
            chart.getData().addAll(series1);
            

            }
                catch(SQLException e){
                e.printStackTrace();
            }
    }    
    
}

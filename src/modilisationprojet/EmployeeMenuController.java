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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HAwK
 */
public class EmployeeMenuController implements Initializable {
    
    
    
//dakchi diyal fichier fxml kaydeclara privé
    @FXML private Button btnclient;
    @FXML private Button btnstock;
    @FXML private TabPane tabPane;
    @FXML private Tab paneclient;
    @FXML private Pane pane;
    //partie de dclaration du table
    public Connection con2 = Connexion.ConnexionBD();
    
    @FXML private TableView<info> table;
    @FXML TableColumn<info , String> nom;
    @FXML TableColumn<info , String> daten;
    @FXML TableColumn <info , String>adress;
    ObservableList<info> data=FXCollections.observableArrayList( );
    @FXML private LineChart<String,Number> chart;
    @FXML private CategoryAxis jour;
    @FXML private NumberAxis nombre;
    XYChart.Series series1 = new XYChart.Series();
    



    @FXML private ListView<String> list1;
    @FXML private void fournibtn(ActionEvent event) throws IOException{
        Popup fourni =new Popup();
      
    }
    @FXML private void ajouterbtn(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AJOUTERCLIENT.fxml"));
            Stage stage = new Stage();
            Scene scene2 = new Scene(parent);
            stage.setScene(scene2);
            stage.setTitle("AJOUTER CLIENT");
            stage.show();
        

    }
    @FXML private void modifier(ActionEvent event) throws IOException {
        try{
            data.removeAll(data);
            ResultSet resultat = null;
            Statement instruction = con2.createStatement();
            String requet = "SELECT prepnom, prepadresse, prepnaiss from preparateur";
            
            resultat = instruction.executeQuery(requet);
            while(resultat.next()){
                info cm = new info();
                cm.nom.set(resultat.getString("prepnom"));
                cm.adress.set(resultat.getString("prepadresse"));
                cm.date.set(resultat.getString("prepnaiss"));
                data.add(cm);

            }
            table.setItems(data);
            
            //data.removeAll(data);
            //table.getColumns().get(0).setVisible(false);
            //table.getColumns().get(0).setVisible(true);

            }
                catch(SQLException e){
                e.printStackTrace();
            }
        

    }
    @FXML private void supprimer(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SUPPRIMERCLIENT.fxml"));
            Stage stage = new Stage();
            Scene scene4 = new Scene(parent);
            stage.setScene(scene4);
            stage.setTitle("SUPPRIMER CLIENT");
            stage.show();
        

    }
    @FXML private void facture(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Facture.fxml"));
            Stage stage = new Stage();
            Scene scene4 = new Scene(parent);
            stage.setScene(scene4);
            stage.setTitle("CLIENT FACTURE");
            stage.show();
        

    }

    @FXML private void clientbtn(ActionEvent event) {
        
        System.out.println("btnclient clicked");
    }
   
    
    
    private int count=0;
    private Tab stockTab = new Tab();
    private SingleSelectionModel<Tab> selectionModel;
    int x=1;
    
    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        nom.setCellValueFactory(new PropertyValueFactory<info, String>("nom"));
        daten.setCellValueFactory(new PropertyValueFactory<info, String>("date"));
        adress.setCellValueFactory(new PropertyValueFactory<info, String>("adress"));
        ObservableList<String> listdata= FXCollections.observableArrayList();
       
        
        
        
        


        
        try{
            ResultSet resultat = null;
            ResultSet resultat3=null;

            
            Statement instruction = con2.createStatement();
            String requet = "SELECT prepnom, prepadresse, prepnaiss from preparateur";
            String requet3 = "SELECT NOMPRODUIT  from PRODUIT order by CONTITE";

            resultat3 = instruction.executeQuery(requet3);

            while(resultat3.next()){
                listdata.add(resultat3.getString("NOMPRODUIT"));

            }
            list1.setItems(listdata);

            series1.setName("Nombre");
            
                     
            resultat = instruction.executeQuery(requet);
            while(resultat.next()){
                info cm = new info();
                cm.nom.set(resultat.getString("prepnom"));
                cm.adress.set(resultat.getString("prepadresse"));
                cm.date.set(resultat.getString("prepnaiss"));
                data.add(cm);

            }

            table.setItems(data);
            
            //data.removeAll(data);
            //table.getColumns().get(0).setVisible(false);
            //table.getColumns().get(0).setVisible(true);

            }
                catch(SQLException e){
                e.printStackTrace();
            }
        
        btnstock.setOnMouseClicked(addTab);
        selectionModel = tabPane.getSelectionModel();
        try{
            ResultSet resultat2= null;

            
            Statement instruction = con2.createStatement();
            String requet2 = "SELECT count(*) as nombre , datefacture from facture group by datefacture";

            resultat2 = instruction.executeQuery(requet2);


            series1.setName("Nombre");
            while(resultat2.next()){
             series1.getData().add(new XYChart.Data(resultat2.getString("datefacture"), resultat2.getInt("nombre")));
            }
          
            chart.getData().addAll(series1);

            }
                catch(SQLException e){
                e.printStackTrace();
            }
       
    }
    
    //3la 9bel la pane jdida d stock .. kanet7ekmo fiha hnaya 
    private EventHandler<MouseEvent> addTab = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            System.out.println("a new pan added");
            try {
                stockTab.setText("Stock");
                stockTab.setContent(FXMLLoader.load(getClass().getResource("/modilisationprojet/StockMenu.fxml")));
            } catch (IOException ex) {
                Logger.getLogger(EmployeeMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            stockTab.setClosable(true);
            stockTab.setId("stock");
            tabPane.getTabs().add(stockTab);
            selectionModel.selectLast();
        }
    };
    
    

}

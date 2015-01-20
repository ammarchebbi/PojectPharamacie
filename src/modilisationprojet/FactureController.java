/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HAwK
 */
public class FactureController implements Initializable {

    @FXML private TextField nomc;
    @FXML private ChoiceBox nomm;
    @FXML private TextField prix;
    
    @FXML private void facture(ActionEvent event) throws IOException, DocumentException {
        Document doc = new Document();
        PdfWriter.getInstance(doc,new FileOutputStream("FACTURE.pdf"));
        doc.open();
        doc.add(new Paragraph("FACTURE ICI"));
        doc.close();
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

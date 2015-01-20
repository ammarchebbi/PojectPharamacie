/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;

/**
 *
 * @author HAwK
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class info {
    public SimpleStringProperty id= new SimpleStringProperty();
    public SimpleStringProperty nom= new SimpleStringProperty();
    public SimpleStringProperty date= new SimpleStringProperty();
    public SimpleStringProperty adress= new SimpleStringProperty();

    
    public String getId() {
        return id.get();
    }

    public String getNom() {
        return nom.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getAdress() {
        return adress.get();
    }
    
    /* public SimpleStringProperty nomProperty() {
        return nom;
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public SimpleStringProperty adressProperty() {
        return adress;
    }*/
    
    
    
    

    
}
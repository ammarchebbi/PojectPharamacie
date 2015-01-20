/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author HAwK
 */
public class MEDICAM {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleIntegerProperty nbr;

    public MEDICAM(int id, String name, String type,int nbr) {
        this.id = new SimpleIntegerProperty(id);
        this.name =new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.nbr = new  SimpleIntegerProperty(nbr);
    }

    MEDICAM() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getType() {
        return type.get();
    }

    public Integer getNbr() {
        return nbr.get();
    }
    
    
    
    

    
}

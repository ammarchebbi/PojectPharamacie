/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modilisationprojet;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
* @author Ezzarouali
*/
public class Connexion {
public static Connection ConnexionBD(){
try{
Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
Connection connexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:pharmaciebd","scott","tiger");
System.out.println("Connexion reussit");
return connexion;
}catch(Exception e){
e.printStackTrace();
}
return null;
}
}
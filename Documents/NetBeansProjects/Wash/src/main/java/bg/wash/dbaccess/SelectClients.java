/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.wash.dbaccess;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *
 * @author the_one
 */
public class SelectClients {
    String query = "select CUSTOMERNAME from CUSTOMER";
     String choice [];

    public SelectClients() throws SQLException, FileNotFoundException {
        EstablishConnection.establishConnection(query);
    }
    
    
}

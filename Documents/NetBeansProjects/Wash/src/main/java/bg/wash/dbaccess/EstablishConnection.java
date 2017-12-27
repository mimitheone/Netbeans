/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.wash.dbaccess;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author the_one
 */
public class EstablishConnection {
    
    public static void establishConnection(String query) throws FileNotFoundException, SQLException{
         System.out.println("-------- Oracle JDBC Connection Testing ------");
                        
                        try {
                            
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            
                        } catch (ClassNotFoundException e) {
                            
                            System.out.println("Where is your Oracle JDBC Driver?");
                            
                            System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home")+"/error.log")));

                            return;
                            
                        }
                        
                        System.out.println("Oracle JDBC Driver Registered!");
                        
                        Connection connection = null;
                        
                        try {
                            
                            connection = DriverManager.getConnection(
                                    "jdbc:oracle:thin:@localhost:1521:XE", "the1",
                                    "milena");
                            
                        } catch (SQLException e) {
                            
                            System.out.println("Connection Failed! Check output console");
                            
                            System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home")+"/error.log")));

                            return;
                            
                        }
                        
                        if (connection != null) {
                            Statement statement = connection.createStatement();
                            statement.executeUpdate(query);
                            
                            
                        } else {
                            System.out.println("Failed to make connection!");
                        }
                        
                        connection.commit();
                        connection.close();
                    } 
}

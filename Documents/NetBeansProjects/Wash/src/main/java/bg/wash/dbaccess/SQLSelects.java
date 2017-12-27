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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author the_one
 */
public class SQLSelects {
    static public ObservableList<String> selectClients() throws SQLException, FileNotFoundException {
                         ObservableList<String> customer = FXCollections.observableArrayList();
                        System.out.println("-------- Oracle JDBC Connection Testing ------");
                        
                        try {
                            
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            
                        } catch (ClassNotFoundException e) {
                            
                            System.out.println("Where is your Oracle JDBC Driver?");
                                                   
                            
                        }
                        
                        System.out.println("Oracle JDBC Driver Registered!");
                        
                        Connection connection = null;
                        
                        try {
                            
                            connection = DriverManager.getConnection(
                                    "jdbc:oracle:thin:@localhost:1521:XE", "wash",
                                    "milena");
                            
                        } catch (SQLException e) {
                            
                            System.out.println("Connection Failed! Check output console");
                            
                            System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home")+"/error.log")));

                           // return 1;
                            
                        }
                        
                        if (connection != null) {
                           Statement stmt = connection.createStatement();
                           //String selectTableSQL = query;
 
		
 
			System.out.println("SELECT CUSTOMERNAME FROM CUSTOMER;");
 
			java.sql.ResultSet rs = stmt.executeQuery("SELECT CUSTOMERNAME FROM CUSTOMER");
 
                        int i=0;
                        
                       
			while (rs.next()) {
 
				customer.add( rs.getString("CUSTOMERNAME"));
				
                                
				System.out.println(customer);
				
                                
			}
                
            
                        } else {
                            System.out.println("Failed to make connection!");
                        }
                        connection.commit();
                        connection.close();
                        return customer;
                    }
    
    static public String selectLastOrder() throws SQLException, FileNotFoundException {
                         int orderID = 0;
                        System.out.println("-------- Oracle JDBC Connection Testing ------");
                        
                        try {
                            
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            
                        } catch (ClassNotFoundException e) {
                            
                            System.out.println("Where is your Oracle JDBC Driver?");
                                                   
                            
                        }
                        
                        System.out.println("Oracle JDBC Driver Registered!");
                        
                        Connection connection = null;
                        
                        try {
                            
                            connection = DriverManager.getConnection(
                                    "jdbc:oracle:thin:@localhost:1521:XE", "wash",
                                    "milena");
                            
                        } catch (SQLException e) {
                            
                            System.out.println("Connection Failed! Check output console");
                            
                            System.setErr(new PrintStream(new FileOutputStream(System.getProperty("user.home")+"/error.log")));

                           // return 1;
                            
                        }
                        
                        if (connection != null) {
                           Statement stmt = connection.createStatement();
                           //String selectTableSQL = query;
 
		
 
			System.out.println("SELECT max(ORDERID)+1 FROM ORDERW;");
 
			java.sql.ResultSet rs = stmt.executeQuery("SELECT count(ORDERID)+1 FROM ORDERW");
 
                       
                        
                       
			while (rs.next()) {
 
				orderID = rs.getInt(1);
				
                                
				System.out.println(orderID);
				
                                
			}
                
            
                        } else {
                            System.out.println("Failed to make connection!");
                        }
                        connection.commit();
                        connection.close();
                        return String.valueOf(orderID);
                    }
}

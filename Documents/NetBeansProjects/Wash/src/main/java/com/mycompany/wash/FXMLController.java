package com.mycompany.wash;

import bg.wash.dbaccess.SQLInserts;
import bg.wash.dbaccess.SQLSelects;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    
    
    @FXML private TextField clientName;
    @FXML private TextField MOL;
    @FXML private TextField clientAddress;
    @FXML private TextField clientPhone;
    @FXML private ComboBox <String> clientGetList;
    @FXML private ComboBox <String> clientGetListChoser;
    @FXML private TableColumn item;
    @FXML private TableColumn amount;
    @FXML private TableColumn weight;
    @FXML private TableColumn totalWeight;
    @FXML private TextField orderNumber;
    @FXML private DatePicker datePicker;
            
    
    private void saveClient() throws FileNotFoundException, SQLException{
                 
        System.out.println((String)clientName.getText());
        System.out.println((String)MOL.getText());
        System.out.println((String)clientAddress.getText());
        System.out.println((String)clientPhone.getText());
        String query = "INSERT INTO CUSTOMER VALUES(13,'" + clientName.getText()+ "','" + clientAddress.getText() + "')";
        SQLInserts.establishConnection(query);
        
        clientName.setText("");
        MOL.setText("");
        clientAddress.setText("");
        clientPhone.setText("");
       
    }
    
    @FXML
    private void createPDF(ActionEvent event){
        
    }
    
    @FXML
    private void exitApp(ActionEvent event){
         System.exit(1);
    }
    
    @FXML
    private void reload(ActionEvent event){
         
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLController.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            
            stage.setTitle("Wash");
            TabPane tabPane = new TabPane();
            stage.getIcons().add(new Image("file:C:washing_powder.png"));
            stage.setScene(scene);
            stage.show();
            
            
            stage.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void saveOrder(ActionEvent event) {
        try {
            String orderToInsert ="Insert into ORDERW set values ((select)) ";
            SQLInserts.insertOrder(orderToInsert);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void orderNumber(){
        try {
           orderNumber.setText(SQLSelects.selectLastOrder()); 
           orderNumber.setDisable(true);
           
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }
    
   
    private void loadClients()throws SQLException{
       
       try {
           clientGetList.setItems(SQLSelects.selectClients());
           clientGetListChoser.setItems(SQLSelects.selectClients());
       } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
                   
        orderNumber();
        
        datePicker.setValue(NOW_LOCAL_DATE());
        try {
            loadClients();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_kasir;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DaftarController implements Initializable {

       @FXML
    private Button MknBtn;

    @FXML
    private Button brgBtn;

    @FXML
    void Makanan(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_DeleteMakanan.fxml"));
        Parent root = loader.load();
        
      
        Stage stage = (Stage) MknBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Pembelian");
    }

    @FXML
    void barang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Add_DeleteBarang.fxml"));
        Parent root = loader.load();
        
      
        Stage stage = (Stage) brgBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Pembelian");

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_kasir;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdbc.BarangModel;


public class Add_DeleteBarangController implements Initializable {

    @FXML
    private Button AddBtn;

    @FXML
    private TextField BarcodeFld;

    @FXML
    private Button CancelBtn;

    @FXML
    private Button DeleteBtn;

    @FXML
    private TextField DiskonFld;

    @FXML
    private TextField ExpiredFld;

    @FXML
    private TextField HargaFld;

    @FXML
    private TextField JumlahFld;

    @FXML
    private TextField NamaFld;
    
     @FXML
    private TextField KategoriFld;
    
     @FXML
    private Text TXTT;
     
     String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Makanan mkn = null;
    private boolean update;
    int studentId;
    

    @FXML
    void ADD(ActionEvent event) {
        BarangModel brg= new BarangModel();
        double harga = Double.parseDouble(HargaFld.getText());
        int jumlah=Integer.parseInt(JumlahFld.getText());
        double diskon=Double.parseDouble(DiskonFld.getText());
        
    
        Barang brg1= new Barang(NamaFld.getText(),harga, jumlah,diskon,BarcodeFld.getText(),ExpiredFld.getText(),KategoriFld.getText());
        
        brg.tambahBarang(brg1);
        
        TXTT.setText("Data Berhasil Dimasukkan");
        
    NamaFld.clear();
    HargaFld.clear();
    JumlahFld.clear();
    DiskonFld.clear();
    BarcodeFld.clear();
    ExpiredFld.clear();
    KategoriFld.clear();
    }

    @FXML
    void Cancel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Daftar.fxml"));
        Parent root = loader.load();
        
      
        Stage stage = (Stage) CancelBtn.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Pembelian");
    }

    @FXML
    void DELETE(ActionEvent event) {
        BarangModel brg= new BarangModel();
        double harga = Double.parseDouble(HargaFld.getText());
        int jumlah=Integer.parseInt(JumlahFld.getText());
        double diskon=Double.parseDouble(DiskonFld.getText());
        
    
        Barang brg1= new Barang(NamaFld.getText(),harga, jumlah,diskon,BarcodeFld.getText(),ExpiredFld.getText(),KategoriFld.getText());
        
        brg.deleteBarang(brg1);
        
        TXTT.setText("Data Berhasil Dihapus");
        
    NamaFld.clear();
    HargaFld.clear();
    JumlahFld.clear();
    DiskonFld.clear();
    BarcodeFld.clear();
    ExpiredFld.clear();
    KategoriFld.clear();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    }





     
    


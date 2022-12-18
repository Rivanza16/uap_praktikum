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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdbc.makananModel;


public class Add_DeleteMakananController implements Initializable {

    @FXML
    private Button AddBtn;

    @FXML
    private Button CancelBtn;

    @FXML
    private TextField Daya_tahan;

    @FXML
    private Button DeleteBtn;

    @FXML
    private TextField Diskon;

    @FXML
    private TextField Harga;

    @FXML
    private TextField Id;

    @FXML
    private TextField Nama;

    @FXML
    private TextField Jumlah;
    
    @FXML
    private Text TXTTT;

    @FXML
    void Add(ActionEvent event) {
        makananModel mkn= new makananModel();
        double harga = Double.parseDouble(Harga.getText());
        int jumlah=Integer.parseInt(Jumlah.getText());
        double diskon=Double.parseDouble(Diskon.getText());
        int id=Integer.parseInt(Id.getText());
        int daya_tahan=Integer.parseInt(Daya_tahan.getText());
    
        Makanan mkn1= new Makanan(Nama.getText(),harga, jumlah,diskon,id,daya_tahan);
        
        mkn.addmakanan(mkn1);
        
        TXTTT.setText("Data Berhasil Dimasukkan");
        
    Nama.clear();
    Harga.clear();
    Jumlah.clear();
    Diskon.clear();
    Id.clear();
    Daya_tahan.clear();
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
    void Delete(ActionEvent event) {
         makananModel mkn= new makananModel();
        double harga = Double.parseDouble(Harga.getText());
        int jumlah=Integer.parseInt(Jumlah.getText());
        double diskon=Double.parseDouble(Diskon.getText());
        int id=Integer.parseInt(Id.getText());
        int daya_tahan=Integer.parseInt(Daya_tahan.getText());
    
        Makanan mkn1= new Makanan(Nama.getText(),harga, jumlah,diskon,id,daya_tahan);
        
        mkn.deletemakanan(mkn1);
        
        TXTTT.setText("Data Berhasil Dihapus");
        
    Nama.clear();
    Harga.clear();
    Jumlah.clear();
    Diskon.clear();
    Id.clear();
    Daya_tahan.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
    
}

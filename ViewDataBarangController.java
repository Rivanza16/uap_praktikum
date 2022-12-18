package uap_kasir;

import db.DBHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewDataBarangController implements Initializable {
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Barang barang = null;
    
    @FXML
    private TableColumn<Barang, String> barKolom;

    @FXML
    private Button btnMuat;

    @FXML
    private Button btnTambah;

    @FXML
    private TableColumn<Barang, Double> diskonKolom;

    @FXML
    private TableColumn<Barang, String> expKolom;

    @FXML
    private TableColumn<Barang, Double> hargakolom;

    @FXML
    private TableColumn<Barang, Integer> jumlahKolom;

    @FXML
    private TableColumn<Barang, String> kategoriKolom;

    @FXML
    private TableColumn<Barang, String> namaKolom;

    @FXML
    private TableView<Barang> tabelBarang;
    
    
    ObservableList<Barang> BarangList = FXCollections.observableArrayList();
    public void initialize (URL url, ResourceBundle rb){
        loadDate();
    }
    
    @FXML
    void sendData(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Add_DeleteBarang.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewDataBarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshTable(){
         try {
            BarangList.clear();
            
            query = "SELECT * FROM `barang`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                BarangList.add(new  Barang(
                        resultSet.getString("nama"),
                        resultSet.getDouble("harga"),
                        resultSet.getInt("jumlah"),
                        resultSet.getDouble("diskon"),
                        resultSet.getString("barcode"),
                        resultSet.getString("expired"),
                        resultSet.getString("kategori")));
                tabelBarang.setItems(BarangList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewDataBarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
    
    private void loadDate() {
        
        connection = DBHelper.getConnection();
        refreshTable();
        
        namaKolom.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        hargakolom.setCellValueFactory(new PropertyValueFactory<>("harga"));
        jumlahKolom.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        diskonKolom.setCellValueFactory(new PropertyValueFactory<>("diskon"));
        barKolom.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        expKolom.setCellValueFactory(new PropertyValueFactory<>("expired"));
        kategoriKolom.setCellValueFactory(new PropertyValueFactory<>("kategori"));
    }
    
    @FXML
    void sendMuat(ActionEvent event) {
        refreshTable();
    }

}

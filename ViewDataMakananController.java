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

public class ViewDataMakananController implements Initializable {
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Makanan makanan = null;
    
    @FXML
    private Button btnMuat;

    @FXML
    private Button btnTambah;

    @FXML
    private TableColumn<Makanan, String> dayaKolom;

    @FXML
    private TableColumn<Makanan, Double> diskonKolom;

    @FXML
    private TableColumn<Makanan, Double> hargaKolom;

    @FXML
    private TableColumn<Makanan, Integer> idKolom;

    @FXML
    private TableColumn<Makanan, Integer> jumlahKolom;

    @FXML
    private TableColumn<Makanan, String> namakolom;
    
    @FXML
    private TableView<Makanan> tabelMakanan;

    ObservableList<Makanan> MakananList = FXCollections.observableArrayList();
    public void initialize (URL url, ResourceBundle rb){
        
     loadDate();
    }

    @FXML
    void sendMuat(ActionEvent event) {
        refreshTable();
    }
     private void refreshTable(){
         try {
            MakananList.clear();
            
            query = "SELECT * FROM `makanan`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                MakananList.add(new  Makanan(
                        resultSet.getString("nama_produk"),
                        resultSet.getDouble("harga"),
                        resultSet.getInt("jumlah"),
                        resultSet.getDouble("diskon"),
                        resultSet.getInt("id"),
                        resultSet.getInt("daya_tahan")));
                tabelMakanan.setItems(MakananList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewDataMakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void tambahMkn(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Add_DeleteMakanan.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Tambah Data");
            
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewDataMakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDate() {
        
        connection = DBHelper.getConnection();
        refreshTable();
        
        namakolom.setCellValueFactory(new PropertyValueFactory<>("nama_produk"));
        jumlahKolom.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        idKolom.setCellValueFactory(new PropertyValueFactory<>("id"));
        hargaKolom.setCellValueFactory(new PropertyValueFactory<>("harga"));
        diskonKolom.setCellValueFactory(new PropertyValueFactory<>("diskon"));
        dayaKolom.setCellValueFactory(new PropertyValueFactory<>("daya_tahan"));
         
         
    }
    }



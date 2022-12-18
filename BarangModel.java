
package jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import db.DBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uap_kasir.Barang;


public class BarangModel {
    private final Connection CONN;

    public BarangModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void tambahBarang(Barang brg){ 
        String insert = "INSERT INTO barang VALUES ('" + brg.getNama_produk() + "', '" + brg.getHarga() + "', '"+ brg.getJumlah()+ "', '" + brg.getDiskon() + "', '" + brg.getBarcode() + "', '"  + brg.getExpired() + "','" + brg.getKategori()+ "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan data");
        }
    }
    
    public void updateBarang(Barang brg){
        String update = "UPDATE barang SET Nama_produk = '" + brg.getNama_produk() + "' WHERE  = id" + brg.getBarcode();
        try {
            CONN.createStatement().executeUpdate(update);
            System.out.println("Berhasil Melakukan Update Data");
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Melakukan Update Data");
        }
    }

    
    public void deleteBarang(Barang brg){
        String hapus = "DELETE FROM barang WHERE nama = '" + brg.getNama_produk()+ "'";
        try {
            CONN.createStatement().executeUpdate(hapus);
            System.out.println("Berhasil Menghapus Data");
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    
    public ArrayList<Barang> getBarang(){
        String query = "SELECT * FROM barang";
        ArrayList<Barang> brg = new ArrayList<>();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Barang temp = new Barang(rs.getString("Nama_produk"), rs.getDouble("harga"), rs.getInt("Jumlah"),rs.getDouble("Diskon"),rs.getString("Barcode"),rs.getString("Expired"),rs.getString("kategori"));
                brg.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(BarangModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return brg;
    }
}
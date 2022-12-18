
package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import db.DBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uap_kasir.Penjualan;
import uap_kasir.Produk;


public class PenjualanModel {
    private final Connection CONN;

    public PenjualanModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addPenjualan(Penjualan pjl){
        String insert = "INSERT INTO pjl VALUES ( '" + pjl.getJumlahProduk() + "', '"+ pjl.getHarga()+ "','"+ pjl.getStok()+ "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan data");
        }
    }
    
    public void updatePenjualan(Penjualan pjl){
        String update = "UPDATE pjl SET JumlahProduk = '" + pjl.getJumlahProduk() + "' WHERE  = Stok" + pjl.getStok();
        try {
            CONN.createStatement().executeUpdate(update);
            System.out.println("Berhasil Melakukan Update Data");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Melakukan Update Data");
        }
    }
    
    public void hapusPenjualan(Penjualan pjl){
        String hapus = "DELETE FROM pjl WHERE stok  = '" + pjl.getJumlahProduk()+ "'";
        try {
            CONN.createStatement().executeUpdate(hapus);
            System.out.println("Berhasil Menghapus Data");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    
    public ArrayList<Penjualan> getPenjualan(){
        String query = "SELECT * FROM pjl";
        ArrayList<Penjualan> pjl = new ArrayList<>();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
               //Penjualan temp = new Penjualan(rs.getInt("jumlahProduk"), rs.getInt("Harga"),rs.getInt("stok"));
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return pjl;
    }
}


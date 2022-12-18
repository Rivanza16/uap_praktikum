
package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import db.DBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uap_kasir.Makanan;


public class makananModel {
    private final Connection CONN;

    public makananModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addmakanan(Makanan mkn){
        String insert = "INSERT INTO makanan VALUES ('" + mkn.getNama_produk() + "', '" + mkn.getHarga() + "', '"+ mkn.getJumlah()+ "', '" + mkn.getDiskon() + "', '" + mkn.getId() + "', '"  + mkn.getDaya_tahan() + "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(makananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan data");
        }
    }
    
    public void updatemakanan(Makanan mkn){
        String update = "UPDATE makanan SET Nama_produk = '" + mkn.getNama_produk() + "' WHERE  = harga" + mkn.getHarga();
        try {
            CONN.createStatement().executeUpdate(update);
            System.out.println("Berhasil Melakukan Update Data");
        } catch (SQLException ex) {
            Logger.getLogger(makananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Melakukan Update Data");
        }
    }
    
    public void deletemakanan(Makanan mkn){
        String hapus = "DELETE FROM makanan WHERE Nama_produk = '" + mkn.getNama_produk()+ "'";
        try {
            CONN.createStatement().executeUpdate(hapus);
            System.out.println("Berhasil Menghapus Data");
        } catch (SQLException ex) {
            Logger.getLogger(makananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    
    public ArrayList<Makanan> getmakanan(){
        String query = "SELECT * FROM makanan";
        ArrayList<Makanan> mkn = new ArrayList<>();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Makanan temp = new Makanan(rs.getString("Nama_produk"), rs.getDouble("harga"), rs.getInt("Jumlah"),rs.getDouble("Diskon"),rs.getInt("Id"),rs.getInt("Daya_Tahan"));
                mkn.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(makananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return mkn;
    }
}


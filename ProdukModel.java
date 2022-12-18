/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import db.DBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uap_kasir.Produk;


public class ProdukModel {
    private final Connection CONN;

    public ProdukModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addProduk(Produk mkn){
        String insert = "INSERT INTO pdk VALUES ('" + mkn.getNama_produk() + "', '" + mkn.getHarga() + "', '"+ mkn.getJumlah()+ "','" + mkn.getDiskon() + "');";
        try {
            if(CONN.createStatement().executeUpdate(insert) > 0){
                System.out.println("Berhasil Memasukkan Data");
            }else{
                System.out.println("Gagal Memasukkan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan data");
        }
    }
    
    public void updateProduk(Produk mkn){
        String update = "UPDATE pdk SET Nama_produk = '" + mkn.getNama_produk() + "' WHERE  = harga" + mkn.getHarga();
        try {
            CONN.createStatement().executeUpdate(update);
            System.out.println("Berhasil Melakukan Update Data");
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Melakukan Update Data");
        }
    }
    
    public void hapusProduk(Produk mkn){
        String hapus = "DELETE FROM pdk WHERE Nama_produk = '" + mkn.getNama_produk()+ "'";
        try {
            CONN.createStatement().executeUpdate(hapus);
            System.out.println("Berhasil Menghapus Data");
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data");
        }
    }
    
    public ArrayList<Produk> getProduk(){
        String query = "SELECT * FROM pdk";
        ArrayList<Produk> mkn = new ArrayList<>();
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Produk temp = new Produk(rs.getString("Nama_produk"), rs.getDouble("harga"), rs.getInt("Jumlah"),rs.getDouble("Diskon"));
                mkn.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(ProdukModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        return mkn;
    }
}


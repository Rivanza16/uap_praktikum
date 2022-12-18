/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_kasir;

import java.util.ArrayList;

public class Penjualan implements ProductCounter{
    private ArrayList<Produk> listProduk;
    private int jumlahProduk;
    private int stok;
    private int harga;

    public Penjualan( int jumlahProduk,int harga, int stok) {
        this.listProduk = new ArrayList<>();
        this.jumlahProduk = jumlahProduk;
        this.stok = stok;
        this.harga=harga;
    }

    @Override
    public double hitungJumlahProduk() {
        return listProduk.size();
    }

    @Override
    public double hitungHargaTotal() {
        double harga_total = .0;
        for (Produk produk : listProduk) {
            harga_total += produk.hargaDiskon();
        }
        return 0;
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    
}



package uap_kasir;


import java.util.ArrayList;

public class Barang extends Produk{
    private String barcode;
    private String expired;
    private String kategori;
    private ArrayList<Kategori> produk;

    public Barang(String nama_produk, double harga, int jumlah, double diskon, String barcode, String expired, String kategori) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.produk = produk;
        this.kategori = kategori;
    }
   
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    
    public String getKategori(){
        return kategori;
    }
    
    public void addKategori(Kategori kategori){
        produk.add(kategori);
    }
    public void isExpired(){
        System.out.println("Expired Barang = "+ this.expired);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getProduk() {
        return produk;
    }

    public void setProduk(ArrayList<Kategori> produk) {
        this.produk = produk;
    }
}


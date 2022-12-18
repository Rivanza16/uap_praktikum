package uap_kasir;

public class Kategori {
    private  String nama_kategori;

    public String getProduk(){
        return this.nama_kategori;
    }
    
    public  void setNama_Kategori(String nama_kategori){
        this.nama_kategori=nama_kategori;
    }
    
    public String getNama_kategori(){
        return nama_kategori;
    }
}


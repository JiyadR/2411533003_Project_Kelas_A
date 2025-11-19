package model;

public class Customer {
    private String id;
    private  String nama;
    private String email;
    private String alamat;
    private String nomorHp;
    
    public Customer(String id, String nama, String email, String alamat, String nomorHp) {
    	this.id = id;
    	this.nama = nama;
    	this.email = email;
    	this.alamat = alamat;
    	this.nomorHp = nomorHp;
    }

    // Getter & Setter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getAlamat() {
        return alamat;
    }
  
    public String getHp() {
        return nomorHp;
    }
   
}
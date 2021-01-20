/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

/**
 *
 * @author Admin
 */
public class karyawan {
    int id;
    String namakaryawan, jabatan, alamat, email, notlp, jeniskelamin;

    public void setId(int id) {
        this.id = id;
    }

    public void setNamakaryawan(String namakaryawan) {
        this.namakaryawan = namakaryawan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotlp(String notlp) {
        this.notlp = notlp;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public int getId() {
        return id;
    }

    public String getNamakaryawan() {
        return namakaryawan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getEmail() {
        return email;
    }

    public String getNotlp() {
        return notlp;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public karyawan(int id, String namakaryawan, String jabatan, String alamat, String email, String notlp, String jeniskelamin) {
        this.id = id;
        this.namakaryawan = namakaryawan;
        this.jabatan = jabatan;
        this.alamat = alamat;
        this.email = email;
        this.notlp = notlp;
        this.jeniskelamin = jeniskelamin;
    }
}



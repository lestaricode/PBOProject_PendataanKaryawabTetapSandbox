/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;



/**
 *
 * @author Admin
 */
public class koneksi {

  


    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_pbo","root","");
           JOptionPane.showMessageDialog(null, "koneksi sukses");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    public static ObservableList<karyawan> getDatakaryawan(){
        Connection conn = ConnectDb();
        ObservableList<karyawan> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from tbl_datkaryawan");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new karyawan(Integer.parseInt(rs.getString("id")), rs.getString("namakaryawan"), rs.getString("jabatan"),rs.getString("alamat"), rs.getString("email"),rs.getString("notlp"), rs.getString("jeniskelamin")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}


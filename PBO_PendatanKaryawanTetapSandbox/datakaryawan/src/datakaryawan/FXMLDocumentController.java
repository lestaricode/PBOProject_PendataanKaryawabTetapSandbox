/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Admin
 */
public class FXMLDocumentController implements Initializable {

    
        @FXML
    private TableView<karyawan> Datakaryawan;
        
     @FXML
    private TableColumn<karyawan, Integer> kol_id;

    @FXML
    private TableColumn<karyawan, String> kol_nama;

    @FXML
    private TableColumn<karyawan, String> kol_jabatan;

    @FXML
    private TableColumn<karyawan, String> kol_alamat;

    @FXML
    private TableColumn<karyawan, String> kol_email;

    @FXML
    private TableColumn<karyawan, String> kol_tlp;

    @FXML
    private TableColumn<karyawan, String> kol_jenisk;
    
    
   ObservableList<karyawan> listM;
   ObservableList<karyawan> dataList;
   
   int index = -1;
   
   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        kol_id.setCellValueFactory(new PropertyValueFactory<karyawan,Integer>("id"));
        kol_nama.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("namakaryawan"));
        kol_jabatan.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("jabatan"));
        kol_alamat.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("alamat"));
        kol_email.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("email"));
        kol_tlp.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("tlp"));
        kol_jenisk.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("jenisk"));
        
        
        listM = koneksi.getDatakaryawan();
        Datakaryawan.setItems(listM);
    }    
    
}

ObservableList<karyawan> listM;
   ObservableList<karyawan> dataList;
   
   int index = -1;
   
   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
    
    @FXML
   public void Add_karyawan() {
       conn = koneksi.ConnectDb();
       String sql = "insert into tbl_datkaryawan (id,namakaryawan,jabatan,alamat,email,notlp,jeniskelamin) values (?,?,?,?,?,?,?)";
       try{
           pst = conn.prepareStatement(sql);
           
           pst.setString(1, txt_id.getText());
           pst.setString(2, txt_nama.getText());
           pst.setString(3, txt_jabatan.getText());
           pst.setString(4, txt_alamat.getText());
           pst.setString(5, txt_email.getText());
           pst.setString(6, txt_tlp.getText());
            pst.setString(7, txt_jenisk.getText());
           pst.execute();
              JOptionPane.showMessageDialog(null,"Karyawan Berhasil ditambahkan");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           
       }
   }
    @FXML
         public void Edit (){   
        try {
            conn = koneksi.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_nama.getText();
            String value3 = txt_jabatan.getText();
            String value4 = txt_alamat.getText();
            String value5 = txt_email.getText();
            String value6 = txt_tlp.getText();
            String value7 = txt_jenisk.getText();
            
            String sql = "update tbl_datkaryawan set id= '"+value1+"',namakaryawan= '"+value2+"',jabatan= '"+
                    value3+"',alamat= '"+value4+"',email= '"+value5+"',notlp = '"+value6+"',jeniskelamin ='"+ value7+"' where id='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    @FXML
    public void Delete(){
    conn = koneksi.ConnectDb();
    String sql = "delete from tbl_datkaryawan where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }

    
    public void UpdateTable(){
      kol_id.setCellValueFactory(new PropertyValueFactory<karyawan,Integer>("id"));
        kol_nama.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("namakaryawan"));
        kol_jabatan.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("jabatan"));
        kol_alamat.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("alamat"));
        kol_email.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("email"));
        kol_tlp.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("notlp"));
        kol_jenisk.setCellValueFactory(new PropertyValueFactory<karyawan, String> ("jeniskelamin"));
        
        
        listM = koneksi.getDatakaryawan();
        Datakaryawan.setItems(listM);
      
    }
    
    


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    UpdateTable();
   
    // Code Source in description
    } 

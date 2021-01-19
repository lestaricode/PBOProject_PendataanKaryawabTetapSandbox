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

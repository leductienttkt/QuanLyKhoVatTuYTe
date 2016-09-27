/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import bin.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nara
 */
public class TruyVanDB {

    Connection conn;
    PreparedStatement ps;
    
    public TruyVanDB() {
        LibraryDbConnect lbDB = new LibraryDbConnect();
        conn = lbDB.getConnectMySQL();
    }
    
    
    
    public void themNhanVien(NhanVien nv)
    {
        
        try {
            String sql = "INSERT INTO TABLE_TEN VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nv.getIdNhanVien());
            ps.setString(2,nv.getTenNhanVien());
            ps.setDate(3, nv.getNgaySinh());
            ps.setString(4,nv.getDiaChi());
            ps.setString(5,nv.getSdt());
            ps.setInt(6, nv.getLuong());
            ps.setString(7,nv.getChucVu());
            ps.setString(8,nv.getGioiTinh());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "ok");
        } catch (SQLException ex) {
            Logger.getLogger(TruyVanDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

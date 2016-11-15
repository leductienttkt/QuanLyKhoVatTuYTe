/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import bean.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
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
            String sql = "INSERT INTO nhanvien VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nv.getIdNhanVien());
            ps.setString(2,nv.getTenNhanVien());
            ps.setString(3, nv.getNgaySinh());
            ps.setString(4,nv.getDiaChi());
            ps.setString(5,nv.getSdt());
            ps.setInt(6, nv.getLuong());
            ps.setString(7,nv.getChucVu());
            ps.setString(8,nv.getGioiTinh());

            ps.setString(9,nv.getHoatDong());
            ps.execute();

            
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "ok");
        } catch (SQLException ex) {
            Logger.getLogger(TruyVanDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ResultSet view(String table, String [] cols){
        ResultSet resultSet = null;
        try {
            Statement statement = (Statement) conn.createStatement();
            /*String sql = "SELECT ";
            if(cols == null || cols.length == 0){
                sql += "* FROM";
            }else{
                for(int i = 0 ; i < cols.length; i++){
                    sql += "`" + cols[i] + "`, ";
                }
                sql += ";";
                sql = sql.replace("`, ;", "` FROM");
            }
            sql += " " + table +"WHERE hoatdong = '1'";*/
            String sql = "SELECT * FROM nhanvien WHERE hoatdong = '1'";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
     
      public boolean update(String table, String[] cols, Vector value, String[] colsWhere, Vector valueWhere){
        try {
            if(table == null || cols == null || colsWhere == null || colsWhere.length != cols.length) 
                return false;
             
            Statement statement = (Statement) conn.createStatement();
            String sql = "update " + table + " set ";
            for(int i = 0 ; i < cols.length; i++){
                sql += "`" + cols[i] + "` = '" + value.elementAt(i) + "', ";
            }
            sql += ";";
            sql = sql.replace("', ;", "' WHERE ");
             
            for(int i = 0 ; i < colsWhere.length; i++){
                sql += "`" + colsWhere[i] + "` = '" + valueWhere.elementAt(i) + "' and ";
            }
            sql += ";";
            sql = sql.replace("' and ;", "'");
            //JOptionPane.showMessageDialog(null,  sql);
            statement.executeUpdate(sql);
 
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
      
       public boolean delete(String table,  String id){
        
            Statement statement;
        try {

             //String sql = "DELETE FROM " + table + " WHERE 'idnhanvien' = '"+ id+"'";
             String sql = "UPDATE nhanvien SET hoatdong = '0' WHERE idnhanvien = '" + id+"'";

             //String sql = "DELETE FROM " + table + " WHERE 'nhanvien.idnhanvien' = '"+ id+"'";
//             String sql = "DELETE FROM nhanvien WHERE idnhanvien = 1";
             

            statement = (Statement) conn.createStatement();
            System.out.println(sql);
            
            JOptionPane.showMessageDialog(null,  sql);
            statement.executeUpdate(sql);
                  
             return true;
        } catch (SQLException ex) {
            Logger.getLogger(TruyVanDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        return false;
    }
}

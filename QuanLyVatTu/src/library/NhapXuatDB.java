/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import bean.NhapHang;
import bin.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nara
 */
public class NhapXuatDB {

    Connection conn;
    ResultSet resultSet = null;
    PreparedStatement ps;
    Statement st;
    
    public NhapXuatDB() {
        LibraryDbConnect lbDB = new LibraryDbConnect();
        conn = lbDB.getConnectMySQL();
    }
    
    public void nhapHang(NhapHang nhap)
    {
        String sql1 = "SELECT * FROM hanghoa WHERE idhanghoa = '"+ nhap.getHangHoa().getIdHangHoa()+"'";
        System.out.print( sql1);
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql1);
            rs = st.executeQuery(sql1);
            
            try {
            if (!rs.next())
            {
            System.out.print( "chưa có hàng");
            String sql2 = "INSERT INTO hanghoa VALUES (?,?,?)";
            ps = conn.prepareStatement(sql2);
            ps.setString(1,nhap.getHangHoa().getIdHangHoa());
            ps.setString(2,nhap.getHangHoa().getTenHangHoa());
            ps.setString(3, nhap.getHangHoa().getDonVi());
            ps.executeUpdate();
            
            String sql = "INSERT INTO chitietnhap VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,nhap.getIdNhap());
            ps.setString(2,nhap.getHangHoa().getIdHangHoa());
            ps.setString(3, nhap.getNgayNhap());
            ps.setInt(4,nhap.getSoLuong());
            ps.setString(5,nhap.getNgaySX());
            ps.setString(6, nhap.getHanSuDung());
            ps.setInt(7,nhap.getGia());
            ps.setString(8,"nv002");
            ps.setString(9,nhap.getViTri());
            ps.setString(10,nhap.getNhaCungCap());
            
            ps.execute();
            }
            else{
                
            System.out.print( "có hàng");
            String sql = "INSERT INTO chitietnhap VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,nhap.getIdNhap());
            ps.setString(2,nhap.getHangHoa().getIdHangHoa());
            ps.setString(3, nhap.getNgayNhap());
            ps.setInt(4,nhap.getSoLuong());
            ps.setString(5,nhap.getNgaySX());
            ps.setString(6, nhap.getHanSuDung());
            ps.setInt(7,nhap.getGia());
            ps.setString(8,"nv002");
            ps.setString(9,nhap.getViTri());
            ps.setString(10,nhap.getNhaCungCap());
            
            ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "ok");
            
        } catch (SQLException ex) {
            Logger.getLogger(TruyVanDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (SQLException ex) {
            Logger.getLogger(NhapXuatDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public ResultSet baoCaoNhap(String tu, String den){
       
        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM chitietnhap,hanghoa,nhanvien WHERE ngaynhap>='"+tu+"' AND ngaynhap<='" +den+"' AND hanghoa.idhanghoa = chitietnhap.idhanghoa AND nhanvien.idnhanvien=chitietnhap.idnhanvien" ;
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    } 
     
    public ResultSet comboboxData(){
       
        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT idhanghoa,tenhang,donvi FROM hanghoa";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    } 
}

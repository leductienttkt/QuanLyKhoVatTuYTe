/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import bean.NhapHang;
import bean.XuatHang;
import bean.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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
    Properties prop = LibraryPropertiesFile.readFileConfig("login.properties");
    String idnv = prop.getProperty("idnv");

    public NhapXuatDB() {
        LibraryDbConnect lbDB = new LibraryDbConnect();
        conn = lbDB.getConnectMySQL();
    }

    public void nhapHang(NhapHang[] nhaps, int n) {
        for (int i = 0; i < n; i++) {
            NhapHang nhap = nhaps[i];
            String sql1 = "SELECT * FROM hanghoa WHERE idhanghoa = '" + nhap.getHangHoa().getIdHangHoa() + "'";
            System.out.print(sql1);
            ResultSet rs = null;
            try {
                st = conn.prepareStatement(sql1);
                rs = st.executeQuery(sql1);

                try {
                    if (!rs.next()) {
                        System.out.print("chưa có hàng");
                        String sql2 = "INSERT INTO hanghoa VALUES (?,?,?)";
                        ps = conn.prepareStatement(sql2);
                        ps.setString(1, nhap.getHangHoa().getIdHangHoa());
                        ps.setString(2, nhap.getHangHoa().getTenHangHoa());
                        ps.setString(3, nhap.getHangHoa().getDonVi());
                        ps.executeUpdate();

                        String sql = "INSERT INTO chitietnhap VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nhap.getIdNhap());
                        ps.setString(2, nhap.getHangHoa().getIdHangHoa());
                        ps.setString(3, nhap.getNgayNhap());
                        ps.setInt(4, nhap.getSoLuong());
                        ps.setString(5, nhap.getNgaySX());
                        ps.setString(6, nhap.getHanSuDung());
                        ps.setInt(7, nhap.getGia());
                        ps.setString(8, idnv);
                        ps.setString(9, nhap.getViTri());
                        ps.setString(10, nhap.getNhaCungCap());
                        ps.setInt(11, nhap.getSoLuong());
                        ps.execute();
                    } else {

                        System.out.print("có hàng");
                        String sql = "INSERT INTO chitietnhap VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nhap.getIdNhap());
                       
                        ps.setString(2, nhap.getHangHoa().getIdHangHoa());
                        ps.setString(3, nhap.getNgayNhap());
                        ps.setInt(4, nhap.getSoLuong());
                        ps.setString(5, nhap.getNgaySX());
                        ps.setString(6, nhap.getHanSuDung());
                        ps.setInt(7, nhap.getGia());
                        ps.setString(8, idnv);
                        ps.setString(9, nhap.getViTri());
                        ps.setString(10, nhap.getNhaCungCap());
                        ps.setInt(11, nhap.getSoLuong());
                        System.out.print(ps.toString());
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
    }

    public ResultSet baoCaoNhap(String tu, String den) {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM chitietnhap,hanghoa,nhanvien WHERE ngaynhap>='" + tu + "' AND ngaynhap<='" + den + "' AND hanghoa.idhanghoa = chitietnhap.idhanghoa AND nhanvien.idnhanvien=chitietnhap.idnhanvien";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet baoCaoNhapNV(String tu, String den, String nv) {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql;
            if (nv != "") {
                sql = "SELECT * FROM chitietnhap,hanghoa,nhanvien WHERE ngaynhap>='" + tu + "' AND ngaynhap<='" + den + "' AND hanghoa.idhanghoa = chitietnhap.idhanghoa AND chitietnhap.idnhanvien='" + nv + "' AND nhanvien.idnhanvien=chitietnhap.idnhanvien";
                System.out.println(sql);
            } else {
                sql = "SELECT * FROM chitietnhap,hanghoa,nhanvien WHERE ngaynhap>='" + tu + "' AND ngaynhap<='" + den + "' AND hanghoa.idhanghoa = chitietnhap.idhanghoa AND nhanvien.idnhanvien=chitietnhap.idnhanvien";
                System.out.println(sql);
            }

            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet baoCaoXuatNV(String tu, String den, String nv) {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql;
            if (nv != "") {
                sql = "SELECT * FROM chitietxuat,hanghoa,nhanvien,chitietnhap WHERE ngayxuat>='" + tu + "' AND ngayxuat<='" + den + "' AND hanghoa.idhanghoa = chitietxuat.idhanghoa AND chitietxuat.idnhanvien='" + nv + "' AND nhanvien.idnhanvien=chitietxuat.idnhanvien AND chitietxuat.idnhap = chitietnhap.idnhap AND chitietxuat.idhanghoa = chitietnhap.idhanghoa ";
                System.out.println(sql);
            } else {
                sql = "SELECT * FROM chitietxuat,hanghoa,nhanvien,chitietnhap WHERE ngayxuat>='" + tu + "' AND ngayxuat<='" + den + "' AND hanghoa.idhanghoa = chitietxuat.idhanghoa AND nhanvien.idnhanvien=chitietxuat.idnhanvien AND chitietxuat.idnhap = chitietnhap.idnhap AND chitietxuat.idhanghoa = chitietnhap.idhanghoa ";
                System.out.println(sql);
            }

            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet comboboxData() {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT idhanghoa,tenhang,donvi FROM hanghoa";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet comboboxDataNV() {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT idnhanvien, tennhanvien FROM nhanvien";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet dsHangHoa(String idHang, String tenHang) {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM chitietnhap,hanghoa WHERE (chitietnhap.idhanghoa = '" + idHang + "' OR hanghoa.tenhang ='" + tenHang + "') AND chitietnhap.idhanghoa = hanghoa.idhanghoa AND chitietnhap.hienco >0";

            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public void xuatHang(XuatHang[] xuat, int n) {
        try {
            for (int i = 0; i < n; i++) {
                String sql = "INSERT INTO chitietxuat VALUES (?,?,?,?,?,?)";

                ps = conn.prepareStatement(sql);
                ps.setString(1, xuat[i].getIdXuat());
                ps.setString(2, xuat[i].getIdHangHoa());
                ps.setString(3, xuat[i].getNgayXuat());
                ps.setInt(4, xuat[i].getSoLuong());
                ps.setString(5, xuat[i].getIdNhanVien());
                ps.setString(6, xuat[i].getIdNhap());
                ps.executeUpdate();

                sql = "UPDATE chitietnhap SET hienco = hienco -" + String.valueOf(xuat[i].getSoLuong()) + " WHERE idnhap='" + xuat[i].getIdNhap() + "'AND idhanghoa ='" + xuat[i].getIdHangHoa() + "'";
                System.out.print(sql);
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();
            }
            JOptionPane.showConfirmDialog(null, "ĐÃ XUẤT ahjhj", "Thông báo", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
            Logger.getLogger(NhapXuatDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet tonKho() {

        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM chitietnhap,hanghoa WHERE chitietnhap.idhanghoa = hanghoa.idhanghoa AND chitietnhap.hienco >0";

            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public ResultSet timTonKho(String s) {
        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM chitietnhap,hanghoa WHERE chitietnhap.idhanghoa = hanghoa.idhanghoa AND chitietnhap.hienco >0 AND (hanghoa.tenhang LIKE '%"+s+"%' OR chitietnhap.vitri LIKE '%"+s+"%')";
            System.out.print(sql);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import library.TruyVanDB;

/**
 *
 * @author Administrator
 */
public class pnQuanLyNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form Quanlyvattu
     */
    public pnQuanLyNhanVien() {
        initComponents();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btCatThem = new javax.swing.JButton();
        btCatSua = new javax.swing.JButton();
        btCatXoa = new javax.swing.JButton();
        btCatNhapLai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Quản Lý Nhân Viên", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255)))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Kiểu dữ liệu cần tìm");
        jPanel1.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chủ đề tìm kiếm", "Chủ đề 1", "Chủ đề 2", " " }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(140, 28));
        jPanel1.add(jComboBox1);

        jLabel2.setText("Nhập dữ liệu cần tìm");
        jPanel1.add(jLabel2);

        jTextField1.setPreferredSize(new java.awt.Dimension(150, 28));
        jPanel1.add(jTextField1);

        jButton2.setText("Tìm");
        jButton2.setPreferredSize(new java.awt.Dimension(49, 28));
        jPanel1.add(jButton2);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        btCatThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCatThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-icon.gif"))); // NOI18N
        btCatThem.setText("Thêm");
        btCatThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCatThemActionPerformed(evt);
            }
        });
        jPanel4.add(btCatThem);

        btCatSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCatSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btCatSua.setText("Sửa");
        jPanel4.add(btCatSua);

        btCatXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCatXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del.gif"))); // NOI18N
        btCatXoa.setText("Xóa");
        jPanel4.add(btCatXoa);

        btCatNhapLai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCatNhapLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_cancel.png"))); // NOI18N
        btCatNhapLai.setText("Thoát");
        jPanel4.add(btCatNhapLai);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Lương", "Ca làm việc", "Ngày sinh", "Giới tính", "Địa chỉ", "Phone"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btCatThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCatThemActionPerformed
        new FrThemNhanVien().setVisible(true);
    }//GEN-LAST:event_btCatThemActionPerformed


     // Tải dữ liệu lên JTable
    public void loadData() {
        TruyVanDB db = new TruyVanDB();
        ResultSet result;
        result = db.view("NhanVien", null);
        String[] colsName = {   "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Lương", "Ngày sinh", "Giới tính", "Địa chỉ", "Phone" };
        tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
 
        try {
            while (result.next()) { // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[2];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
                // mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
 
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCatNhapLai;
    private javax.swing.JButton btCatSua;
    private javax.swing.JButton btCatThem;
    private javax.swing.JButton btCatXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nara
 */
public class LoginDB {
    
    Connection conn;
    PreparedStatement ps;
    
    public LoginDB() {
        LibraryDbConnect lbDB = new LibraryDbConnect();
        conn = lbDB.getConnectMySQL();
    }
    
    public ResultSet checkLogin(String user, String pass){
        ResultSet resultSet = null;
        try {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM taikhoan WHERE tentaikhoan = '"+user+ "' AND matkhau='"+pass+"'";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }
}

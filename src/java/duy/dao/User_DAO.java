/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dao;

import duy.db_utils.MyConnection;
import duy.dto.User_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author くろくん
 */
public class User_DAO {

    public User_DTO checkLogin(String userName, String password) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User_DTO user = null;
        cn = MyConnection.MakeConnection();
        String sql = "Select userID, password, fullname, role from Users where userID = ? and password = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("fullname");
                    String role = rs.getString("role");
                    user = new User_DTO(userName, "", fullName, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return user;
    }

    public boolean checkDupplicateusers(String userName) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.MakeConnection();
            if (cn != null) {
                String sql = "select userID from Users where userID = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public void insertUser(User_DTO user) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "insert into Users(userID, password, fullname, role) values(?, ?, ?, ?) ";
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, user.getUsername());
                pst.setString(2, user.getPassword());
                pst.setString(3, user.getFullname());
                pst.setString(4, user.getRole());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }
}

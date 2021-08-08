/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dao;

import duy.db_utils.MyConnection;
import duy.dto.Order_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author くろくん
 */
public class Order_DAO {

    public boolean addOrder(Order_DTO odto) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean add = false;
        try {
            cn = MyConnection.MakeConnection();
            if (cn != null) {
                String sql = "insert into Orders values(?, ?, ?, ?, ?, ?, ?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, odto.getOrderID());
                pst.setString(2, odto.getUserID());
                pst.setString(3, odto.getFullName());
                pst.setString(4, odto.getDate());
                pst.setString(5, odto.getShipAddress());
                pst.setString(6, odto.getPayment());
                pst.setDouble(7, odto.getTotalPrice());
                pst.setString(8, odto.getPhoneNumber());
                add = pst.executeUpdate() > 0;
            }
        } catch (Exception e) {
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
        return add;
    }

    public int getOrderId() throws SQLException {
        ArrayList<String> oList = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.MakeConnection();
            if (cn != null) {
                String sql = "select orderID from Orders";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    oList.add(rs.getString(1));
                }
                int id = oList.size();
                return id;
            }
        } catch (Exception e) {
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
        return 0;
    }
}

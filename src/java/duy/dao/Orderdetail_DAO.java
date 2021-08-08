/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dao;

import duy.db_utils.MyConnection;
import duy.dto.Orderdetail_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author くろくん
 */
public class Orderdetail_DAO {

    public int getOrderId() throws SQLException {
        ArrayList<String> oList = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.MakeConnection();
            if (cn != null) {
                String sql = "select orderdetailtID from Orderdetails";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    oList.add(rs.getString(1));
                }
                int id = Integer.parseInt(oList.get(oList.size()-1).trim());
                return id;
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
        return 0;
    }

    public boolean addOrderDetail(Orderdetail_DTO odtDTO) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean add = false;
        try {
            cn = MyConnection.MakeConnection();
            if (cn != null) {
                String sql = "insert into Orderdetails values(?, ?, ?, ?, ?) ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, odtDTO.getDetailID());
                pst.setString(2, odtDTO.getOrderID());
                pst.setString(3, odtDTO.getProID());
                pst.setInt(4, odtDTO.getQuantity());
                pst.setDouble(5, odtDTO.getPrice());
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
}

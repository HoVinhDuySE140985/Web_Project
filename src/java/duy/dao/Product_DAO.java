/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dao;

import duy.db_utils.MyConnection;
import duy.dto.Product_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author くろくん
 */
public class Product_DAO {

    public List<Product_DTO> getListProduct(String searchvalues) throws SQLException {
        List<Product_DTO> listPro = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "Select productID, productname, prices, quantity from Products where productname like ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + searchvalues + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                if (listPro == null) {
                    listPro = new ArrayList<>();
                }
                String productID = rs.getString("productID");
                String productName = rs.getString("productname");
                int prices = rs.getInt("prices");
                int quantity = rs.getInt("quantity");
                listPro.add(new Product_DTO(productID, productName, quantity, prices));
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
        return listPro;
    }

    public boolean updateProduct(Product_DTO dto) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "Update Products set ProductName = ? ,Quantity = ?, Prices = ? where ProductID = ?  ";
            pst = cn.prepareStatement(sql);
            pst.setString(1, dto.getProName());
            pst.setInt(2, dto.getQuantity());
            pst.setInt(3, dto.getPrice());
            pst.setString(4, dto.getProID());
            check = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }
    public boolean updateProductQuantity(String proID, int quantity) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "Update Products set Quantity = ? where ProductID = ?  ";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setString(2, proID);
            check = pst.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    public boolean deleteProduct(String proID) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "Delete from Products where productID = ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, proID);
            check = pst.executeUpdate() > 0 ? true : false;
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
        return check;
    }

    public boolean checkdupplicate(String proID) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = MyConnection.MakeConnection();
            if (cn != null) {
                String sql = "Select productID from Products where ProductID = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, proID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    check = true;
                }
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
        return check;
    }

    public void insertproduct(Product_DTO dto) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "insert into Products (ProductID , ProductName, Prices, Quantity) values(?, ?, ?, ?)";
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, dto.getProID());
                pst.setString(2, dto.getProName());
                pst.setInt(3, dto.getPrice());
                pst.setInt(4, dto.getQuantity());
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


    public Product_DTO getproID(String proID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Product_DTO dto = null;
        try {
            cn = MyConnection.MakeConnection();
            String sql = "Select productID, productname, prices, quantity from Products where productID = ?";
            pst = cn.prepareStatement(sql);
            pst.setString(1, proID);
            rs = pst.executeQuery();
            if (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productname");
                int prices = rs.getInt("prices");
                int quantity = rs.getInt("quantity");
                dto = new Product_DTO(productID, productName, quantity, prices);
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
        return dto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dto;

/**
 *
 * @author くろくん
 */
public class Orderdetail_DTO {
    private String detailID;
    private String orderID;
    private String proID;
    private double price;
    private int quantity;

    public Orderdetail_DTO() {
    }

    public Orderdetail_DTO(String detailID, String orderID, String proID, double price, int quantity) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.proID = proID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}

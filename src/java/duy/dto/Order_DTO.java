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
public class Order_DTO {

    private String orderID;
    private String userID;
    private String fullName;
    private String date;
    private String shipAddress;
    private String payment;
    private double totalPrice;
    private String phoneNumber;

    public Order_DTO() {
    }

    public Order_DTO(String orderID, String userID, String fullName, String date, String shipAddress, String payment, double totalPrice, String phoneNumber) {
        this.orderID = orderID;
        this.userID = userID;
        this.fullName = fullName;
        this.date = date;
        this.shipAddress = shipAddress;
        this.payment = payment;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}

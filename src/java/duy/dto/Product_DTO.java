/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dto;

import java.io.Serializable;

/**
 *
 * @author くろくん
 */
public class Product_DTO implements Serializable{

    private String proID;
    private String proName;
    private int quantity;
    private int price;

    public Product_DTO() {
    }

    public Product_DTO(String proID, String ProName, int quantity, int price) {
        this.proID = proID;
        this.proName = ProName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String ProName) {
        this.proName = ProName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

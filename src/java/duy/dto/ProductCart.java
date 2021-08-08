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
public class ProductCart implements Serializable{
    public Product_DTO prodto;
    public int quantity =1;

    public ProductCart() {
    }

    public ProductCart(Product_DTO prodto) {
        this.prodto = prodto;
    }

    public Product_DTO getProdto() {
        return prodto;
    }

    public void setProdto(Product_DTO prodto) {
        this.prodto = prodto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}

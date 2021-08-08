/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dto;

import java.util.HashMap;

/**
 *
 * @author くろくん
 */
public class Cart_DTO {

    private HashMap<String, Product_DTO> cart;

    public Cart_DTO() {
    }

    public Cart_DTO(HashMap<String, Product_DTO> cart) {
        this.cart = cart;
    }

    public HashMap<String, Product_DTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, Product_DTO> cart) {
        this.cart = cart;
    }
    
    
}

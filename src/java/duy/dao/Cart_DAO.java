/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duy.dao;

import duy.dto.ProductCart;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author くろくん
 */
public class Cart_DAO extends HashMap implements Serializable{

    public Cart_DAO() {
    }

    public void addToCart(ProductCart pro) { // lay key
        String key = pro.getProdto().getProID();
        // neu id ton tai thi lay ve so luong va cong them 1
        if (this.containsKey(key)) {
            int oldQuantity = ((ProductCart) this.get(key)).getQuantity();
            ((ProductCart) this.get(key)).setQuantity(oldQuantity + 1);

        } else {//neu id == null dua vao giuo hang bang put
            this.put(key, pro);
        }
    }

    public void removeCart(String key) {
        int oldQuantity = ((ProductCart) this.get(key)).getQuantity();
        if (oldQuantity > 1) {
            ((ProductCart) this.get(key)).setQuantity(oldQuantity - 1);
        } else {
            this.remove(key);
        }

    }

}

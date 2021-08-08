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
public class ProductError_dto {
    private String productID_ERROR;
    private String productName_ERROR;
    private String Prices_ERROR;
    private String Quantity_ERROR;

    public ProductError_dto() {
    }

    public ProductError_dto(String productID_ERROR, String productName_ERROR, String Prices_ERROR, String Quantity_ERROR) {
        this.productID_ERROR = productID_ERROR;
        this.productName_ERROR = productName_ERROR;
        this.Prices_ERROR = Prices_ERROR;
        this.Quantity_ERROR = Quantity_ERROR;
    }

    public String getProductID_ERROR() {
        return productID_ERROR;
    }

    public void setProductID_ERROR(String productID_ERROR) {
        this.productID_ERROR = productID_ERROR;
    }

    public String getProductName_ERROR() {
        return productName_ERROR;
    }

    public void setProductName_ERROR(String productName_ERROR) {
        this.productName_ERROR = productName_ERROR;
    }

    public String getPrices_ERROR() {
        return Prices_ERROR;
    }

    public void setPrices_ERROR(String Prices_ERROR) {
        this.Prices_ERROR = Prices_ERROR;
    }

    public String getQuantity_ERROR() {
        return Quantity_ERROR;
    }

    public void setQuantity_ERROR(String Quantity_ERROR) {
        this.Quantity_ERROR = Quantity_ERROR;
    }
      
}

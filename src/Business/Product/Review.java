/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class Review {
    private int starForProduct;
    private int starForSupplier;
    private String describe;

    public int getStarForProduct() {
        return starForProduct;
    }

    public void setStarForProduct(int starForProduct) {
        this.starForProduct = starForProduct;
    }

    public int getStarForSupplier() {
        return starForSupplier;
    }

    public void setStarForSupplier(int starForSupplier) {
        this.starForSupplier = starForSupplier;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return String.valueOf(starForProduct);
    }

   
    
    
    
}

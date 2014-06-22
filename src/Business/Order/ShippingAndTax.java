/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Shipment.*;
import Business.Organization.*;
import Business.Employee.EmployeeDirectory;
import Business.Order.ShippingAndTaxDirectory.SType;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public  class ShippingAndTax {
    private float shippingMoney;
    private float taxMoney;
    private String state;

    public ShippingAndTax(String s) {
        this.state=s;
    }



    public float getShippingMoney() {
        return shippingMoney;
    }

    public void setShippingMoney(float shippingMoney) {
        this.shippingMoney = shippingMoney;
    }

    public float getTaxMoney() {
        return taxMoney;
    }

    public void setTaxMoney(float taxMoney) {
        this.taxMoney = taxMoney;
    }


   

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
 
    @Override
    public String toString() {
        return state;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Shipment.*;
import Business.Organization.*;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class ShippingAndTaxDirectory {

    private ArrayList<ShippingAndTax> shippingAndTaxs = new ArrayList<ShippingAndTax>();

    public enum SType {

        Massachusetts("Massachusetts"), Newyork("Newyork"), Califonia("Ship Organization");
        private String value;

        private SType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public ShippingAndTax addShippingAndTax(SType sType) {
        ShippingAndTax shippingAndTax = new ShippingAndTax(sType.value);
        return shippingAndTax;
    }

    public ShippingAndTax addShippingAndTax(SType sType, float s, float t) {
        ShippingAndTax shippingAndTax = new ShippingAndTax(sType.value);
        shippingAndTax.setShippingMoney(s);
        System.out.println(String.valueOf(shippingAndTax.getShippingMoney()));
        shippingAndTax.setTaxMoney(t);
        shippingAndTaxs.add(shippingAndTax);
        return shippingAndTax;
    }

    public ShippingAndTax findShippingAndTax(String s) {
        ShippingAndTax shippingAndTax = null;
        for (ShippingAndTax st : shippingAndTaxs) {
            if (st.getState().equals(s)) {
                System.out.println(st.getState());
                System.out.println(s);
                shippingAndTax = st;
            }
        }
        return shippingAndTax;
    }

    public ArrayList<ShippingAndTax> getShippingAndTaxs() {
        return shippingAndTaxs;
    }

    public void setShippingAndTaxs(ArrayList<ShippingAndTax> shippingAndTaxs) {
        this.shippingAndTaxs = shippingAndTaxs;
    }
}

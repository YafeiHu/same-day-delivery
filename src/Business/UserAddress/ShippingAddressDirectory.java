/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAddress;

import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class ShippingAddressDirectory {
     ArrayList<ShippingAddress> ShippingAddresslist=new ArrayList<>();

    public ArrayList<ShippingAddress> getShippingAddresslist() {
        return ShippingAddresslist;
    }

    public void setShippingAddresslist(ArrayList<ShippingAddress> ShippingAddresslist) {
        this.ShippingAddresslist = ShippingAddresslist;
    }
    public ShippingAddress createShippingAddress(){
        ShippingAddress shippingAddress=new ShippingAddress();
        ShippingAddresslist.add(shippingAddress);
        return shippingAddress;
    }
    public ShippingAddress createShippingAddress(ShippingAddress address){
        ShippingAddresslist.add(address);
        return address;
    }
      public ShippingAddress createShippingAddress(String name, String firstname, String lastname, String Address1, String Address2, String city, String state, String zipcode, String Email) {
        ShippingAddress shippingAddress=createShippingAddress();
        shippingAddress.setAddress1(Address1);
        shippingAddress.setAddress2(Address2);
        shippingAddress.setCity(city);
        shippingAddress.setEmail(Email);
        shippingAddress.setFirstname(firstname);
        shippingAddress.setLastname(lastname);
        shippingAddress.setName(name);
        shippingAddress.setState(state);
        shippingAddress.setZipcode(zipcode);
        return shippingAddress;
    }
}

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
public class BillAddressDirectory {

    ArrayList<BillAddress> BillAddresslist = new ArrayList<>();

    public ArrayList<BillAddress> getBillAddresslist() {
        return BillAddresslist;
    }

    public void setBillAddresslist(ArrayList<BillAddress> BillAddresslist) {
        this.BillAddresslist = BillAddresslist;
    }

    public BillAddress createBillAddress() {
        BillAddress billAddress = new BillAddress();
        BillAddresslist.add(billAddress);
        return billAddress;
    }

    public BillAddress createBillAddress(String name, String firstname, String lastname, String Address1, String Address2, String city, String state, String zipcode, String Email) {
        BillAddress billAddress=createBillAddress();
        billAddress.setAddress1(Address1);
        billAddress.setAddress2(Address2);
        billAddress.setCity(city);
        billAddress.setEmail(Email);
        billAddress.setFirstname(firstname);
        billAddress.setLastname(lastname);
        billAddress.setName(name);
        billAddress.setState(state);
        billAddress.setZipcode(zipcode);
        return billAddress;
    }
}

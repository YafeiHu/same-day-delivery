/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Shipment;

import Business.UserAccount.UserAccount;
import Business.UserAddress.BillAddress;
import Business.UserAddress.ShippingAddress;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class Shipment {
    
    private ShippingAddress shippingAddress;
    private String status;
    private Date shipDate;
    private UserAccount shipper;
    private Date receiveDate;
    
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  

    public UserAccount getShipper() {
        return shipper;
    }

    public void setShipper(UserAccount shipper) {
        this.shipper = shipper;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

   
   
}

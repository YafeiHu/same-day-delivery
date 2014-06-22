/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Packaging;

import Business.Shipment.*;
import Business.UserAccount.UserAccount;
import Business.UserAddress.BillAddress;
import Business.UserAddress.ShippingAddress;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class Packaging {

    private String status;
    private Date packageDate;
    private UserAccount warehouser;
    private Date receiveDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPackageDate() {
        return packageDate;
    }

    public void setPackageDate(Date packageDate) {
        this.packageDate = packageDate;
    }

    public UserAccount getWarehouser() {
        return warehouser;
    }

    public void setWarehouser(UserAccount warehouser) {
        this.warehouser = warehouser;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }
}

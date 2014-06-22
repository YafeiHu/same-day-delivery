/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Supplier;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class ComplainRequest extends WorkRequest {
    private int ID = 0;
    private String reason;
    private String describe;
    private Supplier supplier;

    public ComplainRequest() {
        ID++;
    }

    
  
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    @Override
    public String toString() {
        return supplier.toString();
    }
    
}

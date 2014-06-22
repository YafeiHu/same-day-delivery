/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class RepairRequest extends WorkRequest {
    private int ID = 0;
    private String reason;
    private String describe;
    private OrderItem orderItem;
    private Order order;

    public RepairRequest() {
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

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    @Override
    public String toString() {
        return orderItem.toString();
    }
    
}

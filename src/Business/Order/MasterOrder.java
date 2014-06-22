/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class MasterOrder {

    private ArrayList<Order> orders = new ArrayList<Order>();

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Order add(Order order) {
        orders.add(order);
        return order;

    }

    public Order find(int i) {
        Order order = null;
        for (Order o : orders) {
            if (o.getOrderNum() == i) {
                order = o;
            }
        }
        return order;
    }
}

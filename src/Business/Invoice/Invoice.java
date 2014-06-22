/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Invoice;

import Business.Order.Order;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class Invoice {

    private Order order;
    private int invoiceNum;
    private Date invoiceDate;
    private float paid;
    private float unpaid;
    private int payNum=0;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    public float getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(float unpaid) {
        this.unpaid = unpaid;
    }

    public int getPayNum() {
        return payNum;
    }

    public void setPayNum(int payNum) {
        this.payNum = payNum;
    }

    public boolean finish() {
        if (unpaid == 0) {
            return true;
        } else {
            return false;
        }
    }
     public float Pay() {
         ++payNum;
         return payNum;
     }
}

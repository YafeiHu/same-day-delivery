/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Payment;

import Business.FinanceAccount.FinanceAccount;
import Business.Order.Order;
import Business.UserAddress.BillAddress;
import java.util.Date;

/**
 *
 * @author hyf
 */
public class Payment {
    private int ID;
    private float Total;
    private FinanceAccount sendFinanceAccount; 
    private FinanceAccount receiveFinanceAccount; 
    private BillAddress billAddress;
    private Date date;
    private int length;

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }


    public BillAddress getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(BillAddress billAddress) {
        this.billAddress = billAddress;
    }

    public FinanceAccount getSendFinanceAccount() {
        return sendFinanceAccount;
    }

    public void setSendFinanceAccount(FinanceAccount sendFinanceAccount) {
        this.sendFinanceAccount = sendFinanceAccount;
    }

    public FinanceAccount getReceiveFinanceAccount() {
        return receiveFinanceAccount;
    }

    public void setReceiveFinanceAccount(FinanceAccount receiveFinanceAccount) {
        this.receiveFinanceAccount = receiveFinanceAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }

  

  
}

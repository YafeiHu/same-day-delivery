/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.FinanceAccount.FinanceAccountDirectory;
import Business.Order.MasterOrder;
import Business.Payment.Payment;
import Business.Payment.PaymentDirectory;
import Business.Role.SysFinanceRole;
import Business.Role.Role;
import Business.Role.FinanceRole;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class SysFinanceOrganization extends Organization{
//private PaymentDirectory paymentDirectory=new PaymentDirectory();
    private MasterOrder orderlist=new MasterOrder();
    private FinanceAccountDirectory financeAccountDirectory=new FinanceAccountDirectory();
    private PaymentDirectory paymentDirectory=new PaymentDirectory();

    public SysFinanceOrganization() {
        super(Type.SysFinance.getValue());
    }

    public MasterOrder getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(MasterOrder orderlist) {
        this.orderlist = orderlist;
    }

    public FinanceAccountDirectory getFinanceAccountDirectory() {
        return financeAccountDirectory;
    }

    public void setFinanceAccountDirectory(FinanceAccountDirectory financeAccountDirectory) {
        this.financeAccountDirectory = financeAccountDirectory;
    }

    public PaymentDirectory getPaymentDirectory() {
        return paymentDirectory;
    }

    public void setPaymentDirectory(PaymentDirectory paymentDirectory) {
        this.paymentDirectory = paymentDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SysFinanceRole());
        return roles;
    }
    
}

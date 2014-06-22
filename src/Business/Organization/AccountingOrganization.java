/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Order.MasterOrder;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class AccountingOrganization extends Organization {

    private MasterOrder orderlist = new MasterOrder();

    public AccountingOrganization(String name) {
        super(Type.Account.getValue());
    }

    public MasterOrder getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(MasterOrder orderlist) {
        this.orderlist = orderlist;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

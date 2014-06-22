/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Order.MasterOrder;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.Role.SysSaleRole;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class SysSaleOrganization extends Organization{
    private MasterOrder orderlist=new MasterOrder();
  public SysSaleOrganization() {
        super(Type.SysSale.getValue());
    }

    public MasterOrder getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(MasterOrder orderlist) {
        this.orderlist = orderlist;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SysSaleRole());
        return roles;
    }
    
}

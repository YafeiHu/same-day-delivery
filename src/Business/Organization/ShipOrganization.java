/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Order.MasterOrder;
import Business.Role.WarehouseRole;
import Business.Role.Role;
import Business.Role.ShipRole;
import Business.UserAddress.BillAddressDirectory;
import Business.UserAddress.ShippingAddressDirectory;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ShipOrganization extends Organization {
//private ShippingAddressDirectory shippingAddressDirectory;

    private MasterOrder orderlist = new MasterOrder();
    private BillAddressDirectory billAddressDirectory;

    public ShipOrganization() {
        super(Organization.Type.Ship.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ShipRole());
        return roles;
    }

    public MasterOrder getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(MasterOrder orderlist) {
        this.orderlist = orderlist;
    }

    public BillAddressDirectory getBillAddressDirectory() {
        return billAddressDirectory;
    }

    public void setBillAddressDirectory(BillAddressDirectory billAddressDirectory) {
        this.billAddressDirectory = billAddressDirectory;
    }
}

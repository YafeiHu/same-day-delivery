/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Order.MasterOrder;
import Business.WarehouseLoction.WarehouseLocation;
import Business.Product.Product;
import Business.Product.ProductCatalog;
import Business.Product.ProductDirectory;
import Business.Role.ShipRole;
import Business.Role.WarehouseRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WarehouseOrganization extends Organization{
private ProductCatalog productCatalog=new ProductCatalog();
private WarehouseLocation location;
 private MasterOrder orderlist = new MasterOrder();
    public WarehouseOrganization() {
        super(Type.Warehouse.getValue());
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public WarehouseLocation getLocation() {
        return location;
    }

    public void setLocation(WarehouseLocation location) {
        this.location = location;
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
        roles.add(new WarehouseRole());
        return roles;
    }


     
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Product.Product;
import Business.Product.ProductCatalog;
import Business.Product.ProductDirectory;
import Business.Role.ShipRole;
import Business.Role.WarehouseRole;
import Business.Role.Role;
import Business.Role.SysWarehouseRole;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class SysWarehouseOrganization extends Organization{
private ProductCatalog productCatalog=new ProductCatalog();
private String nation;
    public SysWarehouseOrganization() {
        super(Type.Warehouse.getValue());
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
   

 
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SysWarehouseRole());
        return roles;
    }


     
}
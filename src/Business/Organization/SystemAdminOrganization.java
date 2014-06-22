/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Order.ShippingAndTaxDirectory;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class SystemAdminOrganization extends Organization {
    
   private WorkQueue workQueue=new WorkQueue();
   private ShippingAndTaxDirectory shippingAndTaxDirectory=new ShippingAndTaxDirectory();
   public SystemAdminOrganization() {
        super(Type.SystemAdmin.getValue());
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public ShippingAndTaxDirectory getShippingAndTaxDirectory() {
        return shippingAndTaxDirectory;
    }

    public void setShippingAndTaxDirectory(ShippingAndTaxDirectory shippingAndTaxDirectory) {
        this.shippingAndTaxDirectory = shippingAndTaxDirectory;
    }

   
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SystemAdminRole());
        return roles;
    }
    
}

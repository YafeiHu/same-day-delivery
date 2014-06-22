/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CustomerRole;
import Business.Role.CustomerServiceRole;
import Business.Role.SysCustomerServiceRole;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class CustomerServiceOrganization extends Organization{
    private WorkQueue workQueue=new WorkQueue();
    public  CustomerServiceOrganization() {
        super(Type.CustomerService.getValue());
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CustomerServiceRole());
        return roles;
    }
    
}

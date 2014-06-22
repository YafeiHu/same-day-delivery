/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.SysCustomerServiceRole;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author hyf
 */
public class SysCustomerServiceOrganization extends Organization{
    private WorkQueue workQueue=new WorkQueue();
    public  SysCustomerServiceOrganization() {
        super(Type.SysCustomerService.getValue());
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
        roles.add(new SysCustomerServiceRole());
        return roles;
    }
    
}

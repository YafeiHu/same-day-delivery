/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.EmployeeDirectory;
import Business.WarehouseLoction.WarehouseLocation;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import javax.tools.JavaFileManager;



/**
 *
 * @author Administrator
 */
public abstract class Enterprise extends Organization{

  //    private static Enterprise enterprise;
      private OrganizationDirectory organizationDirectory=new OrganizationDirectory();
      private String location;
     
    public Enterprise(String name) {
        super(name);
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   

   
    /*
    public static Enterprise getInstance(){
        if (business == null){
            business = new Enterprise();
        }
        return business;
    }
    */
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
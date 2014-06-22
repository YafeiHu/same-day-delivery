/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Ship.getValue())){
            organization = new ShipOrganization();
            organizationList.add(organization);
        }
         else if(type.getValue().equals(Type.Warehouse.getValue())){
            organization = new WarehouseOrganization();
            organizationList.add(organization);
        }
         else if(type.getValue().equals(Type.Finance.getValue())){
            organization = new FinanceOrganization();
            organizationList.add(organization);
        }
          else if(type.getValue().equals(Type.CustomerService.getValue())){
            organization = new CustomerServiceOrganization();
            organizationList.add(organization);
        }
         else if(type.getValue().equals(Type.SysFinance.getValue())){
            organization = new SysFinanceOrganization();
            organizationList.add(organization);
        }
         else if(type.getValue().equals(Type.Customer.getValue())){
            organization = new SysCustomerServiceOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.SysWarehouse.getValue())){
            organization = new SysWarehouseOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.SysCustomerService.getValue())){
            organization = new SysCustomerServiceOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Sale.getValue())){
            organization = new SaleOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.SysSale.getValue())){
            organization = new SysSaleOrganization();
            organizationList.add(organization);
        }
       
        return organization;
    }
}
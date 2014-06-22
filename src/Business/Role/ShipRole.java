/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.WarehouseOrganization;
import Business.Organization.Organization;
import Business.Organization.ShipOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.ShipOrganization.ShippingJPanel;
import javax.swing.JPanel;
import Business.System.AmazonSystem;
import UserInterface.ShipOrganization.ShipOrgWorkAreaJPanel;
/**
 *
 * @author raunak
 */
public class ShipRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,AmazonSystem system) {
        return new ShipOrgWorkAreaJPanel(userProcessContainer, account,(ShipOrganization) organization);
    }
    
}

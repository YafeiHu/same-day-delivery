/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.WarehouseOrganization.ProductOrgWorkAreaJPanel;
import javax.swing.JPanel;
import Business.System.AmazonSystem;
/**
 *
 * @author raunak
 */
public class WarehouseRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,AmazonSystem system) {
        return new ProductOrgWorkAreaJPanel(userProcessContainer, account,(WarehouseOrganization) organization,enterprise,system);
    }
    
}

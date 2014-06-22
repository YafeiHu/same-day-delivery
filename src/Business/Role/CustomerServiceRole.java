/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import UserInterface.CustomerServiceRole.CustomerServiceWorkareaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class CustomerServiceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, AmazonSystem system) {
        return new CustomerServiceWorkareaJPanel(userProcessContainer,account,(CustomerServiceOrganization) organization,system);
                
    }
    
}

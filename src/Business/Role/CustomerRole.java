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
import UserInterface.Customer.CustomerWorkareaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class CustomerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, AmazonSystem system) {
        return new CustomerWorkareaJPanel(userProcessContainer,account,system);
                
    }
    
}

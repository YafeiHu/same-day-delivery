/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SystemAdminOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SystemAdmin.SystemAdminWorkareaJPanel;
import javax.swing.JPanel;
import Business.System.AmazonSystem;

/**
 *
 * @author hyf
 */
public class SystemAdminRole extends Role{
     
   
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,Organization organization, Enterprise business,AmazonSystem system) {
       return new SystemAdminWorkareaJPanel(userProcessContainer, account,(SystemAdminOrganization) organization,system);
    }
    
}

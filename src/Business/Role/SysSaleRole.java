/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.FinanceOrganization;
import Business.Organization.SysFinanceOrganization;
import Business.Organization.Organization;
import Business.Organization.SysSaleOrganization;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import UserInterface.FinanceOrganization.ViewPaymentJPanel;
import UserInterface.SaleOrganization.SaleRoleWorkareaJPanel;
import UserInterface.SysFinanceOrganization.PaySupplierJPanel;
import UserInterface.SysSaleOrganization.SysSaleRoleWorkareaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class SysSaleRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, AmazonSystem system) {
       return new SysSaleRoleWorkareaJPanel(userProcessContainer, account,(SysSaleOrganization) organization,system);
    }
    
}

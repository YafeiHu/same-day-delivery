/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.FinanceOrganization;
import Business.Organization.SysFinanceOrganization;
import Business.Organization.Organization;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import UserInterface.FinanceOrganization.FinanceOrgWorkAreaJPanel;
import UserInterface.FinanceOrganization.ViewPaymentJPanel;
import UserInterface.SysFinanceOrganization.PaySupplierJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class FinanceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, AmazonSystem system) {
         return new FinanceOrgWorkAreaJPanel(userProcessContainer, account,(FinanceOrganization) organization);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.Component;
import javax.swing.JPanel;
import Business.System.AmazonSystem;

/**
 *
 * @author raunak
 */
public abstract class Role {

    public enum RoleType {

        Admin("Admin"),
        Customer("Doctor"),
        Order("Order"),
        Finance("Finance"),
        SysFinance("SysFinance"),
        Account("Account"),
        Ship("Lab Assistant");
        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, AmazonSystem system);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    JPanel container;
    AmazonSystem system;
    public LoginJPanel(JPanel userProcessContainer,AmazonSystem system) {
        initComponents();
        this.container=userProcessContainer;
        this.system=system;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("User Name:");

        jLabel2.setText("Password:");

        loginJButton.setBackground(new java.awt.Color(255, 51, 0));
        loginJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        loginJButton.setForeground(new java.awt.Color(255, 255, 255));
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(loginJButton)
                .addContainerGap(257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
       /*  char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        Enterprise testEnterprise = null;
        Organization testOrganization = null;
        Organization testSysOrg = null;
       UserAccount Account = system.getUserAccountDirectory().authenticateUser(userName, password);
       
        UserAccount Account = system.getUserAccountDirectory().authenticateUser(userName, password);
        if (Account == null) {
            for (Organization sysorganization : system.getOrganizationDirectory().getOrganizationList()) {
                Account = sysorganization.getUserAccountDirectory().authenticateUser(userName, password);
                System.out.println(userName);
                System.out.println(password);
                if (Account != null) {
                    testOrganization = sysorganization;
                    break;
                } else if (Account == null) {
                    //  testOrganization = sysorganization;
                    for (Network netWork : system.getNetworklist()) {
                        for (Enterprise enterprise : netWork.getEnterpriseList()) {
                            Account = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                            if (Account != null) {
                                testEnterprise = enterprise;
                            } else {
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    Account = organization.getUserAccountDirectory().authenticateUser(userName, password);
                                    if (Account != null) {
                                        testEnterprise = enterprise;
                                        testOrganization = organization;
                                        break;
                                    }
                                }
                                if (testOrganization != null) {
                                    break;
                                }
                            }
                        }
                        if (testEnterprise != null) {
                            break;

                        }

                    }

                }
            }
        }
        if (Account == null) {
            System.out.println("nonono");
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", Account.getRole().createWorkArea(container, Account, testOrganization, testEnterprise, system));
            layout.next(container);
        }*/
          char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        Enterprise testEnterprise = null;
        Organization testOrganization = null;
        Organization testSysOrg = null;
        UserAccount Account = system.getUserAccountDirectory().authenticateUser(userName, password);
        if (Account == null) {
            for (Organization sysorganization : system.getOrganizationDirectory().getOrganizationList()) {
                Account = sysorganization.getUserAccountDirectory().authenticateUser(userName, password);
                System.out.println(userName);
                System.out.println(password);
                if (Account != null) {
                    testOrganization = sysorganization;
                    break;
                } else if (Account == null) {
                    //  testOrganization = sysorganization;
                    for (Network netWork : system.getNetworklist()) {
                        for (Enterprise enterprise : netWork.getEnterpriseList()) {
                            System.out.println(enterprise.getName());
                            Account = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                            if (Account != null) {
                                testEnterprise = enterprise;
                                System.out.println("11" + testEnterprise);
                            } else {
                                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                    Account = organization.getUserAccountDirectory().authenticateUser(userName, password);
                                    if (Account != null) {
                                        testEnterprise = enterprise;
                                        testOrganization = organization;
                                        System.out.println("22" + testEnterprise);
                                        System.out.println("22" + testOrganization);
                                        break;
                                    }
                                }

                            }
                            if (testOrganization != null) {
                                System.out.println("33" + testOrganization);
                                break;

                            }

                        }
                        if (testEnterprise != null) {
                            System.out.println("44" + testEnterprise);
                            break;

                        }


                    }

                }
                if (testOrganization != null) {
                    System.out.println("55" + testOrganization);
                    break;

                }
            }

        }
        if (Account == null) {
            JOptionPane.showMessageDialog(null, "wrong username or wrong password", "warning", JOptionPane.WARNING_MESSAGE);
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", Account.getRole().createWorkArea(container, Account, testOrganization, testEnterprise, system));
            layout.next(container);
        }
    }//GEN-LAST:event_loginJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SysCustomerServiceRole;

import UserInterface.CustomerServiceRole.*;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.SysCustomerServiceOrganization;
import UserInterface.SystemAdmin.*;
import Business.Organization.SystemAdminOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Business.System.AmazonSystem;

/**
 *
 * @author hyf
 */
public class SysCustomerServiceWorkareaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkareaJPanel
     */
    JPanel userProcessContainer;
    AmazonSystem system;
    SysCustomerServiceOrganization organization;
    UserAccount account;
    public SysCustomerServiceWorkareaJPanel(JPanel userProcessContainer, UserAccount account, SysCustomerServiceOrganization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.account = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageNetworkJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        manageNetworkJButton.setBackground(new java.awt.Color(255, 51, 0));
        manageNetworkJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        manageNetworkJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageNetworkJButton.setText("Manage Network");
        manageNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageNetworkJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap(337, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(152, 152, 152)
                .addComponent(manageNetworkJButton)
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButtonActionPerformed

        ComplainRequestJPanel crjp = new ComplainRequestJPanel(userProcessContainer,account,organization);
        userProcessContainer.add("manageEmployeeJPanel",crjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageNetworkJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageNetworkJButton;
    // End of variables declaration//GEN-END:variables
}

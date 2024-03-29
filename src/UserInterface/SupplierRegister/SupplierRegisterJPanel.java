/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SupplierRegister;

import UserInterface.AdministrativeRole.*;
import UserInterface.Customer.*;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.WarehouseLoction.WarehouseLocation;
import Business.Network.Network;
import Business.Organization.SysCustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Organization.SystemAdminOrganization;
import Business.Role.SysCustomerServiceRole;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.RegisterRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class SupplierRegisterJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    AmazonSystem system;
    Network network;
    UserAccount user;

    public SupplierRegisterJPanel(JPanel userProcessContainer, UserAccount user, AmazonSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.user = user;
        networkComboBox1.removeAllItems();
        for (Network n : system.getNetworklist()) {
            networkComboBox1.addItem(n);
        }
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
        addressJTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NameJTextField = new javax.swing.JTextField();
        networkComboBox1 = new javax.swing.JComboBox();
        checkoutJButton1 = new javax.swing.JButton();
        backjButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("address is:");

        jLabel5.setText("name is:");

        networkComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBox1ActionPerformed(evt);
            }
        });

        checkoutJButton1.setBackground(new java.awt.Color(0, 153, 0));
        checkoutJButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        checkoutJButton1.setForeground(new java.awt.Color(255, 255, 255));
        checkoutJButton1.setText("continue>>");
        checkoutJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButton1ActionPerformed(evt);
            }
        });

        backjButton3.setBackground(new java.awt.Color(0, 153, 0));
        backjButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backjButton3.setForeground(new java.awt.Color(255, 255, 255));
        backjButton3.setText("<< Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(networkComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NameJTextField)
                                    .addComponent(addressJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(backjButton3)
                        .addGap(71, 71, 71)
                        .addComponent(checkoutJButton1)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(networkComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addressJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutJButton1)
                    .addComponent(backjButton3))
                .addGap(113, 113, 113))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void networkComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBox1ActionPerformed

        network = (Network) networkComboBox1.getSelectedItem();
    }//GEN-LAST:event_networkComboBox1ActionPerformed

    private void checkoutJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButton1ActionPerformed
        // TODO add your handling code here:
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setSupplierName(NameJTextField.getText());
        registerRequest.setLocation(addressJTextField1.getText());
        registerRequest.setNetwork(network);
        registerRequest.setSender(user);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:hh-mm");
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        String str = df.format(now);
        registerRequest.setRequestDate(now);
        registerRequest.setStatus("processing");
         for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SystemAdminOrganization) {
                ((SystemAdminOrganization) o).getWorkQueue().add(registerRequest);
            }
        }
         user.getWorkQueue().add(registerRequest);
    }//GEN-LAST:event_checkoutJButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameJTextField;
    private javax.swing.JTextField addressJTextField1;
    private javax.swing.JButton backjButton3;
    private javax.swing.JButton checkoutJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox networkComboBox1;
    // End of variables declaration//GEN-END:variables
}

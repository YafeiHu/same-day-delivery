/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Employee.Employee;
import Business.Organization.SysCustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Role.CustomerRole;
import Business.Role.SysCustomerServiceRole;
import Business.System.AmazonSystem;
import Business.System.Validate;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class RegisterJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterJPanel
     */
    JPanel userProcessContainer;
    UserAccount user;
    AmazonSystem system;
    public RegisterJPanel(JPanel userProcessContainer,AmazonSystem system) {
        initComponents();
        user =new UserAccount();
        this.userProcessContainer=userProcessContainer;
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
        usernameJTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordJTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        personNameJTextField = new javax.swing.JTextField();
        checkoutJButton = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("My email address is:");

        jLabel3.setText("Passward:");

        jLabel5.setText("My name is:");

        checkoutJButton.setBackground(new java.awt.Color(0, 153, 0));
        checkoutJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        checkoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutJButton.setText("continue>>");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        backjButton1.setBackground(new java.awt.Color(0, 153, 0));
        backjButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(checkoutJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordJTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(personNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(usernameJTextField1))))
                .addGap(278, 278, 278))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(personNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordJTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutJButton)
                    .addComponent(backjButton1))
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        Validate validate=new Validate();
         if(!validate.checkIfNullOrEmpty(personNameJTextField.getText(),usernameJTextField1.getText(), passwordJTextField3.getText())){
                JOptionPane.showMessageDialog(null, "Please input every field", "warning", JOptionPane.WARNING_MESSAGE);
        }
         else{
        for(Organization oganization:system.getOrganizationDirectory().getOrganizationList()){
            if(oganization instanceof SysCustomerServiceOrganization){
               Employee employee= ((SysCustomerServiceOrganization)oganization).getEmployeeDirectory().createEmployee(personNameJTextField.getText());
                ((SysCustomerServiceOrganization)oganization).getUserAccountDirectory().createUserAccount(usernameJTextField1.getText(), passwordJTextField3.getText(), employee, new CustomerRole());
            }
        }
         
        CustomerWorkareaJPanel cwjp = new CustomerWorkareaJPanel(userProcessContainer,user,system);
        userProcessContainer.add("ViewProductDetailJPanel", cwjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
         }
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField passwordJTextField3;
    private javax.swing.JTextField personNameJTextField;
    private javax.swing.JTextField usernameJTextField1;
    // End of variables declaration//GEN-END:variables
}
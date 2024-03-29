/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ShipOrganization;


import Business.Order.Order;
import Business.Organization.ShipOrganization;
import Business.Shipment.Shipment;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hyf
 */
public class ShipOrgWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ShipOrganization shipOrganization;
    private UserAccount user;


    public ShipOrgWorkAreaJPanel(JPanel userProcessContainer, UserAccount user, ShipOrganization shipOrganization) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.shipOrganization = shipOrganization;
        this.user = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        refreshTestJButton.setBackground(new java.awt.Color(255, 51, 0));
        refreshTestJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        refreshTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setText("shipping");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(refreshTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addGap(135, 135, 135)
                .addComponent(refreshTestJButton)
                .addContainerGap(295, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        ShippingJPanel pjp = new ShippingJPanel(userProcessContainer, user, shipOrganization);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestLabTestJPanel", pjp);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_refreshTestJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton refreshTestJButton;
    // End of variables declaration//GEN-END:variables
}

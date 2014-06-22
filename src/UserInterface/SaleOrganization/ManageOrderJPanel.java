/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SaleOrganization;

import Business.Enterprise.Enterprise;
import UserInterface.SysSaleOrganization.*;
import UserInterface.ShipOrganization.*;
import Business.Order.Order;
import Business.Organization.SaleOrganization;
import Business.Organization.ShipOrganization;
import Business.Organization.SysSaleOrganization;
import Business.Shipment.Shipment;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    SaleOrganization organization;
    AmazonSystem system;
    private UserAccount user;
 Enterprise enterprise;
    /**
     * Creates new form ShippingJPanel
     */
    public ManageOrderJPanel(JPanel userProcessContainer, UserAccount user, SaleOrganization organization, Enterprise enterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.user = user;
        this.system = system;
        this.enterprise=enterprise;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) orderJTable.getModel();
        model.setRowCount(0);
        for (Order o : organization.getOrderlist().getOrders()) {
            Object row[] = new Object[8];
            row[0] = o;
            row[1] = o.getCustomer();
            row[2] = o.getSubtotalPrice();
            row[3] = o.tax();
            row[4] = o.shipping();
            row[5] = o.totalMoney();
            row[6] = o.getOrderDate();
            row[7] = o.getShipment().getStatus();
            model.addRow(row);
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

        requestTestJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        requestTestJButton.setBackground(new java.awt.Color(255, 51, 0));
        requestTestJButton.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("view");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        orderJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order number", "customer", "subtotal", "tax", "shipping fee", "Order total", "Order time", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderJTable);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(requestTestJButton)))
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(requestTestJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(backjButton1)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        int selectedRow = orderJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Order order = (Order) orderJTable.getValueAt(selectedRow, 0);
        ViewOrderJPanel vojp = new ViewOrderJPanel(userProcessContainer, order);
        userProcessContainer.add("ManageSuppliersJPanel", vojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderJTable;
    private javax.swing.JButton requestTestJButton;
    // End of variables declaration//GEN-END:variables
}

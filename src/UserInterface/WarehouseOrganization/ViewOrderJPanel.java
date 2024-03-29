/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WarehouseOrganization;

import UserInterface.ShipOrganization.*;
import UserInterface.Customer.*;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Order.ShippingAndTax;
import Business.Organization.Organization;
import Business.Organization.SystemAdminOrganization;
import Business.Organization.WarehouseOrganization;
import Business.Product.Product;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class ViewOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookOrderJPanel
     */
    JPanel userProcessContainer;
    Order order;

    public ViewOrderJPanel(JPanel userProcessContainer, Order order) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        popOrderTable();

    }

    public void popOrderTable() {
        int rowCount = productTable1.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productTable1.getModel()).removeRow(i);
        }
        for (OrderItem o : order.getOrder()) {
            Object row[] = new Object[3];
            row[0] = o;
            row[1] = o.getProduct().getProductId();
            row[2] = o.getNumber();
            ((DefaultTableModel) productTable1.getModel()).addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable1 = new javax.swing.JTable();
        backjButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        productTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "id", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable1);

        backjButton3.setBackground(new java.awt.Color(0, 153, 0));
        backjButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backjButton3.setForeground(new java.awt.Color(255, 255, 255));
        backjButton3.setText("<< Back");
        backjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 376, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backjButton3)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                .addComponent(backjButton3)
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable1;
    // End of variables declaration//GEN-END:variables
}

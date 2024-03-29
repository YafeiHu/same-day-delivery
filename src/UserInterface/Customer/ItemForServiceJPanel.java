/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.FinanceAccount.FinanceAccount;
import Business.FinanceAccount.TrasactionAccount;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.AccountingOrganization;
import Business.Organization.SysFinanceOrganization;
import Business.Organization.Organization;
import Business.Organization.ShipOrganization;
import Business.Payment.Payment;
import Business.Product.Product;
import Business.Product.Review;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import Business.UserAddress.BillAddress;
import Business.UserAddress.ShippingAddress;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class ItemForServiceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BillingJPanel
     */
    JPanel userProcessContainer;
    Order order;
    AmazonSystem system;
    UserAccount user;
    Product product;

    public ItemForServiceJPanel(JPanel userProcessContainer, Order order, UserAccount user, AmazonSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.system = system;
        this.user = user;
        popOrderTable();

        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        product = (Product) productJTable.getValueAt(selectedRow, 0);
    }

    public void popOrderTable() {
        int rowCount = productJTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productJTable.getModel()).removeRow(i);
        }
        for (OrderItem o : order.getOrder()) {
            Object row[] = new Object[4];
            row[0] = o;
            row[1] = o.getProduct().getProductId();
            row[2] = o.getNumber();
            row[3] = o.getProduct().getPrice();
            ((DefaultTableModel) productJTable.getModel()).addRow(row);
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

        returnJButton = new javax.swing.JButton();
        complaintJButton1 = new javax.swing.JButton();
        returnJButton1 = new javax.swing.JButton();
        returnJButton2 = new javax.swing.JButton();
        complaintJButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productJTable = new javax.swing.JTable();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        returnJButton.setBackground(new java.awt.Color(255, 51, 0));
        returnJButton.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        returnJButton.setForeground(new java.awt.Color(255, 255, 255));
        returnJButton.setText("return ");
        returnJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnJButtonActionPerformed(evt);
            }
        });

        complaintJButton1.setBackground(new java.awt.Color(255, 51, 0));
        complaintJButton1.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        complaintJButton1.setForeground(new java.awt.Color(255, 255, 255));
        complaintJButton1.setText("repair");
        complaintJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaintJButton1ActionPerformed(evt);
            }
        });

        returnJButton1.setBackground(new java.awt.Color(255, 51, 0));
        returnJButton1.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        returnJButton1.setForeground(new java.awt.Color(255, 255, 255));
        returnJButton1.setText("return product");
        returnJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnJButton1ActionPerformed(evt);
            }
        });

        returnJButton2.setBackground(new java.awt.Color(255, 51, 0));
        returnJButton2.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        returnJButton2.setForeground(new java.awt.Color(255, 255, 255));
        returnJButton2.setText("change");
        returnJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnJButton2ActionPerformed(evt);
            }
        });

        complaintJButton2.setBackground(new java.awt.Color(255, 51, 0));
        complaintJButton2.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        complaintJButton2.setForeground(new java.awt.Color(255, 255, 255));
        complaintJButton2.setText("complaint");
        complaintJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaintJButton2ActionPerformed(evt);
            }
        });

        productJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "id", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productJTable);

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
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(returnJButton)
                        .addGap(54, 54, 54)
                        .addComponent(returnJButton1)
                        .addGap(65, 65, 65)
                        .addComponent(returnJButton2)))
                .addGap(59, 59, 59)
                .addComponent(complaintJButton1)
                .addGap(65, 65, 65)
                .addComponent(complaintJButton2)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnJButton)
                    .addComponent(complaintJButton1)
                    .addComponent(returnJButton1)
                    .addComponent(returnJButton2)
                    .addComponent(complaintJButton2))
                .addGap(181, 181, 181)
                .addComponent(backjButton1)
                .addGap(68, 68, 68))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem orderItem = (OrderItem) productJTable.getValueAt(selectedRow, 0);
        Date d = new Date();
        ReturnAfterJPanel rpjp = new ReturnAfterJPanel(userProcessContainer, order, orderItem, user, system);
        userProcessContainer.add("ViewProductDetailJPanel", rpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_returnJButtonActionPerformed

    private void complaintJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaintJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem orderItem = (OrderItem) productJTable.getValueAt(selectedRow, 0);
        RepairProductJPanel rpj = new RepairProductJPanel(userProcessContainer, order, orderItem, user, system);
        userProcessContainer.add("ViewProductDetailJPanel", rpj);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_complaintJButton1ActionPerformed

    private void returnJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem orderItem = (OrderItem) productJTable.getValueAt(selectedRow, 0);
        ReturnProductJPanel cpjp = new ReturnProductJPanel(userProcessContainer, order, orderItem, user, system);
        userProcessContainer.add("ViewProductDetailJPanel", cpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_returnJButton1ActionPerformed

    private void returnJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnJButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem orderItem = (OrderItem) productJTable.getValueAt(selectedRow, 0);
        ChangeProductJPanel cpjp = new ChangeProductJPanel(userProcessContainer, order, orderItem, user, system);
        userProcessContainer.add("ViewProductDetailJPanel", cpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_returnJButton2ActionPerformed

    private void complaintJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaintJButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem orderItem = (OrderItem) productJTable.getValueAt(selectedRow, 0);
        ComplaintJPanel cjp = new ComplaintJPanel(userProcessContainer, order, orderItem, user, system);
        userProcessContainer.add("ViewProductDetailJPanel", cjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_complaintJButton2ActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton complaintJButton1;
    private javax.swing.JButton complaintJButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productJTable;
    private javax.swing.JButton returnJButton;
    private javax.swing.JButton returnJButton1;
    private javax.swing.JButton returnJButton2;
    // End of variables declaration//GEN-END:variables
}

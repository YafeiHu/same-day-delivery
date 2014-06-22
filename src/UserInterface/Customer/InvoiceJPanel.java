/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Invoice.Invoice;
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
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class InvoiceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookOrderJPanel
     */
    JPanel userProcessContainer;
    AmazonSystem system;
    Order order;
    UserAccount user;
    Invoice invoice;
    public InvoiceJPanel(JPanel userProcessContainer, Order order, UserAccount user, AmazonSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.system = system;
        this.user = user;
        invoice=new Invoice();
        showMoney();
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
            row[1] = o.getNumber();
            row[2] = o.getMoney();
            ((DefaultTableModel) productTable1.getModel()).addRow(row);
        }

    }
 public void  showMoney() {
     invoice.setInvoiceDate(new Date());
     invoice.setOrder(order);
     invoice.setPaid(0);
     invoice.setUnpaid(order.totalMoney());
     order.setInvoice(invoice);
     ordernumjLabel2.setText(String.valueOf(order.getOrderNum()));
     subtotalJLabel1.setText(String.valueOf(order.getSubtotalPrice()));
     shippingJLabel2.setText(String.valueOf(order.shipping()));
     taxJLabel2.setText(String.valueOf(order.tax()));
     totalJLabel3.setText(String.valueOf(order.totalMoney()));
     paidJLabel4.setText(String.valueOf(invoice.getPaid()));
     unpaidJLabel5.setText(String.valueOf(invoice.getUnpaid()));
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
        ordernumjLabel2 = new javax.swing.JLabel();
        checkoutJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        subtotalJLabel1 = new javax.swing.JLabel();
        taxJLabel2 = new javax.swing.JLabel();
        totalJLabel3 = new javax.swing.JLabel();
        shippingJLabel2 = new javax.swing.JLabel();
        ordernumjLabel3 = new javax.swing.JLabel();
        paidJLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unpaidJLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        productTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Price"
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

        ordernumjLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        checkoutJButton.setBackground(new java.awt.Color(0, 153, 0));
        checkoutJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        checkoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutJButton.setText(" submit >>");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("subtotal");

        jLabel6.setText("shipping");

        jLabel7.setText("tax");

        jLabel8.setText("total");

        ordernumjLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ordernumjLabel3.setForeground(new java.awt.Color(255, 51, 0));
        ordernumjLabel3.setText("order number");

        jLabel9.setText("paid");

        jLabel10.setText("unpaid");

        jLabel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Invoice");

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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(checkoutJButton)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(76, 76, 76)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(shippingJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(subtotalJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(85, 85, 85)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(taxJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(unpaidJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(85, 85, 85)
                            .addComponent(paidJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ordernumjLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(ordernumjLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ordernumjLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordernumjLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(subtotalJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(taxJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)))
                    .addComponent(shippingJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paidJLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unpaidJLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutJButton)
                    .addComponent(backjButton1))
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        // order.quantity();
        CustomerWorkareaJPanel cwjp = new CustomerWorkareaJPanel(userProcessContainer, user, system);
        userProcessContainer.add("5", cwjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ordernumjLabel2;
    private javax.swing.JLabel ordernumjLabel3;
    private javax.swing.JLabel paidJLabel4;
    private javax.swing.JTable productTable1;
    private javax.swing.JLabel shippingJLabel2;
    private javax.swing.JLabel subtotalJLabel1;
    private javax.swing.JLabel taxJLabel2;
    private javax.swing.JLabel totalJLabel3;
    private javax.swing.JLabel unpaidJLabel5;
    // End of variables declaration//GEN-END:variables
}
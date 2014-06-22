/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Enterprise.Supplier;
import Business.FinanceAccount.FinanceAccount;
import Business.FinanceAccount.TrasactionAccount;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.AccountingOrganization;
import Business.Organization.CustomerServiceOrganization;
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
import Business.WorkQueue.ReturnProductRequest;
import Business.WorkQueue.ReturnRequest;
import Business.WorkQueue.WorkQueue;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class ReturnProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BillingJPanel
     */
    JPanel userProcessContainer;
    Order order;
    AmazonSystem system;
    UserAccount user;
    OrderItem orderItem;
    ReturnProductRequest returnRequest;

    public ReturnProductJPanel(JPanel userProcessContainer, Order order, OrderItem orderItem, UserAccount user, AmazonSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.system = system;
        this.orderItem = orderItem;
        this.user = user;
        returnRequest = new ReturnProductRequest();
        reasonJComboBox.removeAllItems();
        reasonJComboBox.addItem("out of stock");
        reasonJComboBox.addItem("Supplier agreed with my return");
        reasonJComboBox.addItem("ship time is longer than promised");
        reasonJComboBox.addItem("other reasons");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkoutJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        reasonJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        describeJTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        moneyJTextField1 = new javax.swing.JTextField();
        moneyJLabel1 = new javax.swing.JLabel();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        checkoutJButton.setBackground(new java.awt.Color(0, 153, 0));
        checkoutJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        checkoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutJButton.setText("continue>>");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("reason to return");

        reasonJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        reasonJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reasonJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("money");

        describeJTextArea1.setColumns(20);
        describeJTextArea1.setRows(5);
        jScrollPane2.setViewportView(describeJTextArea1);

        jLabel8.setText("decscibe");

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
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(checkoutJButton)
                .addGap(184, 184, 184))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(moneyJTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reasonJComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(moneyJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reasonJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(moneyJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutJButton)
                    .addComponent(backjButton1))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:

        if (moneyJTextField1.getText() == null) {
            return;
        }
        String money = moneyJTextField1.getText();
        returnRequest.setMoney(Float.valueOf(money));
        returnRequest.setDescribe(describeJTextArea1.getText());
        returnRequest.setOrderItem(orderItem);
        returnRequest.setOrder(order);
        returnRequest.setSender(user);
        returnRequest.setRequestDate(new Date());
        returnRequest.setStatus("under processing");
        /* WorkQueue queue=new WorkQueue();
         queue.add(returnRequest);
         user.setWorkQueue(queue);*/
        user.getWorkQueue().add(returnRequest);
        for (Organization o : orderItem.getProduct().getSupplier().getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof CustomerServiceOrganization) {
                ((CustomerServiceOrganization) o).getWorkQueue().add(returnRequest);
            }
        }

    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void reasonJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reasonJComboBoxActionPerformed
        // TODO add your handling code here:

        if (reasonJComboBox.getSelectedItem() == null) {
            return;
        }
        String reason = (String) reasonJComboBox.getSelectedItem();
        returnRequest.setReason(reason);
    }//GEN-LAST:event_reasonJComboBoxActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JTextArea describeJTextArea1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel moneyJLabel1;
    private javax.swing.JTextField moneyJTextField1;
    private javax.swing.JComboBox reasonJComboBox;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import UserInterface.SysFinanceOrganization.*;
import Business.Enterprise.Supplier;
import Business.FinanceAccount.FinanceAccount;
import Business.FinanceAccount.TrasactionAccount;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.FinanceOrganization;
import Business.Organization.SysFinanceOrganization;
import Business.Organization.Organization;
import Business.Organization.ShipOrganization;
import Business.Payment.Payment;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class manageFinanceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaySupplierJPanel
     */
    JPanel userProcessContainer;
    UserAccount user;
    FinanceAccount financeAccount;

    public manageFinanceJPanel(JPanel userProcessContainer, UserAccount user) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.user = user;
        financeAccountJComboBox.removeAllItems();
        for (FinanceAccount f : user.getFinanceAccountDirectory().getFinanceAccountList()) {
            financeAccountJComboBox.addItem(f);
        }
        showJTextField1.setText(String.valueOf(financeAccount.getRemaining()));
        populatePaymentTable();
    }

    public void populatePaymentTable() {
        DefaultTableModel model = (DefaultTableModel) paymentJTable.getModel();
        model.setRowCount(0);
        for (Payment p : user.getPaymentDirectory().getPaymentlist()) {
            System.out.println(financeAccount);
            if (p.getReceiveFinanceAccount() == financeAccount || p.getSendFinanceAccount() == financeAccount) {
                Object[] row = new Object[5];
                row[0] = p;
                row[1] = p.getSendFinanceAccount();
                row[2] = p.getReceiveFinanceAccount();
                row[3] = p.getTotal();
                row[4] = p.getDate();
                model.addRow(row);
            }


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

        showJTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        paymentJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        financeAccountJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        paymentJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "send", "receive", "total", "date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(paymentJTable);

        jLabel1.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("remaining");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("choose an account");

        financeAccountJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        financeAccountJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeAccountJComboBoxActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(showJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(financeAccountJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(financeAccountJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(showJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(backjButton1)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void financeAccountJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeAccountJComboBoxActionPerformed
        // TODO add your handling code here:
        financeAccount = (FinanceAccount) financeAccountJComboBox.getSelectedItem();
        if (financeAccount == null) {
            return;
        }
    }//GEN-LAST:event_financeAccountJComboBoxActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JComboBox financeAccountJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable paymentJTable;
    private javax.swing.JTextField showJTextField1;
    // End of variables declaration//GEN-END:variables
}
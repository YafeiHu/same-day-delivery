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
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class ShippingJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ShipOrganization shipOrganization;
    private UserAccount user;

    /**
     * Creates new form ShippingJPanel
     */
    public ShippingJPanel(JPanel userProcessContainer, UserAccount user, ShipOrganization shipOrganization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.shipOrganization = shipOrganization;
        this.user = user;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) orderJTable.getModel();
        model.setRowCount(0);
        for (Order order : shipOrganization.getOrderlist().getOrders()) {
            Object[] row = new Object[3];
            row[0] = order;
            row[1] = order.getShipment().getStatus();
            row[2] = order.getPackaging().getPackageDate();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        backjButton3 = new javax.swing.JButton();
        requestTestJButton1 = new javax.swing.JButton();
        address2JTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        address1JTextField = new javax.swing.JTextField();
        cityJTextField = new javax.swing.JTextField();
        stateJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        firstnameJTextField = new javax.swing.JTextField();
        emailJTextField = new javax.swing.JTextField();
        zipcodeJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lastnameJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "order number", "order status", "order time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderJTable);
        orderJTable.getColumnModel().getColumn(0).setResizable(false);

        requestTestJButton.setBackground(new java.awt.Color(255, 0, 51));
        requestTestJButton.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("view");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        refreshTestJButton.setBackground(new java.awt.Color(255, 51, 0));
        refreshTestJButton.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        refreshTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setText("shipping");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        backjButton3.setBackground(new java.awt.Color(0, 153, 0));
        backjButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backjButton3.setForeground(new java.awt.Color(255, 255, 255));
        backjButton3.setText("<< Back");
        backjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton3ActionPerformed(evt);
            }
        });

        requestTestJButton1.setBackground(new java.awt.Color(0, 102, 255));
        requestTestJButton1.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        requestTestJButton1.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton1.setText("show ");
        requestTestJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Last name");

        jLabel1.setText("First name");

        jLabel3.setText("Address 1");

        jLabel5.setText("City");

        jLabel4.setText("Address 2");

        jLabel7.setText("Zip code");

        jLabel6.setText("State");

        jLabel8.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(firstnameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64)
                        .addComponent(lastnameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(64, 64, 64)
                            .addComponent(address1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(64, 64, 64)
                            .addComponent(address2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGap(70, 70, 70)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailJTextField)
                                .addComponent(zipcodeJTextField)
                                .addComponent(stateJTextField)
                                .addComponent(cityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshTestJButton)
                        .addGap(79, 79, 79)
                        .addComponent(requestTestJButton1)
                        .addGap(69, 69, 69)
                        .addComponent(requestTestJButton)))
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backjButton3)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshTestJButton)
                    .addComponent(requestTestJButton)
                    .addComponent(requestTestJButton1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(firstnameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(lastnameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(address1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(address2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(zipcodeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backjButton3)
                .addContainerGap(147, Short.MAX_VALUE))
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

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        int selectedRow = orderJTable.getSelectedRow();
        Order order = (Order) orderJTable.getValueAt(selectedRow, 0);
        Shipment shipment = order.getShipment();
        shipment.setShipper(user);
        shipment.setShipDate(new Date());
        shipment.setStatus("shipped");
        UserAccount customer = order.getCustomer();
        Order o = customer.getOrderHistory().find(order.getOrderNum());
        int a = 0;
        for (Order sub : o.getSuborders()) {
            if (sub.getShipment().getStatus() == "shipped") {
                a++;
                System.out.println(a);
            }
        }
        if (a == o.getSuborders().size()) {
            System.out.println(a+"orderrrrr");
            System.out.println(o.getSuborders().size()+"orderrrrr");
            o.getShipment().setShipDate(new Date());
            o.getShipment().setStatus("shipped");
        }
        populateTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void requestTestJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Order order = (Order) orderJTable.getValueAt(selectedRow, 0);
        firstnameJTextField.setText(order.getShipment().getShippingAddress().getFirstname());
        lastnameJTextField.setText(order.getShipment().getShippingAddress().getLastname());
        address1JTextField.setText(order.getShipment().getShippingAddress().getAddress1());
        address2JTextField.setText(order.getShipment().getShippingAddress().getAddress2());
        cityJTextField.setText(order.getShipment().getShippingAddress().getCity());
        stateJTextField.setText(order.getShipment().getShippingAddress().getState());
        zipcodeJTextField.setText(order.getShipment().getShippingAddress().getZipcode());
        emailJTextField.setText(order.getShipment().getShippingAddress().getEmail());
    }//GEN-LAST:event_requestTestJButton1ActionPerformed

    private void backjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address1JTextField;
    private javax.swing.JTextField address2JTextField;
    private javax.swing.JButton backjButton3;
    private javax.swing.JTextField cityJTextField;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JTextField firstnameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastnameJTextField;
    private javax.swing.JTable orderJTable;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JButton requestTestJButton1;
    private javax.swing.JTextField stateJTextField;
    private javax.swing.JTextField zipcodeJTextField;
    // End of variables declaration//GEN-END:variables
}

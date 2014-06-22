/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Order.ShippingAndTax;
import Business.Organization.Organization;
import Business.Organization.SystemAdminOrganization;
import Business.Organization.WarehouseOrganization;
import Business.Packaging.Packaging;
import Business.Product.Product;
import Business.Shipment.Shipment;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hyf
 */
public class CheckResultAfterJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookOrderJPanel
     */
    JPanel userProcessContainer;
    AmazonSystem system;
    ArrayList<WarehouseOrganization> resultStores;
    Order order;
    Network network;
    Supplier supplier;
    WarehouseOrganization organization;
    OrderItem orderItem;
    UserAccount user;
    Order suborder;
    Boolean flag;
    int count;
    public CheckResultAfterJPanel(JPanel userProcessContainer, Order o, OrderItem orderItem, UserAccount user, AmazonSystem system, WarehouseOrganization organization, Boolean flag,int count) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = o;
        this.organization = organization;
        this.system = system;
        this.user = user;
        this.flag = flag;
        this.count=count;
        if (organization != null) {
            if (organization.getOrderlist().getOrders().size() == 0) {
                suborder = order.createSubOrder();
                organization.getOrderlist().add(suborder);
                System.out.println("1" + organization.getName());
            } else {
                for (Order sub : organization.getOrderlist().getOrders()) {
                    if (sub.getOrderNum() == order.getOrderNum()) {
                        suborder = sub;
                    }
                }
            }
            if (suborder == null) {
                suborder = order.createSubOrder();
                organization.getOrderlist().add(suborder);

            }
            suborder.createOrderItem(orderItem);
            for (OrderItem or : suborder.getOrder()) {
                System.out.println("2" + or.getProduct().getName());
            }
            suborder.setOrderDate(order.getOrderDate());
            System.out.println(order.getOrderDate()+"timeeeee");
            Shipment shipment = new Shipment();
            shipment.setShippingAddress(order.getShipment().getShippingAddress());
            shipment.setStatus("wait to be ship");
            suborder.setShipment(shipment);
            Packaging p = new Packaging();
            p.setStatus("wait to be package");
      //      p.setPackageDate(order.getOrderDate());
            suborder.setPackaging(p);
            suborder.setCustomer(order.getCustomer());

        }

        popOrderTable();

        if (order.getShipment() != null) {
            ///////     System.out.println(order.getShipment().getShippingAddress().getCity());
            showMoney();
        }
        if (organization == null && flag == true) {
            order.getOrder().remove(orderItem);
            for (OrderItem i : order.getOrder()) {
                System.out.println(i.getProduct().getName());
            }
            count--;
            System.out.println(order.getOrder().size());
            System.out.println(count);
            popOrderTable();
            showMoney();
            JOptionPane.showMessageDialog(null, "This product is out of stock", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void popOrderTable() {
        int rowCount = productTable1.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productTable1.getModel()).removeRow(i);
        }
        for (OrderItem o : order.getOrder()) {
            Object row[] = new Object[5];
            row[0] = o;
            row[1] = o.getProduct().getProductId();
         //   productTable1.getColumnModel().getColumn(4).setCellRenderer(new TableImageCell());
         //   row[2] = new ImageIcon(o.getProduct().getPicture());
            row[2] = o.getNumber();
            row[3] = o.getProduct().getPrice();
            row[4] = o.getProduct().getSupplier();
            ((DefaultTableModel) productTable1.getModel()).addRow(row);
        }

    }

    public void showMoney() {

        ShippingAndTax shippingAndTax = null;
        String state = order.getShipment().getShippingAddress().getState();
        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SystemAdminOrganization) {
                shippingAndTax = ((SystemAdminOrganization) o).getShippingAndTaxDirectory().findShippingAndTax(state);
                order.setShippingAndTax(shippingAndTax);
            }
        }
        if (shippingAndTax != null) {
            subtotalJLabel1.setText(String.valueOf(order.subtotalPrice()));
            System.out.println(order.subtotalPrice());
            shippingJLabel2.setText(String.valueOf(order.shipping()));
            taxJLabel2.setText(String.valueOf(order.tax()));
            totalJLabel3.setText(String.valueOf(order.totalMoney()));
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
        jLabel2 = new javax.swing.JLabel();
        viewProdjButton2 = new javax.swing.JButton();
        checkoutJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        addJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        subtotalJLabel1 = new javax.swing.JLabel();
        taxJLabel2 = new javax.swing.JLabel();
        totalJLabel3 = new javax.swing.JLabel();
        shippingJLabel2 = new javax.swing.JLabel();
        removeJButton = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        productTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "id", "Quantity", "Price", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable1);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("One day delivary");

        viewProdjButton2.setBackground(new java.awt.Color(255, 51, 0));
        viewProdjButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewProdjButton2.setForeground(new java.awt.Color(255, 255, 255));
        viewProdjButton2.setText("View Product Detail");
        viewProdjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProdjButton2ActionPerformed(evt);
            }
        });

        checkoutJButton.setBackground(new java.awt.Color(0, 153, 0));
        checkoutJButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        checkoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutJButton.setText("continue>>");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("subtotal");

        addJButton.setBackground(new java.awt.Color(0, 153, 255));
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("check");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("shipping");

        jLabel7.setText("tax");

        jLabel8.setText("total");

        removeJButton.setBackground(new java.awt.Color(0, 153, 255));
        removeJButton.setForeground(new java.awt.Color(255, 255, 255));
        removeJButton.setText("remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
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
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(viewProdjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(removeJButton)
                .addGap(87, 87, 87)
                .addComponent(addJButton)
                .addGap(510, 510, 510))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(checkoutJButton)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shippingJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(subtotalJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(taxJLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalJLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(393, 393, 393))))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(removeJButton)
                    .addComponent(viewProdjButton2))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(subtotalJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkoutJButton)
                                    .addComponent(backjButton1))
                                .addGap(145, 145, 145))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(taxJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shippingJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewProdjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProdjButton2ActionPerformed

        int selectedRow = productTable1.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        OrderItem o = (OrderItem) productTable1.getValueAt(selectedRow, 0);
        ViewProductJPanel vjp = new ViewProductJPanel(userProcessContainer, order, o.getProduct(), user, system);
        userProcessContainer.add("2", vjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProdjButton2ActionPerformed

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        // order.quantity();
        System.out.println("ccccccccccc"+count);
        System.out.println("ccccccccccc"+order.getOrder().size());
        if (count == order.getOrder().size()&&count!=0&&order.getOrder().size()!=0) {
            BillingJPanel bjp = new BillingJPanel(userProcessContainer, order, user, organization, system, resultStores);
            userProcessContainer.add("3", bjp);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Please check item in cart", "warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productTable1.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select item in cart", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
        System.out.println(count+"1ccccccc");
        orderItem = (OrderItem) productTable1.getValueAt(selectedRow, 0);
        ShippingJPanel pjp = new ShippingJPanel(userProcessContainer, order, orderItem, user, system);
        userProcessContainer.add("4", pjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productTable1.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select item in cart", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        OrderItem item = (OrderItem) productTable1.getValueAt(selectedRow, 0);
        order.getOrder().remove(item);
        popOrderTable();
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productTable1;
    private javax.swing.JButton removeJButton;
    private javax.swing.JLabel shippingJLabel2;
    private javax.swing.JLabel subtotalJLabel1;
    private javax.swing.JLabel taxJLabel2;
    private javax.swing.JLabel totalJLabel3;
    private javax.swing.JButton viewProdjButton2;
    // End of variables declaration//GEN-END:variables
}

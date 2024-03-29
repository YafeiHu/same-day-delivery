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
import Business.Organization.SaleOrganization;
import Business.Organization.ShipOrganization;
import Business.Organization.SysSaleOrganization;
import Business.Organization.WarehouseOrganization;
import Business.Payment.Payment;
import Business.System.AmazonSystem;
import Business.System.Validate;
import Business.UserAccount.UserAccount;
import Business.UserAddress.BillAddress;
import Business.UserAddress.ShippingAddress;
import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hyf
 */
public class BillingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BillingJPanel
     */
    JPanel userProcessContainer;
    Order order;
    AmazonSystem system;
    Payment payment;
    BillAddress billAddress;
    FinanceAccount financeAccount;
    String month;
    String type;
    UserAccount user;
    WarehouseOrganization organization;
    ArrayList<WarehouseOrganization> resultStores;

    public BillingJPanel(JPanel userProcessContainer, Order order, UserAccount user, WarehouseOrganization organization, AmazonSystem system, ArrayList<WarehouseOrganization> resultStores) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.system = system;
        this.user = user;
        this.organization = organization;
        this.payment = new Payment();
        order.setPayment(payment);
        financeAccountJComboBox.removeAllItems();
        for (FinanceAccount f : order.getCustomer().getFinanceAccountDirectory().getFinanceAccountList()) {
            financeAccountJComboBox.addItem(f);
        }
        cardTypeJComboBox3.removeAllItems();
        cardTypeJComboBox3.addItem("credit card");
        cardTypeJComboBox3.addItem("debit card");
        monthJComboBox1.removeAllItems();
        for (int i = 1; i < 13; i++) {
            monthJComboBox1.addItem(String.valueOf(i));
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

        emailJTextField1 = new javax.swing.JTextField();
        zipcodeJTextField1 = new javax.swing.JTextField();
        stateJTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        firstnameJTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        address2JTextField1 = new javax.swing.JTextField();
        address1JTextField1 = new javax.swing.JTextField();
        lastnameJTextField1 = new javax.swing.JTextField();
        cityJTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        checkoutJButton = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        financeAccountJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        nameOnCardJTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cardNumberJTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        yearJTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        monthJComboBox1 = new javax.swing.JComboBox();
        cardTypeJComboBox3 = new javax.swing.JComboBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        securityCodeJTextField5 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Address 1");

        jLabel10.setText("Address 2");

        jLabel9.setText("Email");

        jLabel15.setText("State");

        jLabel16.setText("Last name");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("use shipping address");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Zip code");

        jLabel12.setText("City");

        jLabel13.setText("First name");

        jLabel17.setText("Bill Address");

        jLabel1.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("billing");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("save this card");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
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

        backjButton1.setBackground(new java.awt.Color(0, 153, 0));
        backjButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("payment method");

        financeAccountJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        financeAccountJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeAccountJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Name on card");

        jLabel4.setText("Card type");

        jLabel5.setText("Card number");

        jLabel6.setText("Security Code");

        jLabel7.setText("Expires");

        monthJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        monthJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthJComboBox1ActionPerformed(evt);
            }
        });

        cardTypeJComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cardTypeJComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardTypeJComboBox3ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("add to address book");

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("default");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel16))
                                        .addGap(87, 87, 87))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel13))
                                        .addGap(81, 81, 81)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstnameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastnameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(address2JTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(address1JTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stateJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(zipcodeJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel17)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cardTypeJComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameOnCardJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cardNumberJTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)
                            .addComponent(financeAccountJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(checkoutJButton))
                            .addComponent(jCheckBox2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monthJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(yearJTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(securityCodeJTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jCheckBox4))
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(financeAccountJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameOnCardJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(firstnameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cardTypeJComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cardNumberJTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lastnameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(address1JTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address2JTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(monthJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearJTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(securityCodeJTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(jCheckBox2)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cityJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(stateJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(zipcodeJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(emailJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addComponent(jCheckBox3)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton1)
                    .addComponent(checkoutJButton))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        ShippingAddress shippingAddress = order.getShipment().getShippingAddress();
        billAddress = new BillAddress();
        order.getPayment().setBillAddress(billAddress);
        billAddress.setAddress1(shippingAddress.getAddress1());
        billAddress.setAddress2(shippingAddress.getAddress2());
        billAddress.setCity(shippingAddress.getCity());
        billAddress.setEmail(shippingAddress.getEmail());
        billAddress.setFirstname(shippingAddress.getFirstname());
        billAddress.setLastname(shippingAddress.getLastname());
        billAddress.setName(shippingAddress.getName());
        billAddress.setState(shippingAddress.getState());
        billAddress.setZipcode(shippingAddress.getZipcode());
        firstnameJTextField1.setText(billAddress.getFirstname());
        lastnameJTextField1.setText(billAddress.getLastname());
        address1JTextField1.setText(billAddress.getAddress1());
        address2JTextField1.setText(billAddress.getAddress2());
        cityJTextField1.setText(billAddress.getCity());
        stateJTextField1.setText(billAddress.getState());
        zipcodeJTextField1.setText(billAddress.getZipcode());
        emailJTextField1.setText(billAddress.getEmail());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
         Validate validate=new Validate();
         if(!validate.checkIfNullOrEmpty(firstnameJTextField1.getText(),lastnameJTextField1.getText(),address1JTextField1.getText(),
                address2JTextField1.getText(),cityJTextField1.getText(),stateJTextField1.getText(),zipcodeJTextField1.getText(),emailJTextField1.getText(),
                nameOnCardJTextField1.getText(),cardNumberJTextField3.getText(),yearJTextField4.getText())){
                JOptionPane.showMessageDialog(null, "Please input every field", "warning", JOptionPane.WARNING_MESSAGE);
        }else{
        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SysSaleOrganization) {
                ((SysSaleOrganization) o).getOrderlist().add(order);
            }
        }

        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SysFinanceOrganization) {
                ((SysFinanceOrganization) o).getOrderlist().add(order);
                for (FinanceAccount f : ((SysFinanceOrganization) o).getFinanceAccountDirectory().getFinanceAccountList()) {
                    if (f instanceof TrasactionAccount) {
                        payment.setReceiveFinanceAccount(f);
                    }
                    // f.increaseRemaining(order.totalPrice());
                    ((SysFinanceOrganization) o).getPaymentDirectory().add(payment);
                    System.out.println(order.totalPrice());
                }

            }
        }
        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof AccountingOrganization) {
                ((AccountingOrganization) o).getOrderlist().add(order);
            }
        }
        for (OrderItem orderItem : order.getOrder()) {
            for (Organization o : orderItem.getProduct().getSupplier().getOrganizationDirectory().getOrganizationList()) {
                if (o instanceof SaleOrganization) {
                    ((SaleOrganization) o).getOrderlist().add(order);
                }
            }
        }


        for (OrderItem i : order.getOrder()) {
            i.getProduct().totalSoldNum(i.getNumber());
            i.setMoney(i.getProduct().getPrice());
        }
        user.getOrderHistory().add(order);
        for (Order o : user.getOrderHistory().getOrders()) {
            System.out.println(o.getOrderNum());
        }
        //   organization.getOrderlist().add(order);
        payment.setBillAddress(billAddress);
        payment.setDate(new Date());
        payment.setSendFinanceAccount(financeAccount);
        order.setPayment(payment);
        user.getPaymentDirectory().add(payment);
        order.getShipment().setStatus("under processing");
        order.setStatus("waiting to be paid");
        order.reduceProductNum();
        instalmentJPanel ijp = new instalmentJPanel(userProcessContainer, order, user, system);
        userProcessContainer.add("1", ijp);
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

    private void financeAccountJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeAccountJComboBoxActionPerformed
        // TODO add your handling code here:
        financeAccount = (FinanceAccount) financeAccountJComboBox.getSelectedItem();
        if (financeAccount == null) {
            return;
        }
        nameOnCardJTextField1.setText(financeAccount.getNameOnCard());
        cardNumberJTextField3.setText(financeAccount.getCardNumber());
        yearJTextField4.setText(financeAccount.getExpiresYear());
        cardTypeJComboBox3.setSelectedItem(financeAccount.getCardType());
        monthJComboBox1.setSelectedItem(financeAccount.getExpiresMonth());
    }//GEN-LAST:event_financeAccountJComboBoxActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        financeAccount = user.getFinanceAccountDirectory().createFinanceAccount(FinanceAccount.FinanceAccountType.Personal);
        financeAccount.setNameOnCard(nameOnCardJTextField1.getText());
        financeAccount.setCardNumber(cardNumberJTextField3.getText());
        financeAccount.setSecurityCode(yearJTextField4.getText());
        financeAccount.setCardType(type);
        financeAccount.setSecurityCode(yearJTextField4.getText());
        financeAccount.setExpiresMonth(month);
        financeAccount.setExpiresYear(yearJTextField4.getText());
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void monthJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthJComboBox1ActionPerformed
        // TODO add your handling code here:
        month = (String) monthJComboBox1.getSelectedItem();
        if (month == null) {
            return;
        }
    }//GEN-LAST:event_monthJComboBox1ActionPerformed

    private void cardTypeJComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardTypeJComboBox3ActionPerformed
        // TODO add your handling code here:
        type = (String) cardTypeJComboBox3.getSelectedItem();
        if (type == null) {
            return;
        }
    }//GEN-LAST:event_cardTypeJComboBox3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address1JTextField1;
    private javax.swing.JTextField address2JTextField1;
    private javax.swing.JButton backjButton1;
    private javax.swing.JTextField cardNumberJTextField3;
    private javax.swing.JComboBox cardTypeJComboBox3;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JTextField cityJTextField1;
    private javax.swing.JTextField emailJTextField1;
    private javax.swing.JComboBox financeAccountJComboBox;
    private javax.swing.JTextField firstnameJTextField1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastnameJTextField1;
    private javax.swing.JComboBox monthJComboBox1;
    private javax.swing.JTextField nameOnCardJTextField1;
    private javax.swing.JTextField securityCodeJTextField5;
    private javax.swing.JTextField stateJTextField1;
    private javax.swing.JTextField yearJTextField4;
    private javax.swing.JTextField zipcodeJTextField1;
    // End of variables declaration//GEN-END:variables
}

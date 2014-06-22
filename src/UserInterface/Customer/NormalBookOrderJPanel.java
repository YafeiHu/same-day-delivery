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
import Business.Organization.Organization;
import Business.Organization.SysWarehouseOrganization;
import Business.Organization.WarehouseOrganization;
import Business.Product.Product;
import Business.Product.ProductCatalog;
import Business.Product.ProductDirectory;
import Business.Product.ProductSubDirectory;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author hyf
 */
public class NormalBookOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookOrderJPanel
     */
    JPanel userProcessContainer;
    UserAccount user;
    AmazonSystem system;
    Order order;
    Network network;
    Supplier supplier;
    ArrayList<Product> sort;
    int count;
    public NormalBookOrderJPanel(JPanel userProcessContainer, UserAccount user, AmazonSystem system, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.user = user;
        this.network = network;
        this.system = system;
        order = new Order();
        order.setCustomer(user);
        sort = new ArrayList<>();
        typeJComboBox1.removeAllItems();
        typeJComboBox1.addItem("best rated");
        typeJComboBox1.addItem("most popular");
        poputaleProductTable();
        popTree();
    }

    public void poputaleProductTable() {
        //  productTable1.setModel(new CustomModel());
        int rowCount = productTable1.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productTable1.getModel()).removeRow(i);
        }
        SysWarehouseOrganization productOrganization = null;
        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SysWarehouseOrganization) {
                productOrganization = (SysWarehouseOrganization) o;
                for (ProductDirectory directory : productOrganization.getProductCatalog().getProductDirectorys()) {
                    for (ProductSubDirectory subDirectory : directory.getSubDirectoryList()) {
                        for (Product p : subDirectory.getProductList()) {
                            Object row[] = new Object[6];
                            row[0] = p;
                            row[1] = p.getProductId();
                            row[2] = p.getPrice();
                            row[3] = p.getAvailable();
                            productTable1.getColumnModel().getColumn(4).setCellRenderer(new TableImageCell());
                            row[4] = new ImageIcon(p.getPicture());
                            row[5] = p.getSupplier();
                            // row[5] = new JComboBox();
                            // productTable1.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JComboBox()));
                            ((DefaultTableModel) productTable1.getModel()).addRow(row);
                        }
                    }
                }
            }

        }
    }

    public void poputaleProductTable(ArrayList<Product> directory) {
        /*    int rowCount = productTable1.getRowCount();
         for (int i = rowCount - 1; i >= 0; i--) {
         ((DefaultTableModel) productTable1.getModel()).removeRow(i);
         }*/
        //   productTable1.setModel(new CustomModel());
        int rowCount = productTable1.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productTable1.getModel()).removeRow(i);
        }
        for (Product p : directory) {
            Object row[] = new Object[6];
            row[0] = p;
            row[1] = p.getProductId();
            row[2] = p.getPrice();
            row[3] = p.getAvailable();
            productTable1.getColumnModel().getColumn(4).setCellRenderer(new TableImageCell());
            row[4] = new ImageIcon(p.getPicture());
            row[5] = p.getSupplier();
            //row[5] = new JComboBox();
            //productTable1.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JComboBox()));
            //  productTable1.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new Boolean(false)));;
            ((DefaultTableModel) productTable1.getModel()).addRow(row);
        }
    }

    private void popTree() {
        DefaultTreeModel model = (DefaultTreeModel) productCatalogJTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        DefaultMutableTreeNode catalogs = new DefaultMutableTreeNode("product catalogs");
        root.insert(catalogs, 0);
        ArrayList<ProductDirectory> directorys = null;
        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SysWarehouseOrganization) {
                directorys = ((SysWarehouseOrganization) o).getProductCatalog().getProductDirectorys();
            }
        }
        for (int i = 0; i < directorys.size(); i++) {
            ProductDirectory productDirectory = directorys.get(i);
            DefaultMutableTreeNode productDirectorynode = new DefaultMutableTreeNode(productDirectory);
            catalogs.insert(productDirectorynode, i);
            ArrayList<ProductSubDirectory> productSubDirectorys = productDirectory.getSubDirectoryList();
            for (int j = 0; j < productSubDirectorys.size(); j++) {
                ProductSubDirectory productSubDirectory = productSubDirectorys.get(j);
                DefaultMutableTreeNode Productnode = new DefaultMutableTreeNode(productSubDirectory);
                productDirectorynode.insert(Productnode, j);
                model.reload();
            }
            productCatalogJTree.getSelectionModel().setSelectionMode(
                    TreeSelectionModel.SINGLE_TREE_SELECTION);
            productCatalogJTree.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent tse) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) productCatalogJTree.getLastSelectedPathComponent();
                    if (node == null) {
                        return;
                    }
                    Object nodeinfo = node.getUserObject();
                    ArrayList<Product> products = new ArrayList<>();
                    if (nodeinfo instanceof ProductDirectory) {

                        for (ProductSubDirectory productSubDirectory : ((ProductDirectory) nodeinfo).getSubDirectoryList()) {
                            for (Product p : productSubDirectory.getProductList()) {
                                products.add(p);
                                sort = products;
                                poputaleProductTable(products);
                            }
                        }
                    } else if (nodeinfo instanceof ProductSubDirectory) {
                        for (Product p : ((ProductSubDirectory) nodeinfo).getProductList()) {
                            products.add(p);
                            sort = products;
                            poputaleProductTable(products);
                        }
                    }
                }
            });
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

        jLabel4 = new javax.swing.JLabel();
        numberJSpinner = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable1 = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        viewProdjButton2 = new javax.swing.JButton();
        checkoutJButton = new javax.swing.JButton();
        searchJTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        searchJButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        productCatalogJTree = new javax.swing.JTree();
        typeJComboBox1 = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        manageNetworkJButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("number");

        productTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Price", "availability", "picture", "supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable1.setAlignmentX(1.0F);
        productTable1.setAlignmentY(1.0F);
        productTable1.setGridColor(new java.awt.Color(255, 255, 255));
        productTable1.setRowHeight(50);
        productTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        productTable1.setSelectionForeground(new java.awt.Color(255, 51, 0));
        jScrollPane1.setViewportView(productTable1);

        addJButton.setBackground(new java.awt.Color(0, 102, 255));
        addJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("add to cart");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Supplier Product Catalog");

        viewProdjButton2.setBackground(new java.awt.Color(255, 51, 0));
        viewProdjButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        checkoutJButton.setText(" continue >>");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("search");

        searchJButton1.setBackground(new java.awt.Color(0, 153, 255));
        searchJButton1.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        searchJButton1.setForeground(new java.awt.Color(255, 255, 255));
        searchJButton1.setText("search");
        searchJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButton1ActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("system");
        productCatalogJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        productCatalogJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                productCatalogJTreeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(productCatalogJTree);

        typeJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeJComboBox1ActionPerformed(evt);
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

        manageNetworkJButton1.setBackground(new java.awt.Color(255, 51, 102));
        manageNetworkJButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageNetworkJButton1.setForeground(new java.awt.Color(255, 255, 255));
        manageNetworkJButton1.setText("View supplier");
        manageNetworkJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(searchJButton1)
                                                .addGap(66, 66, 66)
                                                .addComponent(typeJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(39, 39, 39)
                                                .addComponent(numberJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71)
                                                .addComponent(addJButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(viewProdjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(69, 69, 69)
                                                .addComponent(manageNetworkJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addGap(146, 146, 146))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(checkoutJButton)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(searchJButton1)
                            .addComponent(typeJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewProdjButton2)
                            .addComponent(manageNetworkJButton1))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(numberJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addJButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkoutJButton)
                            .addComponent(backjButton1))
                        .addGap(84, 84, 84))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productTable1.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Product product = (Product) productTable1.getValueAt(selectedRow, 0);
        OrderItem orderItem = order.createOrderItem();
        orderItem.setProduct(product);
        orderItem.setNumber((int) numberJSpinner.getValue());
        orderItem.setMoney(orderItem.getProduct().getPrice());
        order.setTotalPrice(0);
        /*  if (productTable1.isEditing()) {
         int row = productTable1.getEditingRow();
         int col = productTable1.getEditingColumn();
         productTable1.getCellEditor(row, col).stopCellEditing();
         orderItem.setNumber((int) productTable1.getValueAt(row, col));
         System.out.println(orderItem.getNumber());
         }*/
    }//GEN-LAST:event_addJButtonActionPerformed

    private void viewProdjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProdjButton2ActionPerformed

        int selectedRow = productTable1.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Product product = (Product) productTable1.getValueAt(selectedRow, 0);
        ViewProductJPanel vjp = new ViewProductJPanel(userProcessContainer, order, product, user, system);
        userProcessContainer.add("ViewProductDetailJPanel", vjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProdjButton2ActionPerformed

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        order.setOrderDate(new Date());
        CheckResultAfterJPanel crjp = new CheckResultAfterJPanel(userProcessContainer, order, null, user, system, null, false,count);
        userProcessContainer.add("ViewProductDetailJPanel", crjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void productCatalogJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_productCatalogJTreeValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) productCatalogJTree.getLastSelectedPathComponent();

    }//GEN-LAST:event_productCatalogJTreeValueChanged

    private void searchJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButton1ActionPerformed
        // TODO add your handling code here:
        for (Organization o : system.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof SysWarehouseOrganization) {
                ArrayList<Product> p = ((SysWarehouseOrganization) o).getProductCatalog().search(searchJTextField1.getText());
                if (p != null) {
                    poputaleProductTable(p);
                }
            }
        }

    }//GEN-LAST:event_searchJButton1ActionPerformed

    private void typeJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeJComboBox1ActionPerformed
        // TODO add your handling code here:
        ProductSubDirectory subDirectory = new ProductSubDirectory();
        String type = (String) typeJComboBox1.getSelectedItem();
        if (type == null) {
            return;
        } else if (type.equals("best rated")) {
            for (Product p : sort) {
                subDirectory.newProduct(p);
                ArrayList<Product> s = subDirectory.getMostRateProduct(subDirectory);
            }
        } else if (type.equals("most popular")) {
            for (Product p : sort) {
                subDirectory.newProduct(p);
                ArrayList<Product> s = subDirectory.getMostPopularProduct(subDirectory);
            }
        }
    }//GEN-LAST:event_typeJComboBox1ActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void manageNetworkJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = productTable1.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Product p = (Product) productTable1.getValueAt(selectedRow, 0);
        ViewSupplierRateJPanel mojp = new ViewSupplierRateJPanel(userProcessContainer, p.getSupplier());
        userProcessContainer.add("manageEmployeeJPanel", mojp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton manageNetworkJButton1;
    private javax.swing.JSpinner numberJSpinner;
    private javax.swing.JTree productCatalogJTree;
    private javax.swing.JTable productTable1;
    private javax.swing.JButton searchJButton1;
    private javax.swing.JTextField searchJTextField1;
    private javax.swing.JComboBox typeJComboBox1;
    private javax.swing.JButton viewProdjButton2;
    // End of variables declaration//GEN-END:variables
}

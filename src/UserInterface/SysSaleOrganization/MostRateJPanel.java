/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SysSaleOrganization;

import UserInterface.Customer.*;
import UserInterface.ShipOrganization.*;
import UserInterface.Customer.*;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Supplier;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Order.ShippingAndTax;
import Business.Organization.Organization;
import Business.Organization.SysWarehouseOrganization;
import Business.Organization.SystemAdminOrganization;
import Business.Organization.WarehouseOrganization;
import Business.Product.Product;
import Business.Product.ProductDirectory;
import Business.Product.ProductSubDirectory;
import Business.System.AmazonSystem;
import Business.UserAccount.UserAccount;
import com.db4o.collections.ActivatableArrayList;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author hyf
 */
public class MostRateJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookOrderJPanel
     */
    JPanel userProcessContainer;
    AmazonSystem system;
    Order order;
    UserAccount user;
    ArrayList<Product> sort;

    public MostRateJPanel(JPanel userProcessContainer, Order order) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.system = system;
        this.user = user;
        sort = new ArrayList<>();
        popTree();

    }

    public void poputaleProductTable() {
        int rowCount = productJTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productJTable.getModel()).removeRow(i);
        }
        for (OrderItem o : order.getOrder()) {
            Object row[] = new Object[5];

            row[0] = o.getProduct().getId();
            row[1] = o.getProduct().getSupplier();
            productJTable.getColumnModel().getColumn(4).setCellRenderer(new TableImageCell());
            Product p = o.getProduct();
            row[2] = new ImageIcon(p.getPicture());
            row[3] = o.getNumber();
            row[4] = p.getPrice();
            ((DefaultTableModel) productJTable.getModel()).addRow(row);
        }

    }

    public void poputaleProductTable(ArrayList<Product> directory) {
        int rowCount = productJTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            ((DefaultTableModel) productJTable.getModel()).removeRow(i);
        }
        for (Product p : directory) {
            if (p.getReviews() != null) {
                Object row[] = new Object[6];
                row[0] = p;
                row[1] = p.getProductId();
                row[2] = p.getPrice();
                row[3] = p.getAvailable();
                row[4] = p.rate();
                row[5] = p.getSupplier();
                ((DefaultTableModel) productJTable.getModel()).addRow(row);
            }

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
                                poputaleProductTable(productSubDirectory.getMostRateProduct(sort));
                            }
                        }
                    } else if (nodeinfo instanceof ProductSubDirectory) {
                        for (Product p : ((ProductSubDirectory) nodeinfo).getProductList()) {
                            products.add(p);
                            sort = products;
                            poputaleProductTable(((ProductSubDirectory) nodeinfo).getMostRateProduct(sort));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        productJTable = new javax.swing.JTable();
        viewProdjButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        productCatalogJTree = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        backjButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        productJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name", "Quantity", "Price", "Rate", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productJTable);

        viewProdjButton2.setBackground(new java.awt.Color(255, 51, 0));
        viewProdjButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewProdjButton2.setForeground(new java.awt.Color(255, 255, 255));
        viewProdjButton2.setText("View Product Detail");
        viewProdjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProdjButton2ActionPerformed(evt);
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

        jLabel1.setText("Most rate");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(viewProdjButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backjButton3)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(viewProdjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(backjButton3)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewProdjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProdjButton2ActionPerformed

        int selectedRow = productJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        Product p = (Product) productJTable.getValueAt(selectedRow, 0);
        ViewProductJPanel vjp = new ViewProductJPanel(userProcessContainer, p);
        userProcessContainer.add("ViewProductDetailJPanel", vjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProdjButton2ActionPerformed

    private void productCatalogJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_productCatalogJTreeValueChanged
        // TODO add your handling code here:
        DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) productCatalogJTree.getLastSelectedPathComponent();
    }//GEN-LAST:event_productCatalogJTreeValueChanged

    private void backjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree productCatalogJTree;
    private javax.swing.JTable productJTable;
    private javax.swing.JButton viewProdjButton2;
    // End of variables declaration//GEN-END:variables
}

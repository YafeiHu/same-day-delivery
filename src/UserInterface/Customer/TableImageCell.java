/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hyf
 */
public class TableImageCell extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(null);
            setBorder(null);
            if (isSelected) {
                setForeground(Color.orange);
            }
            if (value instanceof ImageIcon) {
                setIcon((Icon) value);
            } else if (value instanceof String) {
                setText((String) value);
            } else {
                setText("");
            }
            return this;
        }
}
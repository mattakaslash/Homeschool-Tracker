/**
 * 
 */
package ht.view.render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * Renders the dates in a table displaying a month. The date is formatted based
 * on attributes of the corresponding Day in the database.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class MonthTableRenderer extends JLabel implements TableCellRenderer {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 6209385979053109149L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
			
		if (value != null) {
			Integer date = (Integer) value;
			setText(date.toString());
		} else {
			setText("");
		}
		
		if (table.getSelectedRow() == row && table.getSelectedColumn() == column) {
			setBackground(Color.DARK_GRAY);
			setForeground(Color.WHITE);
		} else {
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}

		return this;
	}
}

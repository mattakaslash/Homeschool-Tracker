/**
 * 
 */
package ht.view.render;

import ht.model.swing.MonthTableModel;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;

import javax.swing.BorderFactory;
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
	
	/**
	 * 
	 */
	private static final Calendar TODAY = Calendar.getInstance();
	
	/**
	 * Stores the month index for this table.
	 */
	private Integer _month;

	/**
	 * Creates a new renderer for the given month.
	 * @param month the month
	 */
	public MonthTableRenderer(int month) {
		setMonth(month - 1);
	}

	/**
	 * @return the month
	 */
	public Integer getMonth() {
		return _month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(Integer month) {
		_month = month;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
			
		if (value != null) {
			Integer date = (Integer) value;
			setText(date.toString());
			
			// highlight today's date
			if (((MonthTableModel) table.getModel()).getYear() == TODAY.get(Calendar.YEAR) &&
					getMonth() == TODAY.get(Calendar.MONTH) &&
					date == TODAY.get(Calendar.DAY_OF_MONTH)) {
				setBorder(BorderFactory.createLineBorder(Color.RED));
			} else {
				setBorder(null);
			}
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

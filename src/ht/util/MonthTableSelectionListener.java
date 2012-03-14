/**
 * 
 */
package ht.util;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * 
 */
public abstract class MonthTableSelectionListener implements ListSelectionListener {
	/**
	 * The table for which we are listening for selection events.
	 */
	private JTable _table;

	/**
	 * Creates a new listener.
	 * 
	 * @param table
	 *            the table for which we are listening for selection events
	 */
	public MonthTableSelectionListener(JTable table) {
		setTable(table);
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return _table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(JTable table) {
		_table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int row = getTable().getSelectedRow();
			int col = getTable().getSelectedColumn();
			Integer date = (Integer) getTable().getValueAt(row, col);
			if (date != null) {
				dateChanged(date);
			}
		}
	}

	/**
	 * Called when the selected date in the table changed.
	 * 
	 * @param date
	 *            the new date
	 */
	public abstract void dateChanged(Integer date);
}

/**
 * 
 */
package ht.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 *
 */
public class MonthTableModel implements TableModel {
	private static String[] HEADERS = { "S", "M", "T", "W", "T", "F", "S" };
	private Calendar _ref;
	private List<TableModelListener> _listeners = new ArrayList<TableModelListener>();
	
	/**
	 * Creates a month model for the given month and year.
	 * @param month the month
	 * @param year the year
	 */
	public MonthTableModel(Integer month, Integer year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		setRef(cal);
	}

	/**
	 * Returns the month value, where January is 1
	 * @return the month
	 */
	public Integer getMonth() {
		return getRef().get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Returns the year reference for the month.
	 * @return the year
	 */
	public Integer getYear() {
		return getRef().get(Calendar.YEAR);
	}
	
	/**
	 * Sets the year reference for the month.
	 * @param year the year
	 */
	public void setYear(Integer year) {
		getRef().set(Calendar.YEAR, year);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return getRef().get(Calendar.WEEK_OF_MONTH);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 7;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return HEADERS[columnIndex];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return Integer.class;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Calendar value = (Calendar) getRef().clone();
		value.set(Calendar.WEEK_OF_MONTH, rowIndex + 1);
		switch (columnIndex) {
		case 0:
			value.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			break;
		case 1:
			value.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			break;
		case 2:
			value.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			break;
		case 3:
			value.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			break;
		case 4:
			value.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			break;
		case 5:
			value.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			break;
		case 6:
			value.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			break;
		}

		if(value.get(Calendar.MONTH) == getRef().get(Calendar.MONTH)) {
			return value.get(Calendar.DAY_OF_MONTH);
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void addTableModelListener(TableModelListener l) {
		getListeners().add(l);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {
		getListeners().remove(l);
	}

	/**
	 * @return the listeners
	 */
	private List<TableModelListener> getListeners() {
		return _listeners;
	}

	/**
	 * @param listeners the listeners to set
	 */
	private void setListeners(List<TableModelListener> listeners) {
		_listeners = listeners;
	}

	/**
	 * @return the ref
	 */
	private Calendar getRef() {
		return _ref;
	}

	/**
	 * @param ref the ref to set
	 */
	private void setRef(Calendar ref) {
		_ref = ref;
	}
}

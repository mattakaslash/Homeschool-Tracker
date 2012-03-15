/**
 * 
 */
package ht.model.swing;

import ht.model.CurriculumLogEntry;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Models a list of CurriculumLogEntry entities for displaying in a table.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class CurriculumTableModel implements TableModel {
	private List<TableModelListener> _listeners = new ArrayList<TableModelListener>();

	/**
	 * Adds a new blank {@link CurriculumLogEntry} to the database.
	 */
	public void add() {
		CurriculumLogEntry.add();
		tableChanged(new TableModelEvent(this));
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		getListeners().add(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int col) {
		Class<?> value = null;

		switch (col) {
		case 0:
		case 1:
		case 3:
			value = String.class;
			break;
		case 2:
			value = URL.class;
			break;
		}

		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 4;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int col) {
		String name = null;

		switch (col) {
		case 0:
			name = "Title";
			break;
		case 1:
			name = "Author";
			break;
		case 2:
			name = "URL";
			break;
		case 3:
			name = "Notes";
			break;
		}

		return name;
	}

	/**
	 * @return the listeners
	 */
	public List<TableModelListener> getListeners() {
		return _listeners;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return CurriculumLogEntry.getAll().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		CurriculumLogEntry rowEntry = CurriculumLogEntry.get(row);
		Object value = null;

		switch (col) {
		case 0:
			value = rowEntry.getTitle();
			break;
		case 1:
			value = rowEntry.getAuthor();
			break;
		case 2:
			value = rowEntry.getURL();
			break;
		case 3:
			value = rowEntry.getNotes();
			break;
		}

		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		getListeners().remove(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {
		String input = (String) value;

		CurriculumLogEntry entry = CurriculumLogEntry.get(row);

		switch (col) {
		case 0:
			entry.setTitle(input);
			break;
		case 1:
			entry.setAuthor(input);
			break;
		case 2:
			try {
				entry.setURL(new URL(input));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			entry.setNotes(input);
			break;
		}

		CurriculumLogEntry.save(entry);
		tableChanged(new TableModelEvent(this, row, row, col, TableModelEvent.UPDATE));
	}

	/**
	 * Called whenever the database is updated.
	 * 
	 * @param tableModelEvent
	 */
	private void tableChanged(TableModelEvent tableModelEvent) {
		for (TableModelListener l : getListeners()) {
			l.tableChanged(tableModelEvent);
		}
	}
}

/**
 * 
 */
package ht.model.swing;

import ht.model.ReadingListEntry;
import ht.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * 
 */
public class ReadingListTableModel implements TableModel {
	/**
	 * A list of registered listeners.
	 */
	private List<TableModelListener> _listeners = new ArrayList<TableModelListener>();

	/**
	 * The student for which the entries should be listed.
	 */
	private Student _student;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.table.TableModel#addTableModelListener(javax.swing.event.
	 * TableModelListener)
	 */
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
			value = String.class;
			break;
		case 2:
		case 3:
			value = Date.class;
			break;
		case 4:
			value = Integer.class;
			break;
		case 5:
			value = Boolean.class;
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
		return 6;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int col) {
		String value = "";
		switch (col) {
		case 0:
			value = "Title";
			break;
		case 1:
			value = "Author";
			break;
		case 2:
			value = "Date Started";
			break;
		case 3:
			value = "Date Finished";
			break;
		case 4:
			value = "Progress";
			break;
		case 5:
			value = "Assisted";
			break;
		}

		return value;
	}

	/**
	 * @return the listeners
	 */
	private List<TableModelListener> getListeners() {
		return _listeners;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return ReadingListEntry.getAll(getStudent()).size();
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return _student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Object value = null;

		switch (col) {
		case 0:
			value = ReadingListEntry.get(row, getStudent()).getTitle();
			break;
		case 1:
			value = ReadingListEntry.get(row, getStudent()).getAuthor();
			break;
		case 2:
			value = ReadingListEntry.get(row, getStudent()).getStarted();
			break;
		case 3:
			value = ReadingListEntry.get(row, getStudent()).getFinished();
			break;
		case 4:
			value = ReadingListEntry.get(row, getStudent()).getProgress();
			break;
		case 5:
			value = ReadingListEntry.get(row, getStudent()).getAssisted();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.table.TableModel#removeTableModelListener(javax.swing.event
	 * .TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {
		getListeners().remove(l);
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		_student = student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {
		ReadingListEntry entry = ReadingListEntry.get(row, getStudent());

		switch (col) {
		case 0:
			entry.setTitle((String) value);
			break;
		case 1:
			entry.setAuthor((String) value);
			break;
		case 2:
			entry.setStarted((Date) value);
			break;
		case 3:
			entry.setFinished((Date) value);
			break;
		case 4:
			entry.setProgress((Integer) value);
			break;
		case 5:
			entry.setAssisted((Boolean) value);
			break;
		}

		ReadingListEntry.save(entry);
		tableChanged(new TableModelEvent(this));
	}
	
	/**
	 * Notifies all listeners that the table has changed.
	 */
	public void tableChanged() {
		tableChanged(new TableModelEvent(this));
	}

	/**
	 * Notifies all listeners that the table has changed.
	 * 
	 * @param tableModelEvent
	 *            the event to send to the listeners
	 */
	private void tableChanged(TableModelEvent tableModelEvent) {
		for (TableModelListener l : getListeners()) {
			l.tableChanged(tableModelEvent);
		}
	}
}

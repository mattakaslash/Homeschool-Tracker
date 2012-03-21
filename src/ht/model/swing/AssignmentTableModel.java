package ht.model.swing;

import ht.model.Assignment;
import ht.model.Category;
import ht.model.Student;
import ht.model.Subject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Models a list of assignments.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class AssignmentTableModel implements TableModel {
	/**
	 * List of listeners.
	 */
	private List<TableModelListener> _listeners = new ArrayList<TableModelListener>();
	
	/**
	 * The student for which assignments are loaded.
	 */
	private Student _student;
	
	/**
	 * @return the listeners
	 */
	private List<TableModelListener> getListeners() {
		return _listeners;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return _student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		_student = student;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		getListeners().add(l);		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> value = null;
		switch (columnIndex) {
		case 0:
			value = Subject.class;
			break;
		case 1:
			value = String.class;
			break;
		case 2:
			value = Category.class;
			break;
		case 3:
		case 4:
			value = Date.class;
			break;
		case 5:
		case 6:
			value = Integer.class;
			break;
		case 7:
			value = String.class;
			break;
		}
		
		return value;
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String value = null;
		switch (columnIndex) {
		case 0:
			value = "Subject";
			break;
		case 1:
			value = "Title";
			break;
		case 2:
			value = "Category";
			break;
		case 3:
			value = "Date Assigned";
			break;
		case 4:
			value = "Date Completed";
			break;
		case 5:
			value = "Points Earned";
			break;
		case 6:
			value = "Points Possible";
			break;
		case 7:
			value = "Percentage";
			break;
		}

		return value;
	}

	@Override
	public int getRowCount() {
		return Assignment.getAll(getStudent()).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value = null;
		switch(columnIndex) {
		case 0:
			value = Assignment.get(rowIndex, getStudent()).getSubject();
			break;
		case 1:
			value = Assignment.get(rowIndex, getStudent()).getTitle();
			break;
		case 2:
			value = Assignment.get(rowIndex, getStudent()).getCategory();
			break;
		case 3:
			value = Assignment.get(rowIndex, getStudent()).getDateAssigned();
			break;
		case 4:
			value = Assignment.get(rowIndex, getStudent()).getDateCompleted();
			break;
		case 5:
			value = Assignment.get(rowIndex, getStudent()).getPointsEarned();
			break;
		case 6:
			value = Assignment.get(rowIndex, getStudent()).getPointsPossible();
			break;
		case 7:
			if ((Integer) getValueAt(rowIndex, 6) != 0) {
				Double percent = new Double((Integer) getValueAt(rowIndex, 5)) / new Double((Integer) getValueAt(rowIndex, 6))
						* 100;
				value = Double.valueOf(new DecimalFormat("#.##").format(percent)).toString() + "%";
			} else {
				value = "";
			}
			break;
		}

		return value;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		boolean value = false;
		
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			value = true;
			break;
		case 7:
			value = false;
			break;
		}
		
		return value;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		getListeners().remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Assignment a = Assignment.get(rowIndex, getStudent());
		
		switch(columnIndex) {
		case 0:
			a.setSubject((Subject) aValue);
			break;
		case 1:
			a.setTitle((String) aValue);
			break;
		case 2:
			a.setCategory((Category) aValue);
			break;
		case 3:
			a.setDateAssigned((Date) aValue);
			break;
		case 4:
			a.setDateCompleted((Date) aValue);
			break;
		case 5:
			a.setPointsEarned((Integer) aValue);
			break;
		case 6:
			a.setPointsPossible((Integer) aValue);
			break;
		}
		
		Assignment.save(a);
		tableChanged(new TableModelEvent(this, rowIndex, rowIndex, columnIndex, TableModelEvent.UPDATE));
		
		// update percentage automatically
		if (columnIndex == 5 || columnIndex == 6) {
			tableChanged(new TableModelEvent(this, rowIndex, rowIndex, 7, TableModelEvent.UPDATE));
		}
	}
	
	/**
	 * Informs all listeners that the entire table has changed.
	 */
	public void tableChanged() {
		tableChanged(new TableModelEvent(this));
	}

	/**
	 * Informs all listeners that the table has changed.
	 * 
	 * @param tableModelEvent the event to send
	 */
	private void tableChanged(TableModelEvent tableModelEvent) {
		for (TableModelListener l : getListeners()) {
			l.tableChanged(tableModelEvent);
		}
	}
}

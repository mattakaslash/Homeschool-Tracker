/**
 * 
 */
package ht.view.render;

import ht.model.Day;
import ht.model.FieldTrip;
import ht.model.swing.MonthTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
			
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
			
			// format days based on attendance
			Calendar cal = Calendar.getInstance();
			cal.set(((MonthTableModel) table.getModel()).getYear(), ((MonthTableModel) table.getModel()).getMonth() - 1, date);
			Day day = Day.get(cal);
			
			if (day.hadSchool()) {
				setFont(new Font(getFont().getFontName(), Font.BOLD, getFont().getSize()));
			}
			if (day.isCoopDay()) {
				setForeground(Color.GREEN);
			}
			if (FieldTrip.get(day.getDate()) != null) {
				setForeground(Color.BLUE);
			}
			if (day.isSickDay()) {
				setFont(new Font(getFont().getFontName(), Font.ITALIC, getFont().getSize()));
			}
			if (day.isVacationDay()) {
				setForeground(new Color(0x802A2A));
			}
		} else {
			setText("");
		}
		
		if (table.getSelectedRow() == row && table.getSelectedColumn() == column) {
			setBackground(Color.DARK_GRAY);
			setForeground(Color.WHITE);
		}

		return this;
	}
}

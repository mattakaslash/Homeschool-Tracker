/**
 * 
 */
package ht.view.render;

import ht.model.Student;

import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;

import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Renders a list cell containing a {@link Student}.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class StudentCellRenderer extends JEditorPane implements ListCellRenderer {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = -3584829018356769807L;

	/* (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Student s = (Student) value;
		String output = "";
		if (s.getFirstName() != null && !s.getFirstName().isEmpty()) {
			output += "<b>" + s.getFirstName() + "</b>";
		}
		if (s.getMiddleName() != null && !s.getMiddleName().isEmpty()) {
			output += " <b>" + s.getMiddleName() + "</b>";
		}
		if (s.getLastName() != null && !s.getLastName().isEmpty()) {
			output += " <b>" + s.getLastName() + "</b>";
		}
		if (s.getBirthdate() != null) {
			output += "<br>&nbsp;&nbsp;&nbsp;&nbsp;Born: " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(s.getBirthdate());
		}
		output = "<html>" + output.trim() + "</html>";
		
		setContentType("text/html");
		setText(output);
		
		if (isSelected) {
			setBackground(Color.DARK_GRAY);
			setForeground(Color.WHITE);
		} else {
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}
		return this;
	}
}

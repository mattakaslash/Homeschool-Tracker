package ht.view.editor;

import ht.model.Subject;
import ht.view.SubjectChooser;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * Defines a subject cell editor for tables.
 *  
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class SubjectCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = -7440223913776357517L;
	
	/**
	 * The subject.
	 */
	private Subject _subject;
	
	/**
	 * The launcher.
	 */
	private JButton _button;
	
	/**
	 * The dialog.
	 */
	private SubjectChooser _dialog;
	
	/**
	 * Creates a new subject cell editor.
	 */
	public SubjectCellEditor() {
		setButton(new JButton());
		getButton().setActionCommand("edit");
		getButton().addActionListener(this);
		getButton().setBorderPainted(false);
		
		setDialog(new SubjectChooser());
	}

	/**
	 * @return the subject
	 */
	private Subject getSubject() {
		return _subject;
	}

	/**
	 * @param subject the subject to set
	 */
	private void setSubject(Subject subject) {
		_subject = subject;
	}

	/**
	 * @return the button
	 */
	private JButton getButton() {
		return _button;
	}

	/**
	 * @param button the button to set
	 */
	private void setButton(JButton button) {
		_button = button;
	}

	/**
	 * @return the dialog
	 */
	private SubjectChooser getDialog() {
		return _dialog;
	}

	/**
	 * @param dialog the dialog to set
	 */
	private void setDialog(SubjectChooser dialog) {
		_dialog = dialog;
	}

	@Override
	public Object getCellEditorValue() {
		return getSubject();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		setSubject((Subject) value);
		return getButton();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().contentEquals("edit")) {
			if (getSubject() != null) {
				getButton().setText(getSubject().getTitle());
			}
			getDialog().setSubject(getSubject());
			getDialog().setVisible(true);
			setSubject((getDialog()).getSubject());
			fireEditingStopped();
		}
	}
}

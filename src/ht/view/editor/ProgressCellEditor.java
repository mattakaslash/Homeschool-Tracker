package ht.view.editor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ht.model.Progress;
import ht.model.Subject;
import ht.view.ProgressSpinners;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * Defines a cell editor for {@link Progress}.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class ProgressCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 7873063228332436462L;
	
	/**
	 * The progress.
	 */
	private Progress _progress;

	/**
	 * The launcher.
	 */
	private JButton _button;
	
	/**
	 * The dialog.
	 */
	private ProgressSpinners _dialog;

	/**
	 * @return the progress
	 */
	private Progress getProgress() {
		return _progress;
	}

	/**
	 * @param progress the progress to set
	 */
	private void setProgress(Progress progress) {
		_progress = progress;
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
	private ProgressSpinners getDialog() {
		return _dialog;
	}

	/**
	 * @param dialog the dialog to set
	 */
	private void setDialog(ProgressSpinners dialog) {
		_dialog = dialog;
	}
	
	/**
	 * Creates a cell editor for modifying progress.
	 */
	public ProgressCellEditor() {
		setButton(new JButton());
		getButton().setActionCommand("edit");
		getButton().addActionListener(this);
		getButton().setBorderPainted(false);
		
		setDialog(new ProgressSpinners());
	}

	@Override
	public Object getCellEditorValue() {
		return getProgress();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		setProgress((Progress) value);
		return getButton();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().contentEquals("edit")) {
			if (getProgress() != null) {
				getButton().setText(getProgress().toString());
			}
			getDialog().setProgress(getProgress());
			getDialog().setVisible(true);
			setProgress(getDialog().getProgress());
			fireEditingStopped();
		}
	}

}

package ht.view;

import ht.model.Progress;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

/**
 * A simple dialog for setting completed units out of total units via spinners.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
//VS4E -- DO NOT REMOVE THIS LINE!
public class ProgressSpinners extends JDialog {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = -8360088186601572676L;
	private JLabel jLabelOutOf;
	private JSpinner jSpinnerCompleted;
	private JSpinner jSpinnerTotal;
	private JButton jButtonOK;
	private JButton jButtonCancel;
	private Progress _progress;

	/**
	 * Creates a default dialog.
	 */
	public ProgressSpinners() {
		initComponents();
	}

	/**
	 * Creates a dialog centered on its parent.
	 * @param parent the parent frame
	 */
	public ProgressSpinners(Frame parent) {
		super(parent);
		initComponents();
		setLocationRelativeTo(parent);
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent event) {
				windowWindowOpened(event);
			}
		});
	}

	private void initComponents() {
		setTitle("Set Progress");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.white);
		setForeground(Color.black);
		setLayout(new GroupLayout());
		setModal(true);
		add(getJLabelOutOf(), new Constraints(new Leading(82, 12, 12), new Leading(12, 20, 12, 12)));
		add(getJSpinnerCompleted(), new Constraints(new Leading(12, 58, 12, 12), new Leading(12, 12, 12)));
		add(getJSpinnerTotal(), new Constraints(new Leading(126, 66, 10, 10), new Leading(12, 12, 12)));
		add(getJButtonOK(), new Constraints(new Trailing(12, 12, 12), new Leading(38, 12, 12)));
		add(getJButtonCancel(), new Constraints(new Trailing(69, 12, 12), new Leading(38, 12, 12)));
		pack();
	}

	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
			jButtonCancel.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonCancelActionActionPerformed(event);
				}
			});
		}
		return jButtonCancel;
	}

	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("OK");
			jButtonOK.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonOKActionActionPerformed(event);
				}
			});
		}
		return jButtonOK;
	}

	private JSpinner getJSpinnerTotal() {
		if (jSpinnerTotal == null) {
			jSpinnerTotal = new JSpinner();
			jSpinnerTotal.setModel(new SpinnerNumberModel(1, 1, null, 1));
		}
		return jSpinnerTotal;
	}

	private JSpinner getJSpinnerCompleted() {
		if (jSpinnerCompleted == null) {
			jSpinnerCompleted = new JSpinner();
			jSpinnerCompleted.setModel(new SpinnerNumberModel(0, 0, null, 1));
		}
		return jSpinnerCompleted;
	}

	private JLabel getJLabelOutOf() {
		if (jLabelOutOf == null) {
			jLabelOutOf = new JLabel();
			jLabelOutOf.setText("out of");
		}
		return jLabelOutOf;
	}

	/**
	 * @return the progress
	 */
	public Progress getProgress() {
		return _progress;
	}
	
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Progress progress) {
		_progress = progress;
	}
	
	/**
	 * Event: Window opened.
	 * @param event
	 */
	private void windowWindowOpened(WindowEvent event) {
		if (getProgress() != null) {
			getJSpinnerCompleted().setValue(getProgress().getCompleted());
			getJSpinnerTotal().setValue(getProgress().getTotal());
		}
	}

	/**
	 * Event: Cancel button pressed.
	 * @param event
	 */
	private void jButtonCancelActionActionPerformed(ActionEvent event) {
		this.setVisible(false);
	}

	/**
	 * Event: OK button pressed.
	 * @param event
	 */
	private void jButtonOKActionActionPerformed(ActionEvent event) {
		getProgress().setCompleted((Integer) getJSpinnerCompleted().getValue());
		getProgress().setTotal((Integer) getJSpinnerTotal().getValue());
		this.setVisible(false);
	}
}

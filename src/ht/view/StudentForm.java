/**
 * 
 */
package ht.view;

import ht.model.Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;
import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

/**
 * Defines a form for adding or editing a student.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
//VS4E -- DO NOT REMOVE THIS LINE!
public class StudentForm extends JDialog {
	/**
	 * Date format for date text field.
	 */
	private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 3434490076734641503L;
	
	/**
	 * The student being added/edited.
	 */
	private Student _student;

	private JCalendarButton jButtonCalendar;
	private JButton jButtonCancel;
	private JButton jButtonSave;
	private JLabel jLabelBirthDate;
	private JLabel jLabelFirstName;
	private JLabel jLabelLastName;
	private JLabel jLabelMiddleName;
	private JTextField jTextFieldBirthDate;
	private JTextField jTextFieldFirstName;
	private JTextField jTextFieldLastName;
	private JTextField jTextFieldMiddleName;

	/**
	 * Creates a default student form.
	 */
	public StudentForm() {
		initComponents();
	}

	/**
	 * Creates a default student form.
	 * @param parent the parent component for this dialog
	 */
	public StudentForm(Frame parent) {
		super(parent);
		initComponents();
	}

	private JCalendarButton getJButtonCalendar() {
		if (jButtonCalendar == null) {
			jButtonCalendar = new JCalendarButton();
			jButtonCalendar.setDateParam("date");
			jButtonCalendar.addPropertyChangeListener(new PropertyChangeListener() {
	
				@Override
				public void propertyChange(PropertyChangeEvent event) {
					jButtonCalendarPropertyChangePropertyChange(event);
				}
			});
		}
		return jButtonCalendar;
	}

	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
			jButtonCancel.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonCancelActionActionPerformed(event);
				}
			});
		}
		return jButtonCancel;
	}

	private JButton getJButtonSave() {
		if (jButtonSave == null) {
			jButtonSave = new JButton();
			jButtonSave.setText("Save");
			jButtonSave.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonSaveActionActionPerformed(event);
				}
			});
		}
		return jButtonSave;
	}

	private JLabel getJLabelBirthDate() {
		if (jLabelBirthDate == null) {
			jLabelBirthDate = new JLabel();
			jLabelBirthDate.setHorizontalAlignment(SwingConstants.TRAILING);
			jLabelBirthDate.setText("Birth Date");
		}
		return jLabelBirthDate;
	}

	private JLabel getJLabelFirstName() {
		if (jLabelFirstName == null) {
			jLabelFirstName = new JLabel();
			jLabelFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
			jLabelFirstName.setText("First Name");
		}
		return jLabelFirstName;
	}

	private JLabel getJLabelLastName() {
		if (jLabelLastName == null) {
			jLabelLastName = new JLabel();
			jLabelLastName.setHorizontalAlignment(SwingConstants.TRAILING);
			jLabelLastName.setText("Last Name");
		}
		return jLabelLastName;
	}

	private JLabel getJLabelMiddleName() {
		if (jLabelMiddleName == null) {
			jLabelMiddleName = new JLabel();
			jLabelMiddleName.setHorizontalAlignment(SwingConstants.TRAILING);
			jLabelMiddleName.setText("Middle Name");
		}
		return jLabelMiddleName;
	}

	private JTextField getJTextFieldBirthDate() {
		if (jTextFieldBirthDate == null) {
			jTextFieldBirthDate = new JTextField();
			jTextFieldBirthDate.setEnabled(false);
		}
		return jTextFieldBirthDate;
	}

	private JTextField getJTextFieldFirstName() {
		if (jTextFieldFirstName == null) {
			jTextFieldFirstName = new JTextField();
		}
		return jTextFieldFirstName;
	}

	private JTextField getJTextFieldLastName() {
		if (jTextFieldLastName == null) {
			jTextFieldLastName = new JTextField();
		}
		return jTextFieldLastName;
	}

	private JTextField getJTextFieldMiddleName() {
		if (jTextFieldMiddleName == null) {
			jTextFieldMiddleName = new JTextField();
		}
		return jTextFieldMiddleName;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return _student;
	}

	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setModal(true);
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJLabelMiddleName(), new Constraints(new Leading(12, 89, 10, 10), new Leading(37, 12, 12)));
		add(getJLabelFirstName(), new Constraints(new Leading(12, 88, 34, 126), new Leading(12, 12, 12)));
		add(getJTextFieldFirstName(), new Constraints(new Bilateral(112, 12, 4), new Leading(10, 12, 12)));
		add(getJTextFieldMiddleName(), new Constraints(new Bilateral(112, 12, 4), new Leading(35, 12, 12)));
		add(getJTextFieldLastName(), new Constraints(new Bilateral(112, 12, 4), new Leading(60, 12, 12)));
		add(getJLabelLastName(), new Constraints(new Leading(12, 88, 28, 93), new Leading(62, 12, 12)));
		add(getJLabelBirthDate(), new Constraints(new Leading(12, 88, 56, 121), new Leading(88, 12, 12)));
		add(getJButtonCalendar(), new Constraints(new Trailing(12, 128, 263), new Leading(85, 12, 12)));
		add(getJTextFieldBirthDate(), new Constraints(new Bilateral(112, 40, 4), new Leading(86, 12, 12)));
		add(getJButtonCancel(), new Constraints(new Bilateral(112, 118, 75), new Leading(112, 12, 12)));
		add(getJButtonSave(), new Constraints(new Trailing(12, 100, 199, 199), new Leading(112, 12, 12)));
		addWindowListener(new WindowAdapter() {
	
			public void windowOpened(WindowEvent event) {
				windowWindowOpened(event);
			}
		});
		pack();
	}

	/**
	 * Event: JCalendarButton property changed.
	 * @param event
	 */
	private void jButtonCalendarPropertyChangePropertyChange(PropertyChangeEvent event) {
		if (event.getNewValue() instanceof Date) {
			String dateString = dateFormat.format((Date)event.getNewValue());
			getJTextFieldBirthDate().setText(dateString);
		}
	}

	/**
	 * Event: Cancel pressed.
	 * @param event
	 */
	private void jButtonCancelActionActionPerformed(ActionEvent event) {
		setStudent(null);
		this.setVisible(false);
	}

	/**
	 * Event: Save pressed.
	 * @param event
	 */
	private void jButtonSaveActionActionPerformed(ActionEvent event) {
		if (getStudent() == null) {
			setStudent(new Student());
		}
		getStudent().setFirstName(getJTextFieldFirstName().getText().trim());
		getStudent().setMiddleName(getJTextFieldMiddleName().getText().trim());
		getStudent().setLastName(getJTextFieldLastName().getText().trim());
		getStudent().setBirthdate(getJButtonCalendar().getTargetDate());
		this.setVisible(false);
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		_student = student;
	}

	/**
	 * Event: Window opened.
	 * @param event
	 */
	private void windowWindowOpened(WindowEvent event) {
		if (getStudent() != null) {
			getJTextFieldFirstName().setText(getStudent().getFirstName());
			getJTextFieldMiddleName().setText(getStudent().getMiddleName());
			getJTextFieldLastName().setText(getStudent().getLastName());
			getJButtonCalendar().setTargetDate(getStudent().getBirthdate());
			jButtonCalendarPropertyChangePropertyChange(new PropertyChangeEvent(this, null, null, getStudent().getBirthdate()));
		}
	}
}

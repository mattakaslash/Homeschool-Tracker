package ht.view;

import ht.model.Student;
import ht.view.render.StudentCellRenderer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

/**
 * Defines the main frame of the application.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
//VS4E -- DO NOT REMOVE THIS LINE!
public class MainFrame extends JFrame {
	/**
	 * Generated. 
	 */
	private static final long serialVersionUID = 8444716793871398441L;
	
	private JButton jButtonStudentsAdd;
	private JButton jButtonStudentsDelete;
	private JButton jButtonStudentsEdit;
	private JButton jButtonStudentsOpen;
	private JLabel jLabelStatus;
	private JList jListStudentList;
	private JMenuBar jMenuBarMain;
	private JMenu jMenuFile;
	private JMenuItem jMenuItemFileExit;
	private JPanel jPanelStudents;
	private JScrollPane jScrollPaneStudentList;
	private JTabbedPane jTabbedPaneTabs;

	/**
	 * Defines a new frame.
	 */
	public MainFrame() {
		initComponents();
	}

	private JButton getJButtonStudentsAdd() {
		if (jButtonStudentsAdd == null) {
			jButtonStudentsAdd = new JButton();
			jButtonStudentsAdd.setText("Add");
			jButtonStudentsAdd.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonStudentsAddActionActionPerformed(event);
				}
			});
		}
		return jButtonStudentsAdd;
	}

	private JButton getJButtonStudentsDelete() {
		if (jButtonStudentsDelete == null) {
			jButtonStudentsDelete = new JButton();
			jButtonStudentsDelete.setText("Delete");
			jButtonStudentsDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonStudentsDeleteActionActionPerformed(event);
				}
			});
		}
		return jButtonStudentsDelete;
	}

	private JButton getJButtonStudentsEdit() {
		if (jButtonStudentsEdit == null) {
			jButtonStudentsEdit = new JButton();
			jButtonStudentsEdit.setText("Edit");
			jButtonStudentsEdit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonStudentsEditActionActionPerformed(event);
				}
			});
		}
		return jButtonStudentsEdit;
	}

	private JButton getJButtonStudentsOpen() {
		if (jButtonStudentsOpen == null) {
			jButtonStudentsOpen = new JButton();
			jButtonStudentsOpen.setText("Open");
		}
		return jButtonStudentsOpen;
	}

	private JLabel getJLabelStatus() {
		if (jLabelStatus == null) {
			jLabelStatus = new JLabel();
		}
		return jLabelStatus;
	}

	private JList getJListStudentList() {
		if (jListStudentList == null) {
			jListStudentList = new JList();
			DefaultListModel listModel = new DefaultListModel();
			jListStudentList.setModel(listModel);
			jListStudentList.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jListStudentListMouseMouseClicked(event);
				}
			});
		}
		return jListStudentList;
	}

	private JMenuBar getJMenuBarMain() {
		if (jMenuBarMain == null) {
			jMenuBarMain = new JMenuBar();
			jMenuBarMain.add(getJMenuFile());
		}
		return jMenuBarMain;
	}

	private JMenu getJMenuFile() {
		if (jMenuFile == null) {
			jMenuFile = new JMenu();
			jMenuFile.setText("File");
			jMenuFile.setMnemonic('F');
			jMenuFile.add(getJMenuItemFileExit());
		}
		return jMenuFile;
	}

	private JMenuItem getJMenuItemFileExit() {
		if (jMenuItemFileExit == null) {
			jMenuItemFileExit = new JMenuItem();
			jMenuItemFileExit.setText("Exit");
			jMenuItemFileExit.setMnemonic('X');
			jMenuItemFileExit.setAccelerator(KeyStroke.getKeyStroke("alt pressed F4"));
			jMenuItemFileExit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					jMenuItemFileExitActionActionPerformed(event);
				}
			});
		}
		return jMenuItemFileExit;
	}

	private JPanel getJPanelStudents() {
		if (jPanelStudents == null) {
			jPanelStudents = new JPanel();
			jPanelStudents.setLayout(new GroupLayout());
			jPanelStudents.add(getJButtonStudentsEdit(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(74, 12, 12)));
			jPanelStudents.add(getJButtonStudentsOpen(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(43, 12, 12)));
			jPanelStudents.add(getJButtonStudentsDelete(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(105, 12, 12)));
			jPanelStudents.add(getJButtonStudentsAdd(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(12, 12, 12)));
			jPanelStudents.add(getJScrollPaneStudentList(), new Constraints(new Bilateral(12, 110, 22), new Bilateral(13, 12, 22)));
			jPanelStudents.addComponentListener(new ComponentAdapter() {
	
				public void componentShown(ComponentEvent event) {
					jPanelStudentsComponentComponentShown(event);
				}
			});
		}
		return jPanelStudents;
	}

	private JScrollPane getJScrollPaneStudentList() {
		if (jScrollPaneStudentList == null) {
			jScrollPaneStudentList = new JScrollPane();
			jScrollPaneStudentList.setViewportView(getJListStudentList());
		}
		return jScrollPaneStudentList;
	}

	private JTabbedPane getJTabbedPaneTabs() {
		if (jTabbedPaneTabs == null) {
			jTabbedPaneTabs = new JTabbedPane();
			jTabbedPaneTabs.addTab("Students", getJPanelStudents());
		}
		return jTabbedPaneTabs;
	}

	private void initComponents() {
		setTitle("Homeschool Tracker");
		add(getJLabelStatus(), BorderLayout.SOUTH);
		add(getJTabbedPaneTabs(), BorderLayout.CENTER);
		setJMenuBar(getJMenuBarMain());
		setSize(800, 600);
	}

	/**
	 * Event: File > Exit clicked.
	 * @param event
	 */
	private void jMenuItemFileExitActionActionPerformed(ActionEvent event) {
		this.dispose();
	}

	/**
	 * Event: Students tab, Add pressed.
	 * @param event
	 */
	private void jButtonStudentsAddActionActionPerformed(ActionEvent event) {
		StudentForm form = new StudentForm(this);
		form.setVisible(true);
		if (form.getStudent() != null) {
			Student.save(form.getStudent());
			refreshStudentList();
		}
		form.dispose();
	}

	/**
	 * Event: Students tab, Delete pressed.
	 * @param event
	 */
	private void jButtonStudentsDeleteActionActionPerformed(ActionEvent event) {
		String output = "";
		List<Student> toDelete = new ArrayList<Student>();
		for (Object s : getJListStudentList().getSelectedValues()) {
			output += ((Student) s).toString() + "\n";
			toDelete.add((Student) s);
		}
		int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the following students?\n\n" + output.trim(),
				"Delete students?", JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION) {
			for (Object s : getJListStudentList().getSelectedValues()) {
				Student.remove((Student) s);
			}
			refreshStudentList();
		}
	}

	/**
	 * Event: Students tab, Edit pressed.
	 * @param event
	 */
	private void jButtonStudentsEditActionActionPerformed(ActionEvent event) {
		Student s = (Student) getJListStudentList().getSelectedValue();
		StudentForm form = new StudentForm(this);
		form.setStudent(s);
		form.setVisible(true);
		if (form.getStudent() != null) {
			Student.save(form.getStudent());
			refreshStudentList();
		}
		form.dispose();
	}

	/**
	 * Event: Students tab selected.
	 * @param event
	 */
	private void jPanelStudentsComponentComponentShown(ComponentEvent event) {
		refreshStudentList();
	}

	/**
	 * Reloads the list of students from the database.
	 */
	private void refreshStudentList() {
		getJListStudentList().setCellRenderer(new StudentCellRenderer());
		((DefaultListModel) getJListStudentList().getModel()).clear();
		for (Student s : Student.getAll()) {
			((DefaultListModel) getJListStudentList().getModel()).addElement(s);
		}
	}

	/**
	 * Event: Student list, mouse clicked.
	 * @param event
	 */
	private void jListStudentListMouseMouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			getJButtonStudentsEdit().doClick();
		}
	}
}
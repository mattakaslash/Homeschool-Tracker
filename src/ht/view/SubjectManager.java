package ht.view;

import ht.model.swing.SubjectsTreeModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 * Provides an interface for managing the system's hierarchy of subjects.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
//VS4E -- DO NOT REMOVE THIS LINE!
public class SubjectManager extends JDialog {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = -2470705175032575109L;
	private JTree jTreeSubjects;
	private JScrollPane jScrollPaneSubjects;
	private JPanel jPanelControls;
	private static final TreeModel subjectsTreeModel = new SubjectsTreeModel();
	private JTextField jTextFieldSubjectTitle;
	private JButton jButtonSaveAll;

	/**
	 * Creates a default, parent-less dialog.
	 */
	public SubjectManager() {
		initComponents();
	}

	/**
	 * Creates a dialog 
	 * @param parent
	 */
	public SubjectManager(Frame parent) {
		super(parent);
		initComponents();
		setLocationRelativeTo(parent);
	}

	private void initComponents() {
		setTitle("Subject Manager");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.white);
		setModal(true);
		setForeground(Color.black);
		add(getJScrollPaneSubjects(), BorderLayout.CENTER);
		add(getJPanelControls(), BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
	
			public void windowOpened(WindowEvent event) {
				windowWindowOpened(event);
			}
		});
		setSize(480, 320);
	}

	private JButton getJButtonSaveAll() {
		if (jButtonSaveAll == null) {
			jButtonSaveAll = new JButton();
			jButtonSaveAll.setText("Save All");
		}
		return jButtonSaveAll;
	}

	private JTextField getJTextFieldSubjectTitle() {
		if (jTextFieldSubjectTitle == null) {
			jTextFieldSubjectTitle = new JTextField();
		}
		return jTextFieldSubjectTitle;
	}

	private JPanel getJPanelControls() {
		if (jPanelControls == null) {
			jPanelControls = new JPanel();
			jPanelControls.setLayout(new BorderLayout());
			jPanelControls.add(getJTextFieldSubjectTitle(), BorderLayout.CENTER);
			jPanelControls.add(getJButtonSaveAll(), BorderLayout.EAST);
		}
		return jPanelControls;
	}

	private JScrollPane getJScrollPaneSubjects() {
		if (jScrollPaneSubjects == null) {
			jScrollPaneSubjects = new JScrollPane();
			jScrollPaneSubjects.setViewportView(getJTreeSubjects());
		}
		return jScrollPaneSubjects;
	}

	private JTree getJTreeSubjects() {
		if (jTreeSubjects == null) {
			jTreeSubjects = new JTree();
			DefaultTreeModel treeModel = null;
			DefaultMutableTreeNode node0 = new DefaultMutableTreeNode("Subjects");
			treeModel = new DefaultTreeModel(node0);
			jTreeSubjects.setModel(treeModel);
		}
		return jTreeSubjects;
	}

	private void windowWindowOpened(WindowEvent event) {
		getJTreeSubjects().setModel(subjectsTreeModel);
		getJTreeSubjects().repaint();
	}
}

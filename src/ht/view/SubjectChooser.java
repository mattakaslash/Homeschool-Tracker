package ht.view;

import ht.model.Subject;
import ht.model.swing.SubjectsTreeModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 * Provides an interface for selecting a subject.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
// VS4E -- DO NOT REMOVE THIS LINE!
public class SubjectChooser extends JDialog {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 973611062154218997L;

	/**
	 * The tree model used for the subjects tree.
	 */
	private static final TreeModel subjectsTreeModel = new SubjectsTreeModel();

	/**
	 * The chosen subject.
	 */
	private Subject _subject;

	private JScrollPane jScrollPaneSubjects;
	private JTree jTreeSubjects;

	/**
	 * Creates a default, parent-less dialog.
	 */
	public SubjectChooser() {
		initComponents();
	}

	/**
	 * Creates a dialog
	 * 
	 * @param parent
	 */
	public SubjectChooser(Frame parent) {
		super(parent);
		initComponents();
		setLocationRelativeTo(parent);
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
			{
				DefaultMutableTreeNode node0 = new DefaultMutableTreeNode("Subjects");
				treeModel = new DefaultTreeModel(node0);
			}
			jTreeSubjects.setModel(treeModel);
			jTreeSubjects.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			jTreeSubjects.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent event) {
					jTreeSubjectsMouseMouseClicked(event);
				}
			});
		}
		return jTreeSubjects;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return _subject;
	}

	private void initComponents() {
		setTitle("Subject Chooser");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.white);
		setModal(true);
		setForeground(Color.black);
		add(getJScrollPaneSubjects(), BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent event) {
				windowWindowOpened(event);
			}
		});
		setSize(480, 320);
	}

	/**
	 * Event: Subjects tree, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTreeSubjectsMouseMouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2 && getJTreeSubjects().getSelectionCount() > 0) {
			Object selected = getJTreeSubjects().getSelectionPath().getLastPathComponent();
			if (selected instanceof Subject) {
				setSubject((Subject) selected);
			} else {
				setSubject(null);
			}
			this.setVisible(false);
		}
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(Subject subject) {
		_subject = subject;
	}

	/**
	 * Event: Window opened.
	 * 
	 * @param event
	 */
	private void windowWindowOpened(WindowEvent event) {
		getJTreeSubjects().setModel(subjectsTreeModel);
	}
}

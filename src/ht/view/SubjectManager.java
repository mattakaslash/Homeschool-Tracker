package ht.view;

import ht.model.Subject;
import ht.model.swing.SubjectsTreeModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

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
	private static final TreeModel subjectsTreeModel = new SubjectsTreeModel();
	private JButton jButtonSave;
	private JMenuItem jMenuItemSubjectsDelete;
	private JMenuItem jMenuItemSubjectsNew;
	private JPanel jPanelControls;
	private JPopupMenu jPopupMenuSubjects;
	private JScrollPane jScrollPaneSubjects;
	private JTextField jTextFieldSubjectTitle;
	private JTree jTreeSubjects;

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

	private JButton getJButtonSave() {
		if (jButtonSave == null) {
			jButtonSave = new JButton();
			jButtonSave.setText("Save");
			jButtonSave.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonSaveActionActionPerformed(event);
				}
			});
		}
		return jButtonSave;
	}

	private JMenuItem getJMenuItemSubjectsDelete() {
		if (jMenuItemSubjectsDelete == null) {
			jMenuItemSubjectsDelete = new JMenuItem();
			jMenuItemSubjectsDelete.setText("Delete");
			jMenuItemSubjectsDelete.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jMenuItemSubjectsDeleteActionActionPerformed(event);
				}
			});
		}
		return jMenuItemSubjectsDelete;
	}

	private JMenuItem getJMenuItemSubjectsNew() {
		if (jMenuItemSubjectsNew == null) {
			jMenuItemSubjectsNew = new JMenuItem();
			jMenuItemSubjectsNew.setText("New");
			jMenuItemSubjectsNew.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jMenuItemSubjectsNewActionActionPerformed(event);
				}
			});
		}
		return jMenuItemSubjectsNew;
	}

	private JPanel getJPanelControls() {
		if (jPanelControls == null) {
			jPanelControls = new JPanel();
			jPanelControls.setLayout(new BorderLayout());
			jPanelControls.add(getJTextFieldSubjectTitle(), BorderLayout.CENTER);
			jPanelControls.add(getJButtonSave(), BorderLayout.EAST);
		}
		return jPanelControls;
	}

	private JPopupMenu getJPopupMenuSubjects() {
		if (jPopupMenuSubjects == null) {
			jPopupMenuSubjects = new JPopupMenu();
			jPopupMenuSubjects.add(getJMenuItemSubjectsNew());
			jPopupMenuSubjects.add(getJMenuItemSubjectsDelete());
		}
		return jPopupMenuSubjects;
	}

	private JScrollPane getJScrollPaneSubjects() {
		if (jScrollPaneSubjects == null) {
			jScrollPaneSubjects = new JScrollPane();
			jScrollPaneSubjects.setViewportView(getJTreeSubjects());
		}
		return jScrollPaneSubjects;
	}

	private JTextField getJTextFieldSubjectTitle() {
		if (jTextFieldSubjectTitle == null) {
			jTextFieldSubjectTitle = new JTextField();
			jTextFieldSubjectTitle.addKeyListener(new KeyAdapter() {
	
				public void keyPressed(KeyEvent event) {
					jTextFieldSubjectTitleKeyKeyPressed(event);
				}
			});
		}
		return jTextFieldSubjectTitle;
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
			jTreeSubjects.setComponentPopupMenu(getJPopupMenuSubjects());
			jTreeSubjects.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			jTreeSubjects.addTreeSelectionListener(new TreeSelectionListener() {
	
				public void valueChanged(TreeSelectionEvent event) {
					jTreeSubjectsTreeSelectionValueChanged(event);
				}
			});
			jTreeSubjects.addKeyListener(new KeyAdapter() {
	
				public void keyPressed(KeyEvent event) {
					jTreeSubjectsKeyKeyPressed(event);
				}
			});
		}
		return jTreeSubjects;
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

	/**
	 * Event: Save button pressed.
	 * @param event
	 */
	private void jButtonSaveActionActionPerformed(ActionEvent event) {
		if (getJTreeSubjects().getSelectionCount() > 0) {
			TreePath path = getJTreeSubjects().getSelectionPath();
			Subject s = (Subject) path.getLastPathComponent();
			s.setTitle(getJTextFieldSubjectTitle().getText().trim());
			Subject.save(s);
			((SubjectsTreeModel) getJTreeSubjects().getModel()).treeChanged(path);
			getJTreeSubjects().expandPath(path);
			getJTreeSubjects().clearSelection();
		}
	}

	/**
	 * Event: Subjects menu, delete clicked.
	 * @param event
	 */
	private void jMenuItemSubjectsDeleteActionActionPerformed(ActionEvent event) {
		if (getJTreeSubjects().getSelectionCount() > 0) {
			TreePath path = getJTreeSubjects().getSelectionPath();
			if (((Subject) path.getLastPathComponent()).getId() != 1) {
				if (!getJTreeSubjects().getModel().isLeaf(path.getLastPathComponent())) {
					JOptionPane.showMessageDialog(this,
							"Only leaf subjects can be deleted. Delete all child subjects before deleting this one.",
							"Invalid Action", JOptionPane.ERROR_MESSAGE);
				} else {
					int n = JOptionPane.showConfirmDialog(this, "Delete " + (Subject) path.getLastPathComponent() + "?",
							"Delete subject?", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						Subject.remove((Subject) path.getLastPathComponent());
						((SubjectsTreeModel) getJTreeSubjects().getModel()).treeChanged(path.getParentPath());
						getJTreeSubjects().clearSelection();
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Root of subjects tree cannot be deleted.", "Invalid Action",
						JOptionPane.ERROR_MESSAGE);
			}
		}		
	}

	/**
	 * Event: Subjects menu, new clicked.
	 * @param event
	 */
	private void jMenuItemSubjectsNewActionActionPerformed(ActionEvent event) {
		if (getJTreeSubjects().getSelectionCount() > 0) {
			TreePath path = getJTreeSubjects().getSelectionPath();
			Subject.save(new Subject("new subject", (Subject) path.getLastPathComponent()));
			((SubjectsTreeModel) getJTreeSubjects().getModel()).treeChanged(path);
			getJTreeSubjects().expandPath(path);
			getJTreeSubjects().clearSelection();
		}
	}

	private void jTreeSubjectsTreeSelectionValueChanged(TreeSelectionEvent event) {
		if (getJTreeSubjects().getSelectionCount() > 0) {
			getJTextFieldSubjectTitle().setEnabled(true);
			getJTextFieldSubjectTitle()
					.setText(((Subject) getJTreeSubjects().getSelectionPath().getLastPathComponent()).getTitle());
		} else {
			getJTextFieldSubjectTitle().setEnabled(false);
			getJTextFieldSubjectTitle().setText("");
		}
	}

	/**
	 * Event: Window opened.
	 * @param event
	 */
	private void windowWindowOpened(WindowEvent event) {
		getJTreeSubjects().setModel(subjectsTreeModel);
	}

	/**
	 * Event: Subjects, key pressed.
	 * @param event
	 */
	private void jTreeSubjectsKeyKeyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_DELETE) {
			jMenuItemSubjectsDeleteActionActionPerformed(null);
			event.consume();
		}
	}

	/**
	 * Event: Subject title text field, key pressed.
	 * @param event
	 */
	private void jTextFieldSubjectTitleKeyKeyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			getJButtonSave().doClick();
			event.consume();
		}
	}
}

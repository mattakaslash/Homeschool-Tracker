package ht.view;

import ht.model.MonthTableModel;
import ht.model.Student;
import ht.view.render.StudentCellRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

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
	
	/**
	 * Stores the currently-selected student from the students tab.
	 */
	private Student _selectedStudent = null;
	
	/**
	 * Stores the currently selected year from the year tab.
	 */
	private Integer _selectedYear = Calendar.getInstance().get(Calendar.YEAR);
	
	private JButton jButtonNextYear;
	private JButton jButtonPrevYear;
	private JButton jButtonStudentsAdd;
	private JButton jButtonStudentsDelete;
	private JButton jButtonStudentsEdit;
	private JButton jButtonStudentsOpen;
	private JLabel jLabelApril;
	private JLabel jLabelAugust;
	private JLabel jLabelDecember;
	private JLabel jLabelFebruary;
	private JLabel jLabelJanuary;
	private JLabel jLabelJuly;
	private JLabel jLabelJune;
	private JLabel jLabelMarch;
	private JLabel jLabelMay;
	private JLabel jLabelNovember;
	private JLabel jLabelOctober;
	private JLabel jLabelSeptember;
	private JLabel jLabelStatus;
	private JLabel jLabelYear;
	private JList jListStudentList;
	private JMenuBar jMenuBarMain;
	private JMenu jMenuFile;
	private JMenuItem jMenuItemFileExit;
	private JPanel jPanelStudents;
	private JPanel jPanelYear;
	private JScrollPane jScrollPaneApril;
	private JScrollPane jScrollPaneAugust;
	private JScrollPane jScrollPaneDecember;
	private JScrollPane jScrollPaneFebruary;
	private JScrollPane jScrollPaneJanuary;
	private JScrollPane jScrollPaneJuly;
	private JScrollPane jScrollPaneJune;
	private JScrollPane jScrollPaneMarch;
	private JScrollPane jScrollPaneMay;
	private JScrollPane jScrollPaneNovember;
	private JScrollPane jScrollPaneOctober;
	private JScrollPane jScrollPaneSeptember;
	private JScrollPane jScrollPaneStudentList;
	private JTabbedPane jTabbedPaneTabs;
	private JTable jTableApril;
	private JTable jTableAugust;
	private JTable jTableDecember;
	private JTable jTableFebruary;
	private JTable jTableJanuary;
	private JTable jTableJuly;
	private JTable jTableJune;
	private JTable jTableMarch;
	private JTable jTableMay;
	private JTable jTableNovember;
	private JTable jTableOctober;
	private JTable jTableSeptember;

	private JPanel jPanelYearPicker;

	/**
	 * Defines a new frame.
	 */
	public MainFrame() {
		initComponents();
	}

	private JButton getJButtonNextYear() {
		if (jButtonNextYear == null) {
			jButtonNextYear = new JButton();
			jButtonNextYear.setText(">");
			jButtonNextYear.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonNextYearActionActionPerformed(event);
				}
			});
		}
		return jButtonNextYear;
	}

	private JButton getJButtonPrevYear() {
		if (jButtonPrevYear == null) {
			jButtonPrevYear = new JButton();
			jButtonPrevYear.setText("<");
			jButtonPrevYear.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonPrevYearActionActionPerformed(event);
				}
			});
		}
		return jButtonPrevYear;
	}

	private JButton getJButtonStudentsAdd() {
		if (jButtonStudentsAdd == null) {
			jButtonStudentsAdd = new JButton();
			jButtonStudentsAdd.setText("Add");
			jButtonStudentsAdd.addActionListener(new ActionListener() {
	
				@Override
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
			jButtonStudentsOpen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonStudentsOpenActionActionPerformed(event);
				}
			});
		}
		return jButtonStudentsOpen;
	}

	private JLabel getJLabelApril() {
		if (jLabelApril == null) {
			jLabelApril = new JLabel();
			jLabelApril.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelApril.setText("April");
		}
		return jLabelApril;
	}

	private JLabel getJLabelAugust() {
		if (jLabelAugust == null) {
			jLabelAugust = new JLabel();
			jLabelAugust.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelAugust.setText("August");
		}
		return jLabelAugust;
	}

	private JLabel getJLabelDecember() {
		if (jLabelDecember == null) {
			jLabelDecember = new JLabel();
			jLabelDecember.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelDecember.setText("December");
		}
		return jLabelDecember;
	}

	private JLabel getJLabelFebruary() {
		if (jLabelFebruary == null) {
			jLabelFebruary = new JLabel();
			jLabelFebruary.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelFebruary.setText("February");
		}
		return jLabelFebruary;
	}

	private JLabel getJLabelJanuary() {
		if (jLabelJanuary == null) {
			jLabelJanuary = new JLabel();
			jLabelJanuary.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelJanuary.setText("January");
		}
		return jLabelJanuary;
	}

	private JLabel getJLabelJuly() {
		if (jLabelJuly == null) {
			jLabelJuly = new JLabel();
			jLabelJuly.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelJuly.setText("July");
		}
		return jLabelJuly;
	}

	private JLabel getJLabelJune() {
		if (jLabelJune == null) {
			jLabelJune = new JLabel();
			jLabelJune.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelJune.setText("June");
		}
		return jLabelJune;
	}

	private JLabel getJLabelMarch() {
		if (jLabelMarch == null) {
			jLabelMarch = new JLabel();
			jLabelMarch.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelMarch.setText("March");
		}
		return jLabelMarch;
	}

	private JLabel getJLabelMay() {
		if (jLabelMay == null) {
			jLabelMay = new JLabel();
			jLabelMay.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelMay.setText("May");
		}
		return jLabelMay;
	}

	private JLabel getJLabelNovember() {
		if (jLabelNovember == null) {
			jLabelNovember = new JLabel();
			jLabelNovember.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelNovember.setText("November");
		}
		return jLabelNovember;
	}

	private JLabel getJLabelOctober() {
		if (jLabelOctober == null) {
			jLabelOctober = new JLabel();
			jLabelOctober.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelOctober.setText("October");
		}
		return jLabelOctober;
	}

	private JLabel getJLabelSeptember() {
		if (jLabelSeptember == null) {
			jLabelSeptember = new JLabel();
			jLabelSeptember.setText("September");
			jLabelSeptember.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelSeptember;
	}

	private JLabel getJLabelStatus() {
		if (jLabelStatus == null) {
			jLabelStatus = new JLabel();
		}
		return jLabelStatus;
	}

	private JLabel getJLabelYear() {
		if (jLabelYear == null) {
			jLabelYear = new JLabel();
			jLabelYear.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabelYear.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelYear.setText("0000");
		}
		return jLabelYear;
	}

	private JList getJListStudentList() {
		if (jListStudentList == null) {
			jListStudentList = new JList();
			DefaultListModel listModel = new DefaultListModel();
			jListStudentList.setModel(listModel);
			jListStudentList.addMouseListener(new MouseAdapter() {
	
				@Override
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
	
				@Override
				public void componentShown(ComponentEvent event) {
					jPanelStudentsComponentComponentShown(event);
				}
			});
		}
		return jPanelStudents;
	}

	private JPanel getJPanelYear() {
		if (jPanelYear == null) {
			jPanelYear = new JPanel();
			jPanelYear.setLayout(new GroupLayout());
			jPanelYear.add(getJLabelJune(), new Constraints(new Leading(12, 202, 12, 12), new Leading(42, 12, 12)));
			jPanelYear.add(getJLabelJuly(), new Constraints(new Leading(12, 202, 12, 12), new Leading(185, 12, 12)));
			jPanelYear.add(getJLabelAugust(), new Constraints(new Leading(12, 202, 12, 12), new Leading(327, 12, 12)));
			jPanelYear.add(getJLabelSeptember(), new Constraints(new Leading(12, 202, 12, 12), new Leading(469, 12, 12)));
			jPanelYear.add(getJLabelOctober(), new Constraints(new Leading(220, 200, 12, 12), new Leading(42, 12, 12)));
			jPanelYear.add(getJLabelNovember(), new Constraints(new Leading(220, 200, 12, 12), new Leading(185, 12, 12)));
			jPanelYear.add(getJLabelDecember(), new Constraints(new Leading(220, 200, 12, 12), new Leading(327, 12, 12)));
			jPanelYear.add(getJLabelJanuary(), new Constraints(new Leading(220, 200, 12, 12), new Leading(469, 12, 12)));
			jPanelYear.add(getJLabelFebruary(), new Constraints(new Leading(428, 200, 12, 12), new Leading(42, 12, 12)));
			jPanelYear.add(getJLabelMarch(), new Constraints(new Leading(428, 200, 12, 12), new Leading(185, 12, 12)));
			jPanelYear.add(getJLabelApril(), new Constraints(new Leading(428, 200, 12, 12), new Leading(327, 12, 12)));
			jPanelYear.add(getJLabelMay(), new Constraints(new Leading(428, 200, 12, 12), new Leading(469, 12, 12)));
			jPanelYear.add(getJScrollPaneJune(), new Constraints(new Leading(13, 200, 10, 10), new Leading(64, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneJuly(), new Constraints(new Leading(13, 200, 10, 10), new Leading(206, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneAugust(), new Constraints(new Leading(13, 200, 10, 10), new Leading(348, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneSeptember(), new Constraints(new Leading(13, 200, 10, 10), new Leading(490, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneOctober(), new Constraints(new Leading(220, 200, 10, 10), new Leading(64, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneNovember(), new Constraints(new Leading(220, 200, 10, 10), new Leading(206, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneDecember(), new Constraints(new Leading(220, 200, 10, 10), new Leading(348, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneJanuary(), new Constraints(new Leading(220, 200, 10, 10), new Leading(490, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneFebruary(), new Constraints(new Leading(427, 200, 10, 10), new Leading(64, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneMarch(), new Constraints(new Leading(427, 200, 10, 10), new Leading(206, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneApril(), new Constraints(new Leading(427, 200, 10, 10), new Leading(348, 115, 12, 12)));
			jPanelYear.add(getJScrollPaneMay(), new Constraints(new Leading(427, 200, 10, 10), new Leading(490, 115, 12, 12)));
			jPanelYear.add(getJPanelYearPicker(), new Constraints(new Leading(12, 616, 12, 12), new Leading(0, 44, 12, 12)));
			jPanelYear.addComponentListener(new ComponentAdapter() {
	
				public void componentShown(ComponentEvent event) {
					jPanelYearComponentComponentShown(event);
				}
			});
		}
		return jPanelYear;
	}

	private JScrollPane getJScrollPaneApril() {
		if (jScrollPaneApril == null) {
			jScrollPaneApril = new JScrollPane();
			jScrollPaneApril.setViewportView(getJTableApril());
		}
		return jScrollPaneApril;
	}

	private JScrollPane getJScrollPaneAugust() {
		if (jScrollPaneAugust == null) {
			jScrollPaneAugust = new JScrollPane();
			jScrollPaneAugust.setViewportView(getJTableAugust());
		}
		return jScrollPaneAugust;
	}

	private JScrollPane getJScrollPaneDecember() {
		if (jScrollPaneDecember == null) {
			jScrollPaneDecember = new JScrollPane();
			jScrollPaneDecember.setViewportView(getJTableDecember());
		}
		return jScrollPaneDecember;
	}

	private JScrollPane getJScrollPaneFebruary() {
		if (jScrollPaneFebruary == null) {
			jScrollPaneFebruary = new JScrollPane();
			jScrollPaneFebruary.setViewportView(getJTableFebruary());
		}
		return jScrollPaneFebruary;
	}

	private JScrollPane getJScrollPaneJanuary() {
		if (jScrollPaneJanuary == null) {
			jScrollPaneJanuary = new JScrollPane();
			jScrollPaneJanuary.setViewportView(getJTableJanuary());
		}
		return jScrollPaneJanuary;
	}

	private JScrollPane getJScrollPaneJuly() {
		if (jScrollPaneJuly == null) {
			jScrollPaneJuly = new JScrollPane();
			jScrollPaneJuly.setViewportView(getJTableJuly());
		}
		return jScrollPaneJuly;
	}

	private JScrollPane getJScrollPaneJune() {
		if (jScrollPaneJune == null) {
			jScrollPaneJune = new JScrollPane();
			jScrollPaneJune.setViewportView(getJTableJune());
		}
		return jScrollPaneJune;
	}

	private JScrollPane getJScrollPaneMarch() {
		if (jScrollPaneMarch == null) {
			jScrollPaneMarch = new JScrollPane();
			jScrollPaneMarch.setViewportView(getJTableMarch());
		}
		return jScrollPaneMarch;
	}

	private JScrollPane getJScrollPaneMay() {
		if (jScrollPaneMay == null) {
			jScrollPaneMay = new JScrollPane();
			jScrollPaneMay.setViewportView(getJTableMay());
		}
		return jScrollPaneMay;
	}

	private JScrollPane getJScrollPaneNovember() {
		if (jScrollPaneNovember == null) {
			jScrollPaneNovember = new JScrollPane();
			jScrollPaneNovember.setViewportView(getJTableNovember());
		}
		return jScrollPaneNovember;
	}

	private JScrollPane getJScrollPaneOctober() {
		if (jScrollPaneOctober == null) {
			jScrollPaneOctober = new JScrollPane();
			jScrollPaneOctober.setViewportView(getJTableOctober());
		}
		return jScrollPaneOctober;
	}

	private JScrollPane getJScrollPaneSeptember() {
		if (jScrollPaneSeptember == null) {
			jScrollPaneSeptember = new JScrollPane();
			jScrollPaneSeptember.setViewportView(getJTableSeptember());
		}
		return jScrollPaneSeptember;
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
			jTabbedPaneTabs.addTab("Year", getJPanelYear());
		}
		return jTabbedPaneTabs;
	}

	private JTable getJTableApril() {
		if (jTableApril == null) {
			jTableApril = new JTable();
			jTableApril.setModel(new MonthTableModel(4, getSelectedYear()));
			jTableApril.setRowSelectionAllowed(false);
			jTableApril.setShowHorizontalLines(false);
			jTableApril.setShowVerticalLines(false);
		}
		return jTableApril;
	}

	private JTable getJTableAugust() {
		if (jTableAugust == null) {
			jTableAugust = new JTable();
			jTableAugust.setModel(new MonthTableModel(8, getSelectedYear()));
			jTableAugust.setRowSelectionAllowed(false);
			jTableAugust.setShowHorizontalLines(false);
			jTableAugust.setShowVerticalLines(false);
		}
		return jTableAugust;
	}

	private JTable getJTableDecember() {
		if (jTableDecember == null) {
			jTableDecember = new JTable();
			jTableDecember.setModel(new MonthTableModel(12, getSelectedYear()));
			jTableDecember.setRowSelectionAllowed(false);
			jTableDecember.setShowHorizontalLines(false);
			jTableDecember.setShowVerticalLines(false);
		}
		return jTableDecember;
	}

	private JTable getJTableFebruary() {
		if (jTableFebruary == null) {
			jTableFebruary = new JTable();
			jTableFebruary.setModel(new MonthTableModel(2, getSelectedYear() + 1));
			jTableFebruary.setRowSelectionAllowed(false);
			jTableFebruary.setShowHorizontalLines(false);
			jTableFebruary.setShowVerticalLines(false);
		}
		return jTableFebruary;
	}

	private JTable getJTableJanuary() {
		if (jTableJanuary == null) {
			jTableJanuary = new JTable();
			jTableJanuary.setModel(new MonthTableModel(1, getSelectedYear() + 1));
			jTableJanuary.setRowSelectionAllowed(false);
			jTableJanuary.setShowHorizontalLines(false);
			jTableJanuary.setShowVerticalLines(false);
		}
		return jTableJanuary;
	}

	private JTable getJTableJuly() {
		if (jTableJuly == null) {
			jTableJuly = new JTable();
			jTableJuly.setModel(new MonthTableModel(7, getSelectedYear()));
			jTableJuly.setRowSelectionAllowed(false);
			jTableJuly.setShowHorizontalLines(false);
			jTableJuly.setShowVerticalLines(false);
		}
		return jTableJuly;
	}

	private JTable getJTableJune() {
		if (jTableJune == null) {
			jTableJune = new JTable();
			jTableJune.setModel(new MonthTableModel(6, getSelectedYear()));
			jTableJune.setRowSelectionAllowed(false);
			jTableJune.setShowHorizontalLines(false);
			jTableJune.setShowVerticalLines(false);
		}
		return jTableJune;
	}

	private JTable getJTableMarch() {
		if (jTableMarch == null) {
			jTableMarch = new JTable();
			jTableMarch.setModel(new MonthTableModel(3, getSelectedYear()));
			jTableMarch.setRowSelectionAllowed(false);
			jTableMarch.setShowHorizontalLines(false);
			jTableMarch.setShowVerticalLines(false);
		}
		return jTableMarch;
	}

	private JTable getJTableMay() {
		if (jTableMay == null) {
			jTableMay = new JTable();
			jTableMay.setModel(new MonthTableModel(5, getSelectedYear()));
			jTableMay.setRowSelectionAllowed(false);
			jTableMay.setShowHorizontalLines(false);
			jTableMay.setShowVerticalLines(false);
		}
		return jTableMay;
	}

	private JTable getJTableNovember() {
		if (jTableNovember == null) {
			jTableNovember = new JTable();
			jTableNovember.setModel(new MonthTableModel(11, getSelectedYear()));
			jTableNovember.setRowSelectionAllowed(false);
			jTableNovember.setShowHorizontalLines(false);
			jTableNovember.setShowVerticalLines(false);
		}
		return jTableNovember;
	}

	private JTable getJTableOctober() {
		if (jTableOctober == null) {
			jTableOctober = new JTable();
			jTableOctober.setModel(new MonthTableModel(10, getSelectedYear()));
			jTableOctober.setRowSelectionAllowed(false);
			jTableOctober.setShowHorizontalLines(false);
			jTableOctober.setShowVerticalLines(false);
		}
		return jTableOctober;
	}

	private JTable getJTableSeptember() {
		if (jTableSeptember == null) {
			jTableSeptember = new JTable();
			jTableSeptember.setModel(new MonthTableModel(9, getSelectedYear()));
			jTableSeptember.setRowSelectionAllowed(false);
			jTableSeptember.setShowHorizontalLines(false);
			jTableSeptember.setShowVerticalLines(false);
		}
		return jTableSeptember;
	}

	/**
	 * @return the selectedStudent
	 */
	public Student getSelectedStudent() {
		return _selectedStudent;
	}

	/**
	 * @return the selectedYear
	 */
	public Integer getSelectedYear() {
		return _selectedYear;
	}

	private void initComponents() {
		setTitle("Homeschool Tracker");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setForeground(Color.black);
		add(getJLabelStatus(), BorderLayout.SOUTH);
		add(getJTabbedPaneTabs(), BorderLayout.CENTER);
		setJMenuBar(getJMenuBarMain());
		setSize(1099, 668);
	}

	private JPanel getJPanelYearPicker() {
		if (jPanelYearPicker == null) {
			jPanelYearPicker = new JPanel();
			jPanelYearPicker.setLayout(new GroupLayout());
			jPanelYearPicker.add(getJButtonPrevYear(), new Constraints(new Leading(12, 48, 48), new Leading(11, 12, 12)));
			jPanelYearPicker.add(getJButtonNextYear(), new Constraints(new Trailing(12, 48, 48), new Leading(11, 12, 12)));
			jPanelYearPicker.add(getJLabelYear(), new Constraints(new Bilateral(65, 65, 36), new Leading(12, 12, 12)));
		}
		return jPanelYearPicker;
	}

	/**
	 * Event: Next year button pressed.
	 * @param event
	 */
	private void jButtonNextYearActionActionPerformed(ActionEvent event) {
		setSelectedYear(getSelectedYear() + 1);
		getJLabelYear().setText(getSelectedYear().toString());
		refreshCalenders();
	}

	/**
	 * Event: Previous year button pressed.
	 * @param event
	 */
	private void jButtonPrevYearActionActionPerformed(ActionEvent event) {
		setSelectedYear(getSelectedYear() - 1);
		getJLabelYear().setText(getSelectedYear().toString());
		refreshCalenders();
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
				if (getSelectedStudent() != null && getSelectedStudent().equals((Student) s)) {
					setSelectedStudent(null);
					setTitle("Homeschool Tracker");
				}
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
	 * Event: Students tab, Open pressed.
	 * @param event
	 */
	private void jButtonStudentsOpenActionActionPerformed(ActionEvent event) {
		Student s = (Student) getJListStudentList().getSelectedValue();
		if (s != null) {
			setSelectedStudent(s);
			setTitle("Homeschool Tracker [" + s.toString() + "]");
			refreshCalenders();
			getJTabbedPaneTabs().setSelectedIndex(1);
		}
	}

	/**
	 * Event: Student list, mouse clicked.
	 * @param event
	 */
	private void jListStudentListMouseMouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			getJButtonStudentsOpen().doClick();
		}
	}

	/**
	 * Event: File > Exit clicked.
	 * @param event
	 */
	private void jMenuItemFileExitActionActionPerformed(ActionEvent event) {
		this.dispose();
	}

	/**
	 * Event: Students tab selected.
	 * @param event
	 */
	private void jPanelStudentsComponentComponentShown(ComponentEvent event) {
		refreshStudentList();
	}

	/**
	 * Event: Year tab selected.
	 * @param event
	 */
	private void jPanelYearComponentComponentShown(ComponentEvent event) {
		if (getJLabelYear().getText().contentEquals("0000")) {
			getJLabelYear().setText(getSelectedYear().toString());
		}
		// TODO: highlight attended days
	}

	private void refreshCalenders() {
		getJTableJanuary().setModel(new MonthTableModel(1, getSelectedYear()));
		getJTableFebruary().setModel(new MonthTableModel(2, getSelectedYear()));
		getJTableMarch().setModel(new MonthTableModel(3, getSelectedYear()));
		getJTableApril().setModel(new MonthTableModel(4, getSelectedYear()));
		getJTableMay().setModel(new MonthTableModel(5, getSelectedYear()));
		getJTableJune().setModel(new MonthTableModel(6, getSelectedYear()));
		getJTableJuly().setModel(new MonthTableModel(7, getSelectedYear()));
		getJTableAugust().setModel(new MonthTableModel(8, getSelectedYear()));
		getJTableSeptember().setModel(new MonthTableModel(9, getSelectedYear()));
		getJTableOctober().setModel(new MonthTableModel(10, getSelectedYear()));
		getJTableNovember().setModel(new MonthTableModel(11, getSelectedYear()));
		getJTableDecember().setModel(new MonthTableModel(12, getSelectedYear()));
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
		if (getSelectedStudent() != null) {
			getJListStudentList().setSelectedValue(getSelectedStudent(), true);
		}
	}

	/**
	 * @param selectedStudent the selectedStudent to set
	 */
	public void setSelectedStudent(Student selectedStudent) {
		_selectedStudent = selectedStudent;
	}

	/**
	 * @param selectedYear the selectedYear to set
	 */
	public void setSelectedYear(Integer selectedYear) {
		_selectedYear = selectedYear;
	}
}
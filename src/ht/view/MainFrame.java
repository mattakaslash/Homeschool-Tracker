package ht.view;

import ht.model.Day;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

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
// VS4E -- DO NOT REMOVE THIS LINE!
public class MainFrame extends JFrame {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 8444716793871398441L;
	
	/**
	 * Standard date format.
	 */
	private static final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

	/**
	 * Stores the currently-selected school day.
	 */
	private Day _selectedDay = null;

	/**
	 * Stores the currently-selected student from the students tab.
	 */
	private Student _selectedStudent = null;

	/**
	 * Stores the currently selected year from the year tab.
	 */
	private Integer _selectedYear = Calendar.getInstance().get(Calendar.YEAR);

	private ButtonGroup buttonGroupAttendance;
	private JButton jButtonNextYear;
	private JButton jButtonPrevYear;
	private JButton jButtonStudentsAdd;
	private JButton jButtonStudentsDelete;
	private JButton jButtonStudentsEdit;
	private JButton jButtonStudentsOpen;
	private JCheckBox jCheckBoxCoOp;
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
	private JPanel jPanelDayCheckBoxes;
	private JPanel jPanelDayDetails;
	private JPanel jPanelStudents;
	private JPanel jPanelYear;
	private JPanel jPanelYearPicker;
	private JRadioButton jRadioButtonHadSchool;
	private JRadioButton jRadioButtonSick;
	private JRadioButton jRadioButtonVacation;
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

	/**
	 * Defines a new frame.
	 */
	public MainFrame() {
		initComponents();
	}

	private void clearAllTableSelections() {
		getJTableJanuary().getSelectionModel().clearSelection();
		getJTableFebruary().getSelectionModel().clearSelection();
		getJTableMarch().getSelectionModel().clearSelection();
		getJTableApril().getSelectionModel().clearSelection();
		getJTableMay().getSelectionModel().clearSelection();
		getJTableJune().getSelectionModel().clearSelection();
		getJTableJuly().getSelectionModel().clearSelection();
		getJTableAugust().getSelectionModel().clearSelection();
		getJTableSeptember().getSelectionModel().clearSelection();
		getJTableOctober().getSelectionModel().clearSelection();
		getJTableNovember().getSelectionModel().clearSelection();
		getJTableDecember().getSelectionModel().clearSelection();
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

	private JCheckBox getJCheckBoxCoOp() {
		if (jCheckBoxCoOp == null) {
			jCheckBoxCoOp = new JCheckBox();
			jCheckBoxCoOp.setText("Co-Op");
			jCheckBoxCoOp.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent event) {
					jCheckBoxCoOpItemItemStateChanged(event);
				}
			});
		}
		return jCheckBoxCoOp;
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

	private JPanel getJPanelDayCheckBoxes() {
		if (jPanelDayCheckBoxes == null) {
			jPanelDayCheckBoxes = new JPanel();
			jPanelDayCheckBoxes.add(getJRadioButtonHadSchool());
			jPanelDayCheckBoxes.add(getJCheckBoxCoOp());
			jPanelDayCheckBoxes.add(getJRadioButtonSick());
			jPanelDayCheckBoxes.add(getJRadioButtonVacation());
		}
		return jPanelDayCheckBoxes;
	}

	private JPanel getJPanelDayDetails() {
		if (jPanelDayDetails == null) {
			jPanelDayDetails = new JPanel();
			jPanelDayDetails.setBorder(BorderFactory.createTitledBorder(null, "Details for ", TitledBorder.LEADING,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelDayDetails.setLayout(new GroupLayout());
			jPanelDayDetails.add(getJPanelDayCheckBoxes(), new Constraints(new Bilateral(12, 12, 0), new Leading(0, 33, 10, 10)));
		}
		return jPanelDayDetails;
	}

	private JPanel getJPanelStudents() {
		if (jPanelStudents == null) {
			jPanelStudents = new JPanel();
			jPanelStudents.setLayout(new GroupLayout());
			jPanelStudents.add(getJButtonStudentsEdit(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(74, 12, 12)));
			jPanelStudents.add(getJButtonStudentsOpen(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(43, 12, 12)));
			jPanelStudents
					.add(getJButtonStudentsDelete(), new Constraints(new Trailing(12, 92, 46, 410), new Leading(105, 12, 12)));
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
			jPanelYear.add(getJPanelDayDetails(), new Constraints(new Bilateral(633, 12, 0), new Bilateral(12, 12, 0)));
			jPanelYear.addComponentListener(new ComponentAdapter() {

				public void componentShown(ComponentEvent event) {
					jPanelYearComponentComponentShown(event);
				}
			});
		}
		return jPanelYear;
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

	private JRadioButton getJRadioButtonHadSchool() {
		if (jRadioButtonHadSchool == null) {
			jRadioButtonHadSchool = new JRadioButton();
			jRadioButtonHadSchool.setSelected(true);
			jRadioButtonHadSchool.setText("Had School");
			jRadioButtonHadSchool.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent event) {
					jRadioButtonHadSchoolItemItemStateChanged(event);
				}
			});
		}
		return jRadioButtonHadSchool;
	}

	private JRadioButton getJRadioButtonSick() {
		if (jRadioButtonSick == null) {
			jRadioButtonSick = new JRadioButton();
			jRadioButtonSick.setText("Sick");
			jRadioButtonSick.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent event) {
					jRadioButtonSickItemItemStateChanged(event);
				}
			});
		}
		return jRadioButtonSick;
	}

	private JRadioButton getJRadioButtonVacation() {
		if (jRadioButtonVacation == null) {
			jRadioButtonVacation = new JRadioButton();
			jRadioButtonVacation.setText("Vacation");
			jRadioButtonVacation.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent event) {
					jRadioButtonVacationItemItemStateChanged(event);
				}
			});
		}
		return jRadioButtonVacation;
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
			jTableApril.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableApril.setRowSelectionAllowed(false);
			jTableApril.setShowHorizontalLines(false);
			jTableApril.setShowVerticalLines(false);
			jTableApril.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableAprilMouseMouseClicked(event);
				}
			});
		}
		return jTableApril;
	}

	private JTable getJTableAugust() {
		if (jTableAugust == null) {
			jTableAugust = new JTable();
			jTableAugust
					.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
						private static final long serialVersionUID = 1L;
						Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class,
								Integer.class, Integer.class, Integer.class, };

						public Class<?> getColumnClass(int columnIndex) {
							return types[columnIndex];
						}
					});
			jTableAugust.setRowSelectionAllowed(false);
			jTableAugust.setShowHorizontalLines(false);
			jTableAugust.setShowVerticalLines(false);
			jTableAugust.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableAugustMouseMouseClicked(event);
				}
			});
		}
		return jTableAugust;
	}

	private JTable getJTableDecember() {
		if (jTableDecember == null) {
			jTableDecember = new JTable();
			jTableDecember.setModel(new DefaultTableModel(new Object[][] { {} },
					new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableDecember.setRowSelectionAllowed(false);
			jTableDecember.setShowHorizontalLines(false);
			jTableDecember.setShowVerticalLines(false);
			jTableDecember.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableDecemberMouseMouseClicked(event);
				}
			});
		}
		return jTableDecember;
	}

	private JTable getJTableFebruary() {
		if (jTableFebruary == null) {
			jTableFebruary = new JTable();
			jTableFebruary.setModel(new DefaultTableModel(new Object[][] { {} },
					new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableFebruary.setRowSelectionAllowed(false);
			jTableFebruary.setShowHorizontalLines(false);
			jTableFebruary.setShowVerticalLines(false);
			jTableFebruary.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableFebruaryMouseMouseClicked(event);
				}
			});
		}
		return jTableFebruary;
	}

	private JTable getJTableJanuary() {
		if (jTableJanuary == null) {
			jTableJanuary = new JTable();
			jTableJanuary
					.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
						private static final long serialVersionUID = 1L;
						Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class,
								Integer.class, Integer.class, Integer.class, };

						public Class<?> getColumnClass(int columnIndex) {
							return types[columnIndex];
						}
					});
			jTableJanuary.setRowSelectionAllowed(false);
			jTableJanuary.setShowHorizontalLines(false);
			jTableJanuary.setShowVerticalLines(false);
			jTableJanuary.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableJanuaryMouseMouseClicked(event);
				}
			});
		}
		return jTableJanuary;
	}

	private JTable getJTableJuly() {
		if (jTableJuly == null) {
			jTableJuly = new JTable();
			jTableJuly.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableJuly.setRowSelectionAllowed(false);
			jTableJuly.setShowHorizontalLines(false);
			jTableJuly.setShowVerticalLines(false);
			jTableJuly.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableJulyMouseMouseClicked(event);
				}
			});
		}
		return jTableJuly;
	}

	private JTable getJTableJune() {
		if (jTableJune == null) {
			jTableJune = new JTable();
			jTableJune.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableJune.setRowSelectionAllowed(false);
			jTableJune.setShowHorizontalLines(false);
			jTableJune.setShowVerticalLines(false);
			jTableJune.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent event) {
					jTableJuneMouseMouseClicked(event);
				}
			});
		}
		return jTableJune;
	}

	private JTable getJTableMarch() {
		if (jTableMarch == null) {
			jTableMarch = new JTable();
			jTableMarch.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableMarch.setRowSelectionAllowed(false);
			jTableMarch.setShowHorizontalLines(false);
			jTableMarch.setShowVerticalLines(false);
			jTableMarch.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableMarchMouseMouseClicked(event);
				}
			});
		}
		return jTableMarch;
	}

	private JTable getJTableMay() {
		if (jTableMay == null) {
			jTableMay = new JTable();
			jTableMay.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableMay.setRowSelectionAllowed(false);
			jTableMay.setShowHorizontalLines(false);
			jTableMay.setShowVerticalLines(false);
			jTableMay.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableMayMouseMouseClicked(event);
				}
			});
		}
		return jTableMay;
	}

	private JTable getJTableNovember() {
		if (jTableNovember == null) {
			jTableNovember = new JTable();
			jTableNovember.setModel(new DefaultTableModel(new Object[][] { {} },
					new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableNovember.setRowSelectionAllowed(false);
			jTableNovember.setShowHorizontalLines(false);
			jTableNovember.setShowVerticalLines(false);
			jTableNovember.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableNovemberMouseMouseClicked(event);
				}
			});
		}
		return jTableNovember;
	}

	private JTable getJTableOctober() {
		if (jTableOctober == null) {
			jTableOctober = new JTable();
			jTableOctober
					.setModel(new DefaultTableModel(new Object[][] { {} }, new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
						private static final long serialVersionUID = 1L;
						Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class,
								Integer.class, Integer.class, Integer.class, };

						public Class<?> getColumnClass(int columnIndex) {
							return types[columnIndex];
						}
					});
			jTableOctober.setRowSelectionAllowed(false);
			jTableOctober.setShowHorizontalLines(false);
			jTableOctober.setShowVerticalLines(false);
			jTableOctober.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableOctoberMouseMouseClicked(event);
				}
			});
		}
		return jTableOctober;
	}

	private JTable getJTableSeptember() {
		if (jTableSeptember == null) {
			jTableSeptember = new JTable();
			jTableSeptember.setModel(new DefaultTableModel(new Object[][] { {} },
					new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableSeptember.setRowSelectionAllowed(false);
			jTableSeptember.setShowHorizontalLines(false);
			jTableSeptember.setShowVerticalLines(false);
			jTableSeptember.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jTableSeptemberMouseMouseClicked(event);
				}
			});
		}
		return jTableSeptember;
	}

	/**
	 * @return the selectedDay
	 */
	public Day getSelectedDay() {
		return _selectedDay;
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

	private void initButtonGroupAttendance() {
		buttonGroupAttendance = new ButtonGroup();
		buttonGroupAttendance.add(getJRadioButtonHadSchool());
		buttonGroupAttendance.add(getJRadioButtonSick());
		buttonGroupAttendance.add(getJRadioButtonVacation());
	}

	private void initComponents() {
		setTitle("Homeschool Tracker");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setForeground(Color.black);
		add(getJLabelStatus(), BorderLayout.SOUTH);
		add(getJTabbedPaneTabs(), BorderLayout.CENTER);
		setJMenuBar(getJMenuBarMain());
		initButtonGroupAttendance();
		setSize(1024, 668);
	}

	/**
	 * Event: Next year button pressed.
	 * 
	 * @param event
	 */
	private void jButtonNextYearActionActionPerformed(ActionEvent event) {
		setSelectedYear(getSelectedYear() + 1);
		getJLabelYear().setText(getSelectedYear().toString());
		refreshCalenders();
	}

	/**
	 * Event: Previous year button pressed.
	 * 
	 * @param event
	 */
	private void jButtonPrevYearActionActionPerformed(ActionEvent event) {
		setSelectedYear(getSelectedYear() - 1);
		getJLabelYear().setText(getSelectedYear().toString());
		refreshCalenders();
	}

	/**
	 * Event: Students tab, Add pressed.
	 * 
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
	 * 
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
				if (getSelectedStudent() != null && getSelectedStudent().equals(s)) {
					setSelectedStudent(null);
					setTitle("Homeschool Tracker");
				}
			}
			refreshStudentList();
		}
	}

	/**
	 * Event: Students tab, Edit pressed.
	 * 
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
	 * 
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

	private void jCheckBoxCoOpItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setCoopDay(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Event: Student list, mouse clicked.
	 * 
	 * @param event
	 */
	private void jListStudentListMouseMouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			getJButtonStudentsOpen().doClick();
		}
	}

	/**
	 * Event: File > Exit clicked.
	 * 
	 * @param event
	 */
	private void jMenuItemFileExitActionActionPerformed(ActionEvent event) {
		this.dispose();
	}

	/**
	 * Event: Students tab selected.
	 * 
	 * @param event
	 */
	private void jPanelStudentsComponentComponentShown(ComponentEvent event) {
		refreshStudentList();
	}

	/**
	 * Event: Year tab selected.
	 * 
	 * @param event
	 */
	private void jPanelYearComponentComponentShown(ComponentEvent event) {
		if (getJLabelYear().getText().contentEquals("0000")) {
			getJLabelYear().setText(getSelectedYear().toString());
		}
		// TODO: highlight days
	}

	/**
	 * Event: Attendance changed.
	 * @param event
	 */
	private void jRadioButtonHadSchoolItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setHadSchool(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Event: Attendance changed.
	 * @param event
	 */
	private void jRadioButtonSickItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setSickDay(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Event: Attendance changed.
	 * @param event
	 */
	private void jRadioButtonVacationItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setVacationDay(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Event: April table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableAprilMouseMouseClicked(MouseEvent event) {
		int row = getJTableApril().getSelectedRow();
		int col = getJTableApril().getSelectedColumn();
		clearAllTableSelections();
		getJTableApril().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableApril().getValueAt(row, col), 4, getSelectedYear());
	}

	/**
	 * Event: August table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableAugustMouseMouseClicked(MouseEvent event) {
		int row = getJTableAugust().getSelectedRow();
		int col = getJTableAugust().getSelectedColumn();
		clearAllTableSelections();
		getJTableAugust().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableAugust().getValueAt(row, col), 8, getSelectedYear());
	}

	/**
	 * Event: December table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableDecemberMouseMouseClicked(MouseEvent event) {
		int row = getJTableDecember().getSelectedRow();
		int col = getJTableDecember().getSelectedColumn();
		clearAllTableSelections();
		getJTableDecember().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableDecember().getValueAt(row, col), 12, getSelectedYear());
	}

	/**
	 * Event: February table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableFebruaryMouseMouseClicked(MouseEvent event) {
		int row = getJTableFebruary().getSelectedRow();
		int col = getJTableFebruary().getSelectedColumn();
		clearAllTableSelections();
		getJTableFebruary().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableFebruary().getValueAt(row, col), 2, getSelectedYear());
	}

	/**
	 * Event: January table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableJanuaryMouseMouseClicked(MouseEvent event) {
		int row = getJTableJanuary().getSelectedRow();
		int col = getJTableJanuary().getSelectedColumn();
		clearAllTableSelections();
		getJTableJanuary().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableJanuary().getValueAt(row, col), 6, getSelectedYear());
	}

	/**
	 * Event: July table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableJulyMouseMouseClicked(MouseEvent event) {
		int row = getJTableJuly().getSelectedRow();
		int col = getJTableJuly().getSelectedColumn();
		clearAllTableSelections();
		getJTableJuly().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableJuly().getValueAt(row, col), 6, getSelectedYear());
	}

	/**
	 * Event: June table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableJuneMouseMouseClicked(MouseEvent event) {
		int row = getJTableJune().getSelectedRow();
		int col = getJTableJune().getSelectedColumn();
		clearAllTableSelections();
		getJTableJune().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableJune().getValueAt(row, col), 6, getSelectedYear());
	}

	/**
	 * Event: March table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableMarchMouseMouseClicked(MouseEvent event) {
		int row = getJTableMarch().getSelectedRow();
		int col = getJTableMarch().getSelectedColumn();
		clearAllTableSelections();
		getJTableMarch().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableMarch().getValueAt(row, col), 3, getSelectedYear());
	}

	/**
	 * Event: May table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableMayMouseMouseClicked(MouseEvent event) {
		int row = getJTableMay().getSelectedRow();
		int col = getJTableMay().getSelectedColumn();
		clearAllTableSelections();
		getJTableMay().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableMay().getValueAt(row, col), 5, getSelectedYear());
	}

	/**
	 * Event: November table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableNovemberMouseMouseClicked(MouseEvent event) {
		int row = getJTableNovember().getSelectedRow();
		int col = getJTableNovember().getSelectedColumn();
		clearAllTableSelections();
		getJTableNovember().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableNovember().getValueAt(row, col), 11, getSelectedYear());
	}

	/**
	 * Event: October table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableOctoberMouseMouseClicked(MouseEvent event) {
		int row = getJTableOctober().getSelectedRow();
		int col = getJTableOctober().getSelectedColumn();
		clearAllTableSelections();
		getJTableOctober().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableOctober().getValueAt(row, col), 10, getSelectedYear());
	}

	/**
	 * Event: September table, mouse clicked.
	 * 
	 * @param event
	 */
	private void jTableSeptemberMouseMouseClicked(MouseEvent event) {
		int row = getJTableSeptember().getSelectedRow();
		int col = getJTableSeptember().getSelectedColumn();
		clearAllTableSelections();
		getJTableSeptember().changeSelection(row, col, false, false);
		loadDay((Integer) getJTableSeptember().getValueAt(row, col), 9, getSelectedYear());
	}

	/**
	 * Loads the given day from the database and updates the form.
	 * @param date the day of the month
	 * @param month the month of the year
	 * @param year the year
	 */
	private void loadDay(Integer date, Integer month, Integer year) {
		if (getSelectedDay() != null) {
			Day.save(getSelectedDay());
		}
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, date);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.YEAR, year);
		setSelectedDay(Day.get(cal.getTime()));
		((TitledBorder) getJPanelDayDetails().getBorder()).setTitle("Details for " + dateFormat.format(getSelectedDay().getDate()));
		getJRadioButtonHadSchool().setSelected(getSelectedDay().hadSchool());
		getJCheckBoxCoOp().setSelected(getSelectedDay().isCoopDay());
		getJRadioButtonSick().setSelected(getSelectedDay().isSickDay());
		getJRadioButtonVacation().setSelected(getSelectedDay().isVacationDay());
		getJPanelDayDetails().repaint();
	}

	/**
	 * Updates all the calendars for the selected year.
	 */
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
	 * @param selectedDay
	 *            the selectedDay to set
	 */
	public void setSelectedDay(Day selectedDay) {
		_selectedDay = selectedDay;
	}

	/**
	 * @param selectedStudent
	 *            the selectedStudent to set
	 */
	public void setSelectedStudent(Student selectedStudent) {
		_selectedStudent = selectedStudent;
	}

	/**
	 * @param selectedYear
	 *            the selectedYear to set
	 */
	public void setSelectedYear(Integer selectedYear) {
		_selectedYear = selectedYear;
	}
}
package ht.view;

import ht.model.Assignment;
import ht.model.Day;
import ht.model.FieldTrip;
import ht.model.ReadingListEntry;
import ht.model.Student;
import ht.model.swing.AssignmentTableModel;
import ht.model.swing.CurriculumTableModel;
import ht.model.swing.MonthTableModel;
import ht.model.swing.ReadingListTableModel;
import ht.util.MonthTableSelectionListener;
import ht.util.SchoolYear;
import ht.view.editor.SubjectCellEditor;
import ht.view.render.MonthTableRenderer;
import ht.view.render.StudentCellRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
	 * Stores the data model for the assignments table.
	 */
	private static final AssignmentTableModel assignmentTableModel = new AssignmentTableModel();
	
	/**
	 * Stores the data model for the curriculum log table.
	 */
	private static final TableModel curriculumTableModel = new CurriculumTableModel();

	/**
	 * Standard date format.
	 */
	private static final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

	/**
	 * Stores the data model for the reading list table.
	 */
	private static final ReadingListTableModel readingListTableModel = new ReadingListTableModel();

	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 8444716793871398441L;

	/**
	 * Stores the currently-selected school day.
	 */
	private Day _selectedDay = null;
	
	/**
	 * Stores the currently-selected field trip.
	 */
	private FieldTrip _selectedFieldTrip;

	/**
	 * Stores the currently-selected student from the students tab.
	 */
	private Student _selectedStudent = null;

	/**
	 * Stores the currently selected year from the year tab.
	 */
	private Integer _selectedYear = SchoolYear.getStart().get(Calendar.YEAR);

	private ButtonGroup buttonGroupAttendance;
	private JButton jButtonCurriculumAdd;
	private JButton jButtonCurriculumDelete;
	private JButton jButtonNextYear;
	private JButton jButtonPrevYear;
	private JButton jButtonReadingListAdd;
	private JButton jButtonReadingListDelete;
	private JButton jButtonStudentsAdd;
	private JButton jButtonStudentsDelete;
	private JButton jButtonStudentsEdit;
	private JButton jButtonStudentsOpen;
	private JCheckBox jCheckBoxCoOp;
	private JLabel jLabelApril;
	private JLabel jLabelAugust;
	private JLabel jLabelDecember;
	private JLabel jLabelFebruary;
	private JLabel jLabelFieldTripDescription;
	private JLabel jLabelFieldTripLocation;
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
	private JMenuItem jMenuItemOptionsConfigureSubjects;
	private JMenu jMenuOptions;
	private JPanel jPanelCurriculum;
	private JPanel jPanelCurriculumControls;
	private JPanel jPanelDayCheckBoxes;
	private JPanel jPanelDayDetails;
	private JPanel jPanelFieldTrip;
	private JPanel jPanelFieldTripNotes;
	private JPanel jPanelReadingList;
	private JPanel jPanelReadingListControls;
	private JPanel jPanelStudents;
	private JPanel jPanelYear;
	private JPanel jPanelYearPicker;
	private JRadioButton jRadioButtonHadSchool;
	private JRadioButton jRadioButtonSick;
	private JRadioButton jRadioButtonVacation;
	private JScrollPane jScrollPaneApril;
	private JScrollPane jScrollPaneAugust;
	private JScrollPane jScrollPaneCurriculum;
	private JScrollPane jScrollPaneDecember;
	private JScrollPane jScrollPaneFebruary;
	private JScrollPane jScrollPaneFieldTripNotes;
	private JScrollPane jScrollPaneJanuary;
	private JScrollPane jScrollPaneJuly;
	private JScrollPane jScrollPaneJune;
	private JScrollPane jScrollPaneMarch;
	private JScrollPane jScrollPaneMay;
	private JScrollPane jScrollPaneNovember;
	private JScrollPane jScrollPaneOctober;
	private JScrollPane jScrollPaneReadingList;
	private JScrollPane jScrollPaneSeptember;
	private JScrollPane jScrollPaneStudentList;
	private JTabbedPane jTabbedPaneTabs;
	private JTable jTableApril;
	private JTable jTableAugust;
	private JTable jTableCurriculum;
	private JTable jTableDecember;
	private JTable jTableFebruary;
	private JTable jTableJanuary;
	private JTable jTableJuly;
	private JTable jTableJune;
	private JTable jTableMarch;
	private JTable jTableMay;
	private JTable jTableNovember;
	private JTable jTableOctober;
	private JTable jTableReadingList;
	private JTable jTableSeptember;
	private JTextField jTextFieldFieldTripDescription;
	private JTextField jTextFieldFieldTripLocation;
	private JTextPane jTextPaneFieldTripNotes;
	private JPanel jPanelAssignments;
	private JTable jTableAssignments;
	private JScrollPane jScrollPaneAssignments;
	private JPanel jPanelAssignmentsControls;
	private JButton jButtonAssignmentsAdd;
	private JButton jButtonAssignmentsDelete;

	/**
	 * Defines the application's main interface.
	 */
	public MainFrame() {
		initComponents();

		// disable tabs requiring selections
		setTabsEnabled(false);

		// set table renderers
		getJTableJune().setDefaultRenderer(Integer.class, new MonthTableRenderer(6));
		getJTableJuly().setDefaultRenderer(Integer.class, new MonthTableRenderer(7));
		getJTableAugust().setDefaultRenderer(Integer.class, new MonthTableRenderer(8));
		getJTableSeptember().setDefaultRenderer(Integer.class, new MonthTableRenderer(9));
		getJTableOctober().setDefaultRenderer(Integer.class, new MonthTableRenderer(10));
		getJTableNovember().setDefaultRenderer(Integer.class, new MonthTableRenderer(11));
		getJTableDecember().setDefaultRenderer(Integer.class, new MonthTableRenderer(12));
		getJTableJanuary().setDefaultRenderer(Integer.class, new MonthTableRenderer(1));
		getJTableFebruary().setDefaultRenderer(Integer.class, new MonthTableRenderer(2));
		getJTableMarch().setDefaultRenderer(Integer.class, new MonthTableRenderer(3));
		getJTableApril().setDefaultRenderer(Integer.class, new MonthTableRenderer(4));
		getJTableMay().setDefaultRenderer(Integer.class, new MonthTableRenderer(5));

		// set row selection listeners
		getJTableJune().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableJune()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 6, getSelectedYear());
			}
		});
		getJTableJuly().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableJuly()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 7, getSelectedYear());
			}
		});
		getJTableAugust().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableAugust()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 8, getSelectedYear());
			}
		});
		getJTableSeptember().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableSeptember()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 9, getSelectedYear());
			}
		});
		getJTableOctober().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableOctober()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 10, getSelectedYear());
			}
		});
		getJTableNovember().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableNovember()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 11, getSelectedYear());
			}
		});
		getJTableDecember().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableDecember()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 12, getSelectedYear());
			}
		});
		getJTableJanuary().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableJanuary()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 1, getSelectedYear() + 1);
			}
		});
		getJTableFebruary().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableFebruary()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 2, getSelectedYear() + 1);
			}
		});
		getJTableMarch().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableMarch()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 3, getSelectedYear() + 1);
			}
		});
		getJTableApril().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableApril()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 4, getSelectedYear() + 1);
			}
		});
		getJTableMay().getSelectionModel().addListSelectionListener(new MonthTableSelectionListener(getJTableMay()) {

			@Override
			public void dateChanged(Integer date) {
				loadDay(date, 5, getSelectedYear() + 1);
			}
		});

		// set column selection listeners
		getJTableJune().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableJune()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 6, getSelectedYear());
					}
				});
		getJTableJuly().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableJuly()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 7, getSelectedYear());
					}
				});
		getJTableAugust().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableAugust()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 8, getSelectedYear());
					}
				});
		getJTableSeptember().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableSeptember()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 9, getSelectedYear());
					}
				});
		getJTableOctober().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableOctober()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 10, getSelectedYear());
					}
				});
		getJTableNovember().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableNovember()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 11, getSelectedYear());
					}
				});
		getJTableDecember().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableDecember()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 12, getSelectedYear());
					}
				});
		getJTableJanuary().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableJanuary()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 1, getSelectedYear() + 1);
					}
				});
		getJTableFebruary().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableFebruary()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 2, getSelectedYear() + 1);
					}
				});
		getJTableMarch().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableMarch()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 3, getSelectedYear() + 1);
					}
				});
		getJTableApril().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableApril()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 4, getSelectedYear() + 1);
					}
				});
		getJTableMay().getColumnModel().getSelectionModel()
				.addListSelectionListener(new MonthTableSelectionListener(getJTableMay()) {

					@Override
					public void dateChanged(Integer date) {
						loadDay(date, 5, getSelectedYear() + 1);
					}
				});
	}

	private void clearAllTableSelections(Integer month) {
		if (month != 1) {
			getJTableJanuary().getSelectionModel().clearSelection();
		}
		if (month != 2) {
			getJTableFebruary().getSelectionModel().clearSelection();
		}
		if (month != 3) {
			getJTableMarch().getSelectionModel().clearSelection();
		}
		if (month != 4) {
			getJTableApril().getSelectionModel().clearSelection();
		}
		if (month != 5) {
			getJTableMay().getSelectionModel().clearSelection();
		}
		if (month != 6) {
			getJTableJune().getSelectionModel().clearSelection();
		}
		if (month != 7) {
			getJTableJuly().getSelectionModel().clearSelection();
		}
		if (month != 8) {
			getJTableAugust().getSelectionModel().clearSelection();
		}
		if (month != 9) {
			getJTableSeptember().getSelectionModel().clearSelection();
		}
		if (month != 10) {
			getJTableOctober().getSelectionModel().clearSelection();
		}
		if (month != 11) {
			getJTableNovember().getSelectionModel().clearSelection();
		}
		if (month != 12) {
			getJTableDecember().getSelectionModel().clearSelection();
		}
	}

	private JButton getJButtonCurriculumAdd() {
		if (jButtonCurriculumAdd == null) {
			jButtonCurriculumAdd = new JButton();
			jButtonCurriculumAdd.setText("Add");
			jButtonCurriculumAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonCurriculumAddActionActionPerformed(event);
				}
			});
		}
		return jButtonCurriculumAdd;
	}

	private JButton getJButtonCurriculumDelete() {
		if (jButtonCurriculumDelete == null) {
			jButtonCurriculumDelete = new JButton();
			jButtonCurriculumDelete.setText("Delete");
			jButtonCurriculumDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonCurriculumDeleteActionActionPerformed(event);
				}
			});
		}
		return jButtonCurriculumDelete;
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

	private JButton getJButtonReadingListAdd() {
		if (jButtonReadingListAdd == null) {
			jButtonReadingListAdd = new JButton();
			jButtonReadingListAdd.setText("Add");
			jButtonReadingListAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonReadingListAddActionActionPerformed(event);
				}
			});
		}
		return jButtonReadingListAdd;
	}

	private JButton getJButtonReadingListDelete() {
		if (jButtonReadingListDelete == null) {
			jButtonReadingListDelete = new JButton();
			jButtonReadingListDelete.setText("Delete");
			jButtonReadingListDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonReadingListDeleteActionActionPerformed(event);
				}
			});
		}
		return jButtonReadingListDelete;
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

				@Override
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

	private JLabel getJLabelFieldTripDescription() {
		if (jLabelFieldTripDescription == null) {
			jLabelFieldTripDescription = new JLabel();
			jLabelFieldTripDescription.setText("Description");
		}
		return jLabelFieldTripDescription;
	}

	private JLabel getJLabelFieldTripLocation() {
		if (jLabelFieldTripLocation == null) {
			jLabelFieldTripLocation = new JLabel();
			jLabelFieldTripLocation.setText("Location");
		}
		return jLabelFieldTripLocation;
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

	private JMenu getJMenu0() {
		if (jMenuOptions == null) {
			jMenuOptions = new JMenu();
			jMenuOptions.setText("Options");
			jMenuOptions.setOpaque(false);
			jMenuOptions.add(getJMenuItem0());
		}
		return jMenuOptions;
	}

	private JMenuBar getJMenuBarMain() {
		if (jMenuBarMain == null) {
			jMenuBarMain = new JMenuBar();
			jMenuBarMain.add(getJMenuFile());
			jMenuBarMain.add(getJMenu0());
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

	private JMenuItem getJMenuItem0() {
		if (jMenuItemOptionsConfigureSubjects == null) {
			jMenuItemOptionsConfigureSubjects = new JMenuItem();
			jMenuItemOptionsConfigureSubjects.setText("Configure Subjects");
			jMenuItemOptionsConfigureSubjects.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					jMenuItemOptionsConfigureSubjectsActionActionPerformed(event);
				}
			});
		}
		return jMenuItemOptionsConfigureSubjects;
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

	private JPanel getJPanelCurriculum() {
		if (jPanelCurriculum == null) {
			jPanelCurriculum = new JPanel();
			jPanelCurriculum.setLayout(new BorderLayout());
			jPanelCurriculum.add(getJScrollPaneCurriculum(), BorderLayout.CENTER);
			jPanelCurriculum.add(getJPanelCurriculumControls(), BorderLayout.SOUTH);
			jPanelCurriculum.addComponentListener(new ComponentAdapter() {

				@Override
				public void componentShown(ComponentEvent event) {
					jPanelCurriculumComponentComponentShown(event);
				}
			});
		}
		return jPanelCurriculum;
	}

	private JPanel getJPanelCurriculumControls() {
		if (jPanelCurriculumControls == null) {
			jPanelCurriculumControls = new JPanel();
			jPanelCurriculumControls.add(getJButtonCurriculumAdd());
			jPanelCurriculumControls.add(getJButtonCurriculumDelete());
		}
		return jPanelCurriculumControls;
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
			jPanelDayDetails.add(getJPanelFieldTrip(), new Constraints(new Bilateral(0, 1, 122), new Bilateral(39, 0, 182)));
		}
		return jPanelDayDetails;
	}

	private JPanel getJPanelFieldTrip() {
		if (jPanelFieldTrip == null) {
			jPanelFieldTrip = new JPanel();
			jPanelFieldTrip.setBorder(BorderFactory.createTitledBorder(null, "Field Trip", TitledBorder.LEADING,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelFieldTrip.setLayout(new GroupLayout());
			jPanelFieldTrip.add(getJLabelFieldTripDescription(), new Constraints(new Leading(12, 12, 12), new Leading(0, 12, 12)));
			jPanelFieldTrip.add(getJLabelFieldTripLocation(), new Constraints(new Leading(12, 12, 12), new Leading(22, 12, 12)));
			jPanelFieldTrip.add(getJTextFieldFieldTripDescription(), new Constraints(new Bilateral(89, 0, 4), new Leading(-2, 59,
					379)));
			jPanelFieldTrip.add(getJTextFieldFieldTripLocation(),
					new Constraints(new Bilateral(89, 1, 4), new Leading(20, 59, 379)));
			jPanelFieldTrip.add(getJPanelFieldTripNotes(), new Constraints(new Bilateral(0, 0, 0), new Bilateral(44, 0, 0)));
		}
		return jPanelFieldTrip;
	}

	private JPanel getJPanelFieldTripNotes() {
		if (jPanelFieldTripNotes == null) {
			jPanelFieldTripNotes = new JPanel();
			jPanelFieldTripNotes.setBorder(BorderFactory.createTitledBorder(null, "Notes", TitledBorder.LEADING,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanelFieldTripNotes.setLayout(new GroupLayout());
			jPanelFieldTripNotes.add(getJScrollPaneFieldTripNotes(), new Constraints(new Bilateral(0, 0, 22), new Bilateral(0, 0,
					22)));
		}
		return jPanelFieldTripNotes;
	}

	private JPanel getJPanelReadingList() {
		if (jPanelReadingList == null) {
			jPanelReadingList = new JPanel();
			jPanelReadingList.setLayout(new BorderLayout());
			jPanelReadingList.add(getJScrollPaneReadingList(), BorderLayout.CENTER);
			jPanelReadingList.add(getJPanelReadingListControls(), BorderLayout.SOUTH);
			jPanelReadingList.addComponentListener(new ComponentAdapter() {

				@Override
				public void componentShown(ComponentEvent event) {
					jPanelReadingListComponentComponentShown(event);
				}
			});
		}
		return jPanelReadingList;
	}

	private JPanel getJPanelReadingListControls() {
		if (jPanelReadingListControls == null) {
			jPanelReadingListControls = new JPanel();
			jPanelReadingListControls.add(getJButtonReadingListAdd());
			jPanelReadingListControls.add(getJButtonReadingListDelete());
		}
		return jPanelReadingListControls;
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

				@Override
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

				@Override
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

				@Override
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

				@Override
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

	private JScrollPane getJScrollPaneCurriculum() {
		if (jScrollPaneCurriculum == null) {
			jScrollPaneCurriculum = new JScrollPane();
			jScrollPaneCurriculum.setViewportView(getJTableCurriculum());
		}
		return jScrollPaneCurriculum;
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

	private JScrollPane getJScrollPaneFieldTripNotes() {
		if (jScrollPaneFieldTripNotes == null) {
			jScrollPaneFieldTripNotes = new JScrollPane();
			jScrollPaneFieldTripNotes.setViewportView(getJTextPaneFieldTripNotes());
		}
		return jScrollPaneFieldTripNotes;
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

	private JScrollPane getJScrollPaneReadingList() {
		if (jScrollPaneReadingList == null) {
			jScrollPaneReadingList = new JScrollPane();
			jScrollPaneReadingList.setViewportView(getJTableReadingList());
		}
		return jScrollPaneReadingList;
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
			jTabbedPaneTabs.addTab("Curriculum", getJPanelCurriculum());
			jTabbedPaneTabs.addTab("Year", getJPanelYear());
			jTabbedPaneTabs.addTab("Reading List", getJPanelReadingList());
			jTabbedPaneTabs.addTab("Assignments", getJPanelAssignments());
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

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableApril.setRowSelectionAllowed(false);
			jTableApril.setShowHorizontalLines(false);
			jTableApril.setShowVerticalLines(false);
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

						@Override
						public Class<?> getColumnClass(int columnIndex) {
							return types[columnIndex];
						}
					});
			jTableAugust.setRowSelectionAllowed(false);
			jTableAugust.setShowHorizontalLines(false);
			jTableAugust.setShowVerticalLines(false);
		}
		return jTableAugust;
	}

	private JTable getJTableCurriculum() {
		if (jTableCurriculum == null) {
			jTableCurriculum = new JTable();
			jTableCurriculum.setModel(new DefaultTableModel(new Object[0][0], new String[] { "Title", "Author", "URL", "Notes" }));
		}
		return jTableCurriculum;
	}

	private JTable getJTableDecember() {
		if (jTableDecember == null) {
			jTableDecember = new JTable();
			jTableDecember.setModel(new DefaultTableModel(new Object[][] { {} },
					new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableDecember.setRowSelectionAllowed(false);
			jTableDecember.setShowHorizontalLines(false);
			jTableDecember.setShowVerticalLines(false);
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

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableFebruary.setRowSelectionAllowed(false);
			jTableFebruary.setShowHorizontalLines(false);
			jTableFebruary.setShowVerticalLines(false);
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

						@Override
						public Class<?> getColumnClass(int columnIndex) {
							return types[columnIndex];
						}
					});
			jTableJanuary.setRowSelectionAllowed(false);
			jTableJanuary.setShowHorizontalLines(false);
			jTableJanuary.setShowVerticalLines(false);
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

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableJuly.setRowSelectionAllowed(false);
			jTableJuly.setShowHorizontalLines(false);
			jTableJuly.setShowVerticalLines(false);
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

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableMarch.setRowSelectionAllowed(false);
			jTableMarch.setShowHorizontalLines(false);
			jTableMarch.setShowVerticalLines(false);
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

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableMay.setRowSelectionAllowed(false);
			jTableMay.setShowHorizontalLines(false);
			jTableMay.setShowVerticalLines(false);
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

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableNovember.setRowSelectionAllowed(false);
			jTableNovember.setShowHorizontalLines(false);
			jTableNovember.setShowVerticalLines(false);
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

						@Override
						public Class<?> getColumnClass(int columnIndex) {
							return types[columnIndex];
						}
					});
			jTableOctober.setRowSelectionAllowed(false);
			jTableOctober.setShowHorizontalLines(false);
			jTableOctober.setShowVerticalLines(false);
		}
		return jTableOctober;
	}

	private JTable getJTableReadingList() {
		if (jTableReadingList == null) {
			jTableReadingList = new JTable();
			jTableReadingList.setModel(new DefaultTableModel(new Object[0][0], new String[] { "Title", "Author", "Date Started",
					"Date Finished", "Progress", "Assisted" }));
		}
		return jTableReadingList;
	}

	private JTable getJTableSeptember() {
		if (jTableSeptember == null) {
			jTableSeptember = new JTable();
			jTableSeptember.setModel(new DefaultTableModel(new Object[][] { {} },
					new String[] { "S", "M", "T", "W", "T", "F", "S", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, };

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			jTableSeptember.setRowSelectionAllowed(false);
			jTableSeptember.setShowHorizontalLines(false);
			jTableSeptember.setShowVerticalLines(false);
		}
		return jTableSeptember;
	}

	private JTextField getJTextFieldFieldTripDescription() {
		if (jTextFieldFieldTripDescription == null) {
			jTextFieldFieldTripDescription = new JTextField();
		}
		return jTextFieldFieldTripDescription;
	}

	private JTextField getJTextFieldFieldTripLocation() {
		if (jTextFieldFieldTripLocation == null) {
			jTextFieldFieldTripLocation = new JTextField();
		}
		return jTextFieldFieldTripLocation;
	}

	private JTextPane getJTextPaneFieldTripNotes() {
		if (jTextPaneFieldTripNotes == null) {
			jTextPaneFieldTripNotes = new JTextPane();
		}
		return jTextPaneFieldTripNotes;
	}

	/**
	 * @return the selectedDay
	 */
	public Day getSelectedDay() {
		return _selectedDay;
	}
	
	/**
	 * @return the selectedFieldTrip
	 */
	public FieldTrip getSelectedFieldTrip() {
		return _selectedFieldTrip;
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
		setSize(983, 668);
	}

	private JPanel getJPanelAssignmentsControls() {
		if (jPanelAssignmentsControls == null) {
			jPanelAssignmentsControls = new JPanel();
			jPanelAssignmentsControls.setPreferredSize(new Dimension(100, 100));
			jPanelAssignmentsControls.add(getJButtonAssignmentsAdd());
			jPanelAssignmentsControls.add(getJButtonAssignmentsDelete());
		}
		return jPanelAssignmentsControls;
	}

	private JButton getJButtonAssignmentsDelete() {
		if (jButtonAssignmentsDelete == null) {
			jButtonAssignmentsDelete = new JButton();
			jButtonAssignmentsDelete.setText("Delete");
			jButtonAssignmentsDelete.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonAssignmentsDeleteActionActionPerformed(event);
				}
			});
		}
		return jButtonAssignmentsDelete;
	}

	private JButton getJButtonAssignmentsAdd() {
		if (jButtonAssignmentsAdd == null) {
			jButtonAssignmentsAdd = new JButton();
			jButtonAssignmentsAdd.setText("Add");
			jButtonAssignmentsAdd.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonAssignmentsAddActionActionPerformed(event);
				}
			});
		}
		return jButtonAssignmentsAdd;
	}

	private JPanel getJPanelAssignments() {
		if (jPanelAssignments == null) {
			jPanelAssignments = new JPanel();
			jPanelAssignments.setLayout(new BorderLayout());
			jPanelAssignments.add(getJPanelAssignmentsControls(), BorderLayout.SOUTH);
			jPanelAssignments.add(getJScrollPaneAssignments(), BorderLayout.CENTER);
			jPanelAssignments.addComponentListener(new ComponentAdapter() {
	
				public void componentShown(ComponentEvent event) {
					jPanelAssignmentsComponentComponentShown(event);
				}
			});
		}
		return jPanelAssignments;
	}

	private JScrollPane getJScrollPaneAssignments() {
		if (jScrollPaneAssignments == null) {
			jScrollPaneAssignments = new JScrollPane();
			jScrollPaneAssignments.setViewportView(getJTableAssignments());
		}
		return jScrollPaneAssignments;
	}

	private JTable getJTableAssignments() {
		if (jTableAssignments == null) {
			jTableAssignments = new JTable();
			jTableAssignments.setModel(new DefaultTableModel(new Object[0][0], new String[] { "Subject", "Title", "Category",
					"Date Assigned", "Date Completed", "Points Earned", "Points Possible", "Percentage" }));
		}
		return jTableAssignments;
	}

	/**
	 * Event: Curriculum Add button pressed.
	 * 
	 * @param event
	 */
	private void jButtonCurriculumAddActionActionPerformed(ActionEvent event) {
		((CurriculumTableModel) getJTableCurriculum().getModel()).add();
	}

	/**
	 * Event: Curriculum Delete button pressed.
	 * 
	 * @param event
	 */
	private void jButtonCurriculumDeleteActionActionPerformed(ActionEvent event) {
		if (getJTableCurriculum().getSelectedRowCount() > 0) {
			int[] rows = getJTableCurriculum().getSelectedRows();
			StringBuilder titles = new StringBuilder();
			for (int row : rows) {
				titles.append((String) getJTableCurriculum().getValueAt(row, 0));
				titles.append('\n');
			}

			int n = JOptionPane.showConfirmDialog(this, "Delete the following titles?\n\n" + titles.toString(), "Are you sure?",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				for (int x = rows.length - 1; x >= 0; x--) {
					((CurriculumTableModel) getJTableCurriculum().getModel()).delete(rows[x]);
				}
			}
		}
	}

	/**
	 * Event: Next year button pressed.
	 * 
	 * @param event
	 */
	private void jButtonNextYearActionActionPerformed(ActionEvent event) {
		setSelectedYear(getSelectedYear() + 1);
		getJLabelYear().setText(getSelectedYear().toString() + " - " + (getSelectedYear() + 1));
		refreshCalenders();
	}

	/**
	 * Event: Previous year button pressed.
	 * 
	 * @param event
	 */
	private void jButtonPrevYearActionActionPerformed(ActionEvent event) {
		setSelectedYear(getSelectedYear() - 1);
		getJLabelYear().setText(getSelectedYear().toString() + " - " + (getSelectedYear() + 1));
		refreshCalenders();
	}

	private void jButtonReadingListAddActionActionPerformed(ActionEvent event) {
		ReadingListEntry.save(new ReadingListEntry(getSelectedStudent()));
		((ReadingListTableModel) getJTableReadingList().getModel()).tableChanged();
	}

	private void jButtonReadingListDeleteActionActionPerformed(ActionEvent event) {
		if (getJTableReadingList().getSelectedRowCount() > 0) {
			int[] rows = getJTableReadingList().getSelectedRows();
			StringBuilder titles = new StringBuilder();
			for (int row : rows) {
				titles.append((String) getJTableReadingList().getValueAt(row, 0));
				titles.append('\n');
			}

			int n = JOptionPane.showConfirmDialog(this, "Delete the following titles?\n\n" + titles.toString(), "Are you sure?",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				for (int x = rows.length - 1; x >= 0; x--) {
					ReadingListEntry.remove(rows[x], getSelectedStudent());
					((ReadingListTableModel) getJTableReadingList().getModel()).tableChanged();
				}
			}
		}
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
			setTitle("Homeschool Tracker [" + s.getFullName().trim() + "]");
			refreshCalenders();
			setTabsEnabled(true);
			getJTabbedPaneTabs().setSelectedIndex(2);
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
	 * Event: Options -> Configure Subjects
	 * 
	 * @param event
	 */
	private void jMenuItemOptionsConfigureSubjectsActionActionPerformed(ActionEvent event) {
		SubjectManager sm = new SubjectManager(this);
		sm.setVisible(true);
	}

	/**
	 * Event: Curriculum tab shown.
	 * 
	 * @param event
	 */
	private void jPanelCurriculumComponentComponentShown(ComponentEvent event) {
		getJTableCurriculum().setModel(curriculumTableModel);
	}

	/**
	 * Event: Reading List tab shown.
	 * 
	 * @param event
	 */
	private void jPanelReadingListComponentComponentShown(ComponentEvent event) {
		if (getSelectedStudent() != null) {
			readingListTableModel.setStudent(getSelectedStudent());
			getJTableReadingList().setModel(readingListTableModel);
			getJTableReadingList().repaint();
		}
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
			getJLabelYear().setText(getSelectedYear().toString() + " - " + (getSelectedYear() + 1));
		}
		if (getSelectedDay() == null) {
			loadDay(Calendar.getInstance());
		}
	}

	/**
	 * Event: Attendance changed.
	 * 
	 * @param event
	 */
	private void jRadioButtonHadSchoolItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setHadSchool(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Event: Attendance changed.
	 * 
	 * @param event
	 */
	private void jRadioButtonSickItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setSickDay(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Event: Attendance changed.
	 * 
	 * @param event
	 */
	private void jRadioButtonVacationItemItemStateChanged(ItemEvent event) {
		if (getSelectedDay() != null) {
			getSelectedDay().setVacationDay(event.getStateChange() == ItemEvent.SELECTED);
		}
	}

	/**
	 * Loads the given day from the database and updates the form.
	 * 
	 * @param cal
	 *            a calendar set to the requested day
	 */
	private void loadDay(Calendar cal) {
		if (getSelectedDay() != null) {
			Day.save(getSelectedDay());
			if (!getJTextFieldFieldTripDescription().getText().isEmpty()) {
				if (getSelectedFieldTrip() == null) {
					setSelectedFieldTrip(new FieldTrip(getJTextFieldFieldTripDescription().getText().trim(),
							getJTextFieldFieldTripLocation().getText().trim(), getJTextPaneFieldTripNotes().getText(),
							getSelectedDay()));
				} else {
					getSelectedFieldTrip().setWhat(getJTextFieldFieldTripDescription().getText().trim());
					getSelectedFieldTrip().setLocation(getJTextFieldFieldTripLocation().getText().trim());
					getSelectedFieldTrip().setNotes(getJTextPaneFieldTripNotes().getText());
					
				}
				FieldTrip.save(getSelectedFieldTrip());
			} else if (getSelectedFieldTrip() != null && getJTextFieldFieldTripDescription().getText().isEmpty()) {
				FieldTrip.remove(getSelectedFieldTrip());
			}
		}

		clearAllTableSelections(cal.get(Calendar.MONTH) + 1);

		// load day details
		setSelectedDay(Day.get(cal.getTime()));
		((TitledBorder) getJPanelDayDetails().getBorder()).setTitle("Details for " + dateFormat.format(getSelectedDay().getDate()));
		getJRadioButtonHadSchool().setSelected(getSelectedDay().hadSchool());
		getJCheckBoxCoOp().setSelected(getSelectedDay().isCoopDay());
		getJRadioButtonSick().setSelected(getSelectedDay().isSickDay());
		getJRadioButtonVacation().setSelected(getSelectedDay().isVacationDay());
		if (!getSelectedDay().isCoopDay() && !getSelectedDay().isSickDay() && !getSelectedDay().isVacationDay()) {
			buttonGroupAttendance.clearSelection();
		}

		// load field trip details
		setSelectedFieldTrip(FieldTrip.get(getSelectedDay().getDate()));
		if (getSelectedFieldTrip() != null) {
			getJTextFieldFieldTripDescription().setText(getSelectedFieldTrip().getWhat());
			getJTextFieldFieldTripLocation().setText(getSelectedFieldTrip().getLocation());
			getJTextPaneFieldTripNotes().setText(getSelectedFieldTrip().getNotes());
		} else {
			getJTextFieldFieldTripDescription().setText("");
			getJTextFieldFieldTripLocation().setText("");
			getJTextPaneFieldTripNotes().setText("");
		}
		getJPanelYear().repaint();
	}

	/**
	 * Loads the given day from the database and updates the form.
	 * 
	 * @param date
	 *            the day of the month
	 * @param month
	 *            the month of the year
	 * @param year
	 *            the year
	 */
	private void loadDay(Integer date, Integer month, Integer year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, date);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.YEAR, year);
		loadDay(cal);
	}

	/**
	 * Updates all the calendars for the selected year.
	 */
	private void refreshCalenders() {
		getJTableJune().setModel(new MonthTableModel(6, getSelectedYear()));
		getJTableJuly().setModel(new MonthTableModel(7, getSelectedYear()));
		getJTableAugust().setModel(new MonthTableModel(8, getSelectedYear()));
		getJTableSeptember().setModel(new MonthTableModel(9, getSelectedYear()));
		getJTableOctober().setModel(new MonthTableModel(10, getSelectedYear()));
		getJTableNovember().setModel(new MonthTableModel(11, getSelectedYear()));
		getJTableDecember().setModel(new MonthTableModel(12, getSelectedYear()));
		getJTableJanuary().setModel(new MonthTableModel(1, getSelectedYear() + 1));
		getJTableFebruary().setModel(new MonthTableModel(2, getSelectedYear() + 1));
		getJTableMarch().setModel(new MonthTableModel(3, getSelectedYear() + 1));
		getJTableApril().setModel(new MonthTableModel(4, getSelectedYear() + 1));
		getJTableMay().setModel(new MonthTableModel(5, getSelectedYear() + 1));
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
	 * @param selectedFieldTrip
	 *            the selectedFieldTrip to set
	 */
	public void setSelectedFieldTrip(FieldTrip selectedFieldTrip) {
		_selectedFieldTrip = selectedFieldTrip;
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

	/**
	 * Enables/disables tabs that require a selected student.
	 * 
	 * @param value
	 *            true, if tabs should be enabled
	 */
	private void setTabsEnabled(Boolean value) {
		getJTabbedPaneTabs().setEnabledAt(2, value);
		getJTabbedPaneTabs().setEnabledAt(3, value);
		getJTabbedPaneTabs().setEnabledAt(4, value);
	}

	private void jButtonAssignmentsAddActionActionPerformed(ActionEvent event) {
		Assignment.save(new Assignment(getSelectedStudent()));
		((AssignmentTableModel) getJTableAssignments().getModel()).tableChanged();
	}

	private void jButtonAssignmentsDeleteActionActionPerformed(ActionEvent event) {
		if (getJTableAssignments().getSelectedRowCount() > 0) {
			int[] rows = getJTableAssignments().getSelectedRows();
			StringBuilder titles = new StringBuilder();
			for (int row : rows) {
				titles.append((String) getJTableAssignments().getValueAt(row, 1));
				titles.append('\n');
			}

			int n = JOptionPane.showConfirmDialog(this, "Delete the following assignments?\n\n" + titles.toString(),
					"Are you sure?", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				for (int x = rows.length - 1; x >= 0; x--) {
					Assignment.remove(rows[x], getSelectedStudent());
					((AssignmentTableModel) getJTableAssignments().getModel()).tableChanged();
				}
			}
		}
	}

	private void jPanelAssignmentsComponentComponentShown(ComponentEvent event) {
		if (getSelectedStudent() != null) {
			assignmentTableModel.setStudent(getSelectedStudent());
			getJTableAssignments().setModel(assignmentTableModel);
			getJTableAssignments().getColumnModel().getColumn(0).setCellEditor(new SubjectCellEditor());
			getJTableAssignments().repaint();
		}
	}
}
package ht.view;

import ht.model.swing.MonthTableModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

/**
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * 
 */
public class MainFrame2 extends JFrame {
	/**
	 * generated
	 */
	private static final long serialVersionUID = -4223242930559247952L;
	private JPanel _contentPane;
	private JMenuBar menuBarMain;
	private JMenu _mnFile;
	private JMenuItem _mntmExit;
	private JMenu _mnOptions;
	private JLabel labelStatus;
	private JTabbedPane tabbedPaneTabs;
	private JPanel _panelStudents;
	private JPanel _panelCurriculum;
	private JPanel _panelYear;
	private JPanel _panelReadingList;
	private JPanel _panelAssignments;
	private JScrollPane _scrollPaneStudentList;
	private JList _listStudentList;
	private JPanel _panelStudentsButtons;
	private JButton _buttonAdd;
	private JButton _buttonOpen;
	private JButton _buttonEdit;
	private JButton _buttonDelete;
	private JScrollPane _scrollPaneCurriculum;
	private JTable _tableCurriculum;
	private JPanel _panelYearForm;
	private JPanel _panelYearCalendar;
	private JPanel _panelYearCalendarSelector;
	private JButton _buttonPrevYear;
	private JButton _buttonNextYear;
	private JLabel _labelYear;
	private JPanel _panelYearCalendarMonths;
	private JPanel _panelJune;
	private JPanel _panelOctober;
	private JPanel _panelFebruary;
	private JPanel _panelJuly;
	private JPanel _panelNovember;
	private JPanel _panelMarch;
	private JPanel _panelAugust;
	private JPanel _panelDecember;
	private JPanel _panelApril;
	private JPanel _panelSeptember;
	private JPanel _panelJanuary;
	private JPanel _panelMay;
	private JLabel _labelJune;
	private JLabel _labelOctober;
	private JLabel _labelFebruary;
	private JLabel _labelJuly;
	private JLabel _labelNovember;
	private JLabel _labelMarch;
	private JLabel _labelAugust;
	private JLabel _labelDecember;
	private JLabel _labelApril;
	private JLabel _labelSeptember;
	private JLabel _labelJanuary;
	private JLabel _labelMay;
	private JTable _tableJune;
	private JScrollPane _scrollPaneJune;
	private JScrollPane _scrollPaneOctober;
	private JScrollPane _scrollPaneFebruary;
	private JScrollPane _scrollPaneJuly;
	private JScrollPane _scrollPaneNovember;
	private JScrollPane _scrollPaneMarch;
	private JScrollPane _scrollPaneAugust;
	private JScrollPane _scrollPaneDecember;
	private JScrollPane _scrollPaneApril;
	private JScrollPane _scrollPaneSeptember;
	private JScrollPane _scrollPaneJanuary;
	private JScrollPane _scrollPaneMay;
	private JTable _tableOctober;
	private JTable _tableFebruary;
	private JTable _tableJuly;
	private JTable _tableNovember;
	private JTable _tableMarch;
	private JTable _tableAugust;
	private JTable _tableDecember;
	private JTable _tableApril;
	private JTable _tableSeptember;
	private JTable _tableJanuary;
	private JTable _tableMay;
	private JPanel _panelAttendance;
	private JRadioButton _radioButton;
	private JCheckBox _checkBox;
	private JRadioButton _radioButton_1;
	private JRadioButton _radioButton_2;
	private JRadioButton _radioButton_3;
	private JPanel _panelFieldTrip;
	private JPanel _panelFieldTripTextFields;
	private JLabel _labelFieldTripDescription;
	private JTextField _textFieldFieldTripDescription;
	private JLabel _labelFieldTripLocation;
	private JTextField _textFieldFieldTripLocation;
	private JPanel _panelFieldTripNotes;
	private JScrollPane _scrollPaneFieldTripNotes;
	private JTextArea _textAreaFieldTripNotes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame2 frame = new MainFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame2() {
		setTitle("Homeschool Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 792);

		menuBarMain = new JMenuBar();
		setJMenuBar(menuBarMain);

		_mnFile = new JMenu("File");
		_mnFile.setMnemonic('F');
		menuBarMain.add(_mnFile);

		_mntmExit = new JMenuItem("Exit");
		_mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		_mntmExit.setMnemonic('X');
		_mnFile.add(_mntmExit);

		_mnOptions = new JMenu("Options");
		menuBarMain.add(_mnOptions);
		_contentPane = new JPanel();
		_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		_contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(_contentPane);

		labelStatus = new JLabel("");
		_contentPane.add(labelStatus, BorderLayout.SOUTH);

		tabbedPaneTabs = new JTabbedPane(JTabbedPane.TOP);
		_contentPane.add(tabbedPaneTabs, BorderLayout.CENTER);

		_panelStudents = new JPanel();
		tabbedPaneTabs.addTab("Students", null, _panelStudents, null);
		_panelStudents.setLayout(new BorderLayout(0, 0));

		_scrollPaneStudentList = new JScrollPane();
		_panelStudents.add(_scrollPaneStudentList);

		_listStudentList = new JList();
		_scrollPaneStudentList.setViewportView(_listStudentList);

		_panelStudentsButtons = new JPanel();
		_panelStudents.add(_panelStudentsButtons, BorderLayout.EAST);
		_panelStudentsButtons.setLayout(new GridLayout(0, 1, 0, 0));

		_buttonAdd = new JButton("Add");
		_panelStudentsButtons.add(_buttonAdd);

		_buttonOpen = new JButton("Open");
		_panelStudentsButtons.add(_buttonOpen);

		_buttonEdit = new JButton("Edit");
		_panelStudentsButtons.add(_buttonEdit);

		_buttonDelete = new JButton("Delete");
		_panelStudentsButtons.add(_buttonDelete);

		_panelCurriculum = new JPanel();
		tabbedPaneTabs.addTab("Curriculum", null, _panelCurriculum, null);
		_panelCurriculum.setLayout(new BorderLayout(0, 0));

		_scrollPaneCurriculum = new JScrollPane();
		_panelCurriculum.add(_scrollPaneCurriculum);

		_tableCurriculum = new JTable();
		_tableCurriculum.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Title", "Author", "URL", "Notes" }));
		_scrollPaneCurriculum.setViewportView(_tableCurriculum);

		_panelYear = new JPanel();
		tabbedPaneTabs.addTab("Year", null, _panelYear, null);
		_panelYear.setLayout(new GridLayout(1, 1, 0, 0));

		_panelYearCalendar = new JPanel();
		_panelYear.add(_panelYearCalendar);
		_panelYearCalendar.setLayout(new BorderLayout(0, 0));

		_panelYearCalendarSelector = new JPanel();
		_panelYearCalendar.add(_panelYearCalendarSelector, BorderLayout.NORTH);
		_panelYearCalendarSelector.setLayout(new BorderLayout(0, 0));

		_buttonPrevYear = new JButton("<");
		_panelYearCalendarSelector.add(_buttonPrevYear, BorderLayout.WEST);

		_buttonNextYear = new JButton(">");
		_panelYearCalendarSelector.add(_buttonNextYear, BorderLayout.EAST);

		_labelYear = new JLabel("-");
		_labelYear.setFont(new Font("Dialog", Font.BOLD, 16));
		_labelYear.setHorizontalAlignment(SwingConstants.CENTER);
		_panelYearCalendarSelector.add(_labelYear, BorderLayout.CENTER);

		_panelYearCalendarMonths = new JPanel();
		_panelYearCalendar.add(_panelYearCalendarMonths, BorderLayout.CENTER);
		_panelYearCalendarMonths.setLayout(new GridLayout(4, 3, 0, 0));

		_panelJune = new JPanel();
		_panelYearCalendarMonths.add(_panelJune);
		_panelJune.setLayout(new BorderLayout(0, 0));

		_labelJune = new JLabel("June");
		_labelJune.setHorizontalAlignment(SwingConstants.CENTER);
		_panelJune.add(_labelJune, BorderLayout.NORTH);

		_scrollPaneJune = new JScrollPane();
		_panelJune.add(_scrollPaneJune, BorderLayout.CENTER);

		_tableJune = new JTable();
		_scrollPaneJune.setViewportView(_tableJune);

		_panelOctober = new JPanel();
		_panelYearCalendarMonths.add(_panelOctober);
		_panelOctober.setLayout(new BorderLayout(0, 0));

		_labelOctober = new JLabel("October");
		_labelOctober.setHorizontalAlignment(SwingConstants.CENTER);
		_panelOctober.add(_labelOctober, BorderLayout.NORTH);

		_scrollPaneOctober = new JScrollPane();
		_panelOctober.add(_scrollPaneOctober, BorderLayout.CENTER);

		_tableOctober = new JTable();
		_scrollPaneOctober.setViewportView(_tableOctober);

		_panelFebruary = new JPanel();
		_panelYearCalendarMonths.add(_panelFebruary);
		_panelFebruary.setLayout(new BorderLayout(0, 0));

		_labelFebruary = new JLabel("February");
		_labelFebruary.setHorizontalAlignment(SwingConstants.CENTER);
		_panelFebruary.add(_labelFebruary, BorderLayout.NORTH);

		_scrollPaneFebruary = new JScrollPane();
		_panelFebruary.add(_scrollPaneFebruary, BorderLayout.CENTER);

		_tableFebruary = new JTable();
		_scrollPaneFebruary.setViewportView(_tableFebruary);

		_panelJuly = new JPanel();
		_panelYearCalendarMonths.add(_panelJuly);
		_panelJuly.setLayout(new BorderLayout(0, 0));

		_labelJuly = new JLabel("July");
		_labelJuly.setHorizontalAlignment(SwingConstants.CENTER);
		_panelJuly.add(_labelJuly, BorderLayout.NORTH);

		_scrollPaneJuly = new JScrollPane();
		_panelJuly.add(_scrollPaneJuly, BorderLayout.CENTER);

		_tableJuly = new JTable();
		_scrollPaneJuly.setViewportView(_tableJuly);

		_panelNovember = new JPanel();
		_panelYearCalendarMonths.add(_panelNovember);
		_panelNovember.setLayout(new BorderLayout(0, 0));

		_labelNovember = new JLabel("November");
		_labelNovember.setHorizontalAlignment(SwingConstants.CENTER);
		_panelNovember.add(_labelNovember, BorderLayout.NORTH);

		_scrollPaneNovember = new JScrollPane();
		_panelNovember.add(_scrollPaneNovember, BorderLayout.CENTER);

		_tableNovember = new JTable();
		_scrollPaneNovember.setViewportView(_tableNovember);

		_panelMarch = new JPanel();
		_panelYearCalendarMonths.add(_panelMarch);
		_panelMarch.setLayout(new BorderLayout(0, 0));

		_labelMarch = new JLabel("March");
		_labelMarch.setHorizontalAlignment(SwingConstants.CENTER);
		_panelMarch.add(_labelMarch, BorderLayout.NORTH);

		_scrollPaneMarch = new JScrollPane();
		_panelMarch.add(_scrollPaneMarch, BorderLayout.CENTER);

		_tableMarch = new JTable();
		_scrollPaneMarch.setViewportView(_tableMarch);

		_panelAugust = new JPanel();
		_panelYearCalendarMonths.add(_panelAugust);
		_panelAugust.setLayout(new BorderLayout(0, 0));

		_labelAugust = new JLabel("August");
		_labelAugust.setHorizontalAlignment(SwingConstants.CENTER);
		_panelAugust.add(_labelAugust, BorderLayout.NORTH);

		_scrollPaneAugust = new JScrollPane();
		_panelAugust.add(_scrollPaneAugust, BorderLayout.CENTER);

		_tableAugust = new JTable();
		_scrollPaneAugust.setViewportView(_tableAugust);

		_panelDecember = new JPanel();
		_panelYearCalendarMonths.add(_panelDecember);
		_panelDecember.setLayout(new BorderLayout(0, 0));

		_labelDecember = new JLabel("December");
		_labelDecember.setHorizontalAlignment(SwingConstants.CENTER);
		_panelDecember.add(_labelDecember, BorderLayout.NORTH);

		_scrollPaneDecember = new JScrollPane();
		_panelDecember.add(_scrollPaneDecember, BorderLayout.CENTER);

		_tableDecember = new JTable();
		_scrollPaneDecember.setViewportView(_tableDecember);

		_panelApril = new JPanel();
		_panelYearCalendarMonths.add(_panelApril);
		_panelApril.setLayout(new BorderLayout(0, 0));

		_labelApril = new JLabel("April");
		_labelApril.setHorizontalAlignment(SwingConstants.CENTER);
		_panelApril.add(_labelApril, BorderLayout.NORTH);

		_scrollPaneApril = new JScrollPane();
		_panelApril.add(_scrollPaneApril, BorderLayout.CENTER);

		_tableApril = new JTable();
		_scrollPaneApril.setViewportView(_tableApril);

		_panelSeptember = new JPanel();
		_panelYearCalendarMonths.add(_panelSeptember);
		_panelSeptember.setLayout(new BorderLayout(0, 0));

		_labelSeptember = new JLabel("September");
		_labelSeptember.setHorizontalAlignment(SwingConstants.CENTER);
		_panelSeptember.add(_labelSeptember, BorderLayout.NORTH);

		_scrollPaneSeptember = new JScrollPane();
		_panelSeptember.add(_scrollPaneSeptember, BorderLayout.CENTER);

		_tableSeptember = new JTable();
		_scrollPaneSeptember.setViewportView(_tableSeptember);

		_panelJanuary = new JPanel();
		_panelYearCalendarMonths.add(_panelJanuary);
		_panelJanuary.setLayout(new BorderLayout(0, 0));

		_labelJanuary = new JLabel("January");
		_labelJanuary.setHorizontalAlignment(SwingConstants.CENTER);
		_panelJanuary.add(_labelJanuary, BorderLayout.NORTH);

		_scrollPaneJanuary = new JScrollPane();
		_panelJanuary.add(_scrollPaneJanuary, BorderLayout.CENTER);

		_tableJanuary = new JTable();
		_scrollPaneJanuary.setViewportView(_tableJanuary);

		_panelMay = new JPanel();
		_panelYearCalendarMonths.add(_panelMay);
		_panelMay.setLayout(new BorderLayout(0, 0));

		_labelMay = new JLabel("May");
		_labelMay.setHorizontalAlignment(SwingConstants.CENTER);
		_panelMay.add(_labelMay, BorderLayout.NORTH);

		_scrollPaneMay = new JScrollPane();
		_panelMay.add(_scrollPaneMay, BorderLayout.CENTER);

		_tableMay = new JTable();
		_scrollPaneMay.setViewportView(_tableMay);

		_panelYearForm = new JPanel();
		_panelYearForm.setBorder(new TitledBorder(null, "Details for", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_panelYear.add(_panelYearForm);
		_panelYearForm.setLayout(new BorderLayout(0, 0));

		_panelAttendance = new JPanel();
		_panelYearForm.add(_panelAttendance, BorderLayout.NORTH);

		_radioButton = new JRadioButton("Had School");
		_panelAttendance.add(_radioButton);

		_checkBox = new JCheckBox("Co-Op");
		_panelAttendance.add(_checkBox);

		_radioButton_1 = new JRadioButton("Sick");
		_panelAttendance.add(_radioButton_1);

		_radioButton_2 = new JRadioButton("Vacation");
		_panelAttendance.add(_radioButton_2);

		_radioButton_3 = new JRadioButton("No School");
		_panelAttendance.add(_radioButton_3);

		_panelFieldTrip = new JPanel();
		_panelFieldTrip.setBorder(new TitledBorder(null, "Field Trip", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_panelYearForm.add(_panelFieldTrip, BorderLayout.CENTER);
		_panelFieldTrip.setLayout(new BorderLayout(0, 0));

		_panelFieldTripTextFields = new JPanel();
		_panelFieldTrip.add(_panelFieldTripTextFields, BorderLayout.NORTH);
		GridBagLayout gbl_panelFieldTripTextFields = new GridBagLayout();
		gbl_panelFieldTripTextFields.columnWidths = new int[] { 86, 86, 0 };
		gbl_panelFieldTripTextFields.rowHeights = new int[] { 20, 20, 0 };
		gbl_panelFieldTripTextFields.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelFieldTripTextFields.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		_panelFieldTripTextFields.setLayout(gbl_panelFieldTripTextFields);

		_labelFieldTripDescription = new JLabel("Description");
		GridBagConstraints gbc_labelFieldTripDescription = new GridBagConstraints();
		gbc_labelFieldTripDescription.fill = GridBagConstraints.BOTH;
		gbc_labelFieldTripDescription.insets = new Insets(0, 5, 5, 5);
		gbc_labelFieldTripDescription.gridx = 0;
		gbc_labelFieldTripDescription.gridy = 0;
		_panelFieldTripTextFields.add(_labelFieldTripDescription, gbc_labelFieldTripDescription);

		_textFieldFieldTripDescription = new JTextField();
		GridBagConstraints gbc_textFieldFieldTripDescription = new GridBagConstraints();
		gbc_textFieldFieldTripDescription.fill = GridBagConstraints.BOTH;
		gbc_textFieldFieldTripDescription.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFieldTripDescription.gridx = 1;
		gbc_textFieldFieldTripDescription.gridy = 0;
		_panelFieldTripTextFields.add(_textFieldFieldTripDescription, gbc_textFieldFieldTripDescription);
		_textFieldFieldTripDescription.setColumns(10);

		_labelFieldTripLocation = new JLabel("Location");
		GridBagConstraints gbc_labelFieldTripLocation = new GridBagConstraints();
		gbc_labelFieldTripLocation.fill = GridBagConstraints.BOTH;
		gbc_labelFieldTripLocation.insets = new Insets(0, 5, 0, 5);
		gbc_labelFieldTripLocation.gridx = 0;
		gbc_labelFieldTripLocation.gridy = 1;
		_panelFieldTripTextFields.add(_labelFieldTripLocation, gbc_labelFieldTripLocation);

		_textFieldFieldTripLocation = new JTextField();
		GridBagConstraints gbc_textFieldFieldTripLocation = new GridBagConstraints();
		gbc_textFieldFieldTripLocation.fill = GridBagConstraints.BOTH;
		gbc_textFieldFieldTripLocation.gridx = 1;
		gbc_textFieldFieldTripLocation.gridy = 1;
		_panelFieldTripTextFields.add(_textFieldFieldTripLocation, gbc_textFieldFieldTripLocation);
		_textFieldFieldTripLocation.setColumns(10);

		_panelFieldTripNotes = new JPanel();
		_panelFieldTripNotes.setBorder(new TitledBorder(null, "Notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_panelFieldTrip.add(_panelFieldTripNotes);
		_panelFieldTripNotes.setLayout(new BorderLayout(0, 0));

		_scrollPaneFieldTripNotes = new JScrollPane();
		_panelFieldTripNotes.add(_scrollPaneFieldTripNotes);

		_textAreaFieldTripNotes = new JTextArea();
		_scrollPaneFieldTripNotes.setViewportView(_textAreaFieldTripNotes);

		_panelReadingList = new JPanel();
		tabbedPaneTabs.addTab("Reading List", null, _panelReadingList, null);

		_panelAssignments = new JPanel();
		tabbedPaneTabs.addTab("Assignments", null, _panelAssignments, null);
	}

}

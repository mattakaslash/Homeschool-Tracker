package ht.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
	
	private JMenuItem jMenuItemFileExit;
	private JMenu jMenuFile;
	private JMenuBar jMenuBarMain;
	private JLabel jLabelStatus;

	/**
	 * Defines a new frame.
	 */
	public MainFrame() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Homeschool Tracker");
		add(getJLabelStatus(), BorderLayout.SOUTH);
		setJMenuBar(getJMenuBarMain());
		setSize(800, 600);
	}

	private JLabel getJLabelStatus() {
		if (jLabelStatus == null) {
			jLabelStatus = new JLabel();
		}
		return jLabelStatus;
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
	
	/**
	 * Event: File > Exit clicked.
	 * @param event
	 */
	private void jMenuItemFileExitActionActionPerformed(ActionEvent event) {
		this.dispose();
	}
}
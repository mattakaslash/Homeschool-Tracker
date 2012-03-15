/**
 * 
 */
package ht.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * Defines a splash screen to display while the application loads.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
//VS4E -- DO NOT REMOVE THIS LINE!
public class SplashScreen extends JDialog {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = -6342652642815498778L;
	private JLabel jLabelTmp;
	private JPanel jPanelImage;
	private JProgressBar jProgressBarActivity;

	/**
	 * Defines the splash screen.
	 */
	public SplashScreen() {
		initComponents();
	}

	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setForeground(Color.black);
		setUndecorated(true);
		add(getJProgressBarActivity(), BorderLayout.SOUTH);
		add(getJPanelImage(), BorderLayout.CENTER);
		setSize(320, 240);
	}

	private JProgressBar getJProgressBarActivity() {
		if (jProgressBarActivity == null) {
			jProgressBarActivity = new JProgressBar();
			jProgressBarActivity.setIndeterminate(true);
		}
		return jProgressBarActivity;
	}

	private JPanel getJPanelImage() {
		if (jPanelImage == null) {
			jPanelImage = new JPanel();
			jPanelImage.setLayout(new BorderLayout());
			jPanelImage.add(getJLabelTmp(), BorderLayout.CENTER);
		}
		return jPanelImage;
	}

	private JLabel getJLabelTmp() {
		if (jLabelTmp == null) {
			jLabelTmp = new JLabel();
			jLabelTmp.setText("Loading...");
		}
		return jLabelTmp;
	}
}

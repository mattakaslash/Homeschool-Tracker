/**
 * 
 */
package ht.view;

import ht.HomeschoolTracker;
import ht.model.ConfigurationEntry;
import ht.model.Subject;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * Shows a progress bar indicating the completion of database initialization.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class InitFrame extends JDialog {
	class Task extends SwingWorker<Void, Void> {
		private String _command;

		@Override
		protected Void doInBackground() throws Exception {
			EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
			String connStr = (String) em.getProperties().get("javax.persistence.jdbc.url");
			Connection conn = DriverManager.getConnection(connStr);
			Statement s = conn.createStatement();

			InputStream in = new FileInputStream("createDDL.jdbc");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			List<String> commands = new ArrayList<String>();

			while ((line = br.readLine()) != null) {
				commands.add(line);
			}
			getJProgressBarInit().setMaximum(commands.size() + 1);
			setProgress(0);

			for (String cmd : commands) {
				s.executeUpdate(cmd);
				setCommand(cmd.substring(0, cmd.indexOf(' ', cmd.indexOf(' ') + 1)));
				setProgress(getProgress() + 1);
			}

			Subject root = new Subject("");
			em.getTransaction().begin();
			em.persist(new ConfigurationEntry("VERSION", "1.0"));
			em.persist(root);
			em.getTransaction().commit();
			setCommand("INSERT ENTITIES");
			setProgress(getProgress() + 1);

			conn.close();
			em.close();
			return null;
		}

		@Override
		protected void done() {
			dispose();
		}

		public String getCommand() {
			return _command;
		}

		private void setCommand(String cmd) {
			_command = cmd;
		}

	}

	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 4711432712290749464L;

	private JProgressBar jProgressBarInit;

	/**
	 * Creates the frame.
	 */
	public InitFrame() {
		initComponents();
		Task t = new Task();
		t.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				taskPropertyChange(evt);
			}
		});
		t.execute();
	}

	private JProgressBar getJProgressBarInit() {
		if (jProgressBarInit == null) {
			jProgressBarInit = new JProgressBar();
			jProgressBarInit.setMinimum(0);
			jProgressBarInit.setStringPainted(true);
			jProgressBarInit.setString("");
		}
		return jProgressBarInit;
	}

	private void initComponents() {
		setTitle("Initializing Database");
		add(getJProgressBarInit(), BorderLayout.CENTER);
		setModal(true);
		pack();
	}

	private void taskPropertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().contentEquals("progress")) {
			int progress = (Integer) evt.getNewValue();
			getJProgressBarInit().setString(
					"Step " + progress + " of " + getJProgressBarInit().getMaximum() + " (" + ((Task) evt.getSource()).getCommand()
							+ ")");
			getJProgressBarInit().setValue(progress);
			pack();
		}
	}
}

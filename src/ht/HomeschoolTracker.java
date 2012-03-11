/**
 * 
 */
package ht;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import ht.view.InitFrame;
import ht.view.MainFrame;
import ht.view.SplashScreen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * Main application launcher.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class HomeschoolTracker {
	private static EntityManagerFactory factory;

	/**
	 * @return the factory
	 */
	public static EntityManagerFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public static void setFactory(EntityManagerFactory factory) {
		HomeschoolTracker.factory = factory;
	}

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {
		setFactory(Persistence.createEntityManagerFactory("records"));
		SplashScreen splash = new SplashScreen();
		splash.setLocationRelativeTo(null);
		try {
			splash.setVisible(true);
			boolean dbExists = databaseExists();
			splash.setVisible(false);
			splash.dispose();
			if (!dbExists) {
				InitFrame frame = new InitFrame();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null, "Caught an exception trying to initialize the database: " + e.getLocalizedMessage());
			e.printStackTrace();
			return;
		}
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static boolean databaseExists() throws SQLException {
		EntityManager em = getFactory().createEntityManager();
		String connStr = (String) em.getProperties().get("javax.persistence.jdbc.url");
		Connection conn = DriverManager.getConnection(connStr);
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet rs = dbmd.getTables(null, null, "CONFIGURATIONENTRY", null);
		boolean result = rs.next();
		conn.close();
		em.close();
		return result;
	}
}

/**
 * 
 */
package ht;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ht.model.ConfigurationEntry;
import ht.view.MainFrame;

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
		try {
			createOrUpgradeDB();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Encountered SQLException while trying to create or upgrade the database.\n\n" + e.getLocalizedMessage());
			e.printStackTrace();
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Encountered IOException while trying to create or upgrade the database.\n\n" + e.getLocalizedMessage());
			e.printStackTrace();
			return;
		}
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static void createOrUpgradeDB() throws SQLException, IOException {
		EntityManager em = getFactory().createEntityManager();
		String connStr = (String) em.getProperties().get("javax.persistence.jdbc.url");
		Connection conn	= DriverManager.getConnection(connStr);
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet rs = dbmd.getTables(null, "APP", "CONFIGURATIONENTRY", null);
		if(!rs.next()) {
			// no ConfigurationEntry table exists; we must create the tables
			Statement s = conn.createStatement();
			InputStream in = new FileInputStream("createDDL.jdbc");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				s.executeUpdate(line);
			}
			
			em.getTransaction().begin();
			em.persist(new ConfigurationEntry("VERSION", "1.0"));
			em.getTransaction().commit();
		}
		conn.close();
		em.close();
	}
}

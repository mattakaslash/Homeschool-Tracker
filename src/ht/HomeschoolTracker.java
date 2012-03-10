/**
 * 
 */
package ht;

import ht.view.MainFrame;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		createOrUpgradeDB();
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static void createOrUpgradeDB() {
		EntityManager em = getFactory().createEntityManager();
		em.close();
	}
}

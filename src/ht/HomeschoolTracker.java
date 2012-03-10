/**
 * 
 */
package ht;

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
	 * @param args unused
	 */
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory("records");
	}
}

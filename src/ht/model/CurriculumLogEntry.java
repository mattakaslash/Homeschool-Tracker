/**
 * 
 */
package ht.model;

import ht.HomeschoolTracker;

import java.net.URL;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Query;

/**
 * Models an entry in the curriculum materials log.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class CurriculumLogEntry {
	/**
	 * Adds a new, blank log entry to the database.
	 */
	public static void add() {
		save(new CurriculumLogEntry());
	}

	/**
	 * Returns a particular entry by line number.
	 * 
	 * @param index
	 *            the index
	 * @return the entry
	 */
	public static CurriculumLogEntry get(int index) {
		return (CurriculumLogEntry) getAll().toArray()[index];
	}

	/**
	 * Returns a list of all curriculum log entries, sorted by title.
	 * 
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static List<CurriculumLogEntry> getAll() {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT l FROM CurriculumLogEntry l ORDER BY l._title");
		List<CurriculumLogEntry> result = q.getResultList();
		em.close();

		return result;
	}

	/**
	 * Deletes the entry at the specific index.
	 * 
	 * @param index the index
	 */
	public static void remove(int index) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		CurriculumLogEntry entry = em.merge(get(index));
		em.getTransaction().begin();
		em.remove(entry);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Saves the given entry to the database.
	 * 
	 * @param entry
	 *            the entry
	 */
	public static void save(CurriculumLogEntry entry) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(entry);
		em.getTransaction().commit();
		em.close();
	}

	@Column(name = "AUTHOR")
	private String _author;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;

	@Lob
	@Column(name = "NOTES")
	private String _notes;

	@Column(name = "TITLE")
	private String _title;

	@Column(name = "URL")
	private URL _url;

	/**
	 * Creates a default, empty log entry.
	 */
	public CurriculumLogEntry() {
		setTitle("");
		setAuthor("");
		setURL(null);
		setNotes("");
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return _author;
	}

	/**
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return _notes;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @return the url
	 */
	public URL getURL() {
		return _url;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		_author = author;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		_notes = notes;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		_title = title;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setURL(URL url) {
		_url = url;
	}
}

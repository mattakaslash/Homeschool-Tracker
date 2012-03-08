/**
 * 
 */
package ht.model;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Models an entry in the curriculum materials log.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class CurriculumLogEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private String _title;
	private String _author;
	private URL _url;
	@Lob
	private String _notes;

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
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @return the title
	 */
	private String getTitle() {
		return _title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	private void setTitle(String title) {
		_title = title;
	}

	/**
	 * @return the author
	 */
	private String getAuthor() {
		return _author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	private void setAuthor(String author) {
		_author = author;
	}

	/**
	 * @return the url
	 */
	private URL getURL() {
		return _url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	private void setURL(URL url) {
		_url = url;
	}

	/**
	 * @return the notes
	 */
	private String getNotes() {
		return _notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	private void setNotes(String notes) {
		_notes = notes;
	}

}

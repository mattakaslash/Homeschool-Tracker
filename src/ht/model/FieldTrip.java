/**
 * 
 */
package ht.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Models a field trip.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class FieldTrip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Date _when;
	private String _what;
	private String _where;

	@Lob
	private String _notes;

	/**
	 * Creates a blank field trip for today.
	 */
	public FieldTrip() {
		setWhen(new Date());
		setWhat("");
		setWhere("");
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
	 * @return the when
	 */
	private Date getWhen() {
		return _when;
	}

	/**
	 * @param date
	 *            the when to set
	 */
	private void setWhen(Date date) {
		_when = date;
	}

	/**
	 * @return the what
	 */
	private String getWhat() {
		return _what;
	}

	/**
	 * @param what
	 *            the what to set
	 */
	private void setWhat(String what) {
		_what = what;
	}

	/**
	 * @return the where
	 */
	private String getWhere() {
		return _where;
	}

	/**
	 * @param where
	 *            the where to set
	 */
	private void setWhere(String where) {
		_where = where;
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

/**
 * 
 */
package ht.model;

import java.util.Date;

import ht.HomeschoolTracker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Query;

/**
 * Models a field trip.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class FieldTrip {
	/**
	 * Retrieves field trip details for a given {@link Day}.
	 * 
	 * @param selectedDay
	 *            the day
	 * @return the field trip
	 */
	public static FieldTrip get(Date selectedDay) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT t FROM FieldTrip t JOIN t._when w WHERE w._date = :when");
		q.setParameter("when", selectedDay);

		FieldTrip result = null;
		if (q.getResultList().size() > 0) {
			result = (FieldTrip) q.getSingleResult();
		}

		em.close();
		return result;
	}

	/**
	 * Removes the provided field trip from the database.
	 * 
	 * @param trip
	 *            the field trip
	 */
	public static void remove(FieldTrip trip) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		FieldTrip t = em.merge(trip);
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Saves the given field trip to the database.
	 * 
	 * @param trip
	 *            the field trip
	 */
	public static void save(FieldTrip trip) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(trip);
		em.getTransaction().commit();
		em.close();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;

	@Column(name = "LOCATION")
	private String _location;

	@Lob
	@Column(name = "NOTES")
	private String _notes;

	@Column(name = "WHAT")
	private String _what;

	@JoinColumn(name = "WHEN")
	@OneToOne
	private Day _when;

	/**
	 * Creates a blank field trip for today.
	 */
	public FieldTrip() {
		setWhen(new Day());
		setWhat("");
		setLocation("");
		setNotes("");
	}

	/**
	 * Creates a field trip with the given parameters.
	 * 
	 * @param what
	 *            a short description of the trip
	 * @param location
	 *            where the trip was to
	 * @param notes
	 *            a long description of the trip
	 * @param day
	 *            the day the trip occurred
	 */
	public FieldTrip(String what, String location, String notes, Day day) {
		setWhen(day);
		setWhat(what);
		setLocation(location);
		setNotes(notes);
	}

	/**
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @return the where
	 */
	public String getLocation() {
		return _location;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return _notes;
	}

	/**
	 * @return the what
	 */
	public String getWhat() {
		return _what;
	}

	/**
	 * @return the when
	 */
	private Day getWhen() {
		return _when;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @param where
	 *            the where to set
	 */
	public void setLocation(String where) {
		_location = where;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		_notes = notes;
	}

	/**
	 * @param what
	 *            the what to set
	 */
	public void setWhat(String what) {
		_what = what;
	}

	/**
	 * @param date
	 *            the when to set
	 */
	private void setWhen(Day date) {
		_when = date;
	}
}

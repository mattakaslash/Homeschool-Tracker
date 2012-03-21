/**
 * 
 */
package ht.model;

import ht.HomeschoolTracker;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Models a reading list entry.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class ReadingListEntry {
	/**
	 * Returns a specific entry by line number.
	 * 
	 * @param row
	 *            the line
	 * @param student
	 * @return the entry
	 */
	public static ReadingListEntry get(int row, Student student) {
		return (ReadingListEntry) getAll(student).get(row);
	}

	/**
	 * Returns a list of all reading list entries, ordered by date started.
	 * 
	 * @param student
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static List<ReadingListEntry> getAll(Student student) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT r FROM ReadingListEntry r JOIN r._student s WHERE s._id = :id ORDER BY r._started");
		q.setParameter("id", student.getId());
		List<ReadingListEntry> result = q.getResultList();
		em.close();

		return result;
	}

	/**
	 * Deletes the entry at the specific index.
	 * 
	 * @param index
	 *            the index
	 * @param student the student
	 */
	public static void remove(int index, Student student) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		ReadingListEntry entry = em.merge(get(index, student));
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
	public static void save(ReadingListEntry entry) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(entry);
		em.getTransaction().commit();
		em.close();
	}

	@Column(name = "ASSISTED")
	private Boolean _assisted;

	@Column(name = "AUTHOR")
	private String _author;

	@Temporal(TemporalType.DATE)
	@Column(name = "FINISHED")
	private Date _finished;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;

	@Column(name = "PROGRESS")
	private Integer _progress;

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTED")
	private Date _started;

	@JoinColumn(name = "STUDENT_ID")
	@OneToOne
	private Student _student;

	@Column(name = "TITLE")
	private String _title;

	/**
	 * Creates a default reading list entry.
	 */
	public ReadingListEntry() {
		setTitle("");
		setAuthor("");
		setStarted(new Date());
		setFinished(null);
		setProgress(0);
		setAssisted(Boolean.FALSE);
		setStudent(null);
	}

	/**
	 * Creates a default reading list entry associated to the given student.
	 * 
	 * @param student
	 *            the student
	 */
	public ReadingListEntry(Student student) {
		setTitle("");
		setAuthor("");
		setStarted(new Date());
		setFinished(null);
		setProgress(0);
		setAssisted(Boolean.FALSE);
		setStudent(student);
	}

	/**
	 * @return the assisted
	 */
	public Boolean getAssisted() {
		return _assisted;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return _author;
	}

	/**
	 * @return the finished
	 */
	public Date getFinished() {
		return _finished;
	}

	/**
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @return the progress
	 */
	public Integer getProgress() {
		return _progress;
	}

	/**
	 * @return the started
	 */
	public Date getStarted() {
		return _started;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return _student;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @param assisted
	 *            the assisted to set
	 */
	public void setAssisted(Boolean assisted) {
		_assisted = assisted;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		_author = author;
	}

	/**
	 * @param finished
	 *            the finished to set
	 */
	public void setFinished(Date finished) {
		_finished = finished;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	public void setProgress(Integer progress) {
		_progress = progress;
	}

	/**
	 * @param started
	 *            the started to set
	 */
	public void setStarted(Date started) {
		_started = started;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		_student = student;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		_title = title;
	}
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Id;

/**
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * 
 */
@Entity
public class Assignment {
	/**
	 * Returns the assignment for the student at the given index.
	 * 
	 * @param index
	 *            the index
	 * @param student
	 *            the student
	 * @return the assignment
	 */
	public static Assignment get(int index, Student student) {
		return (Assignment) getAll(student).toArray()[index];
	}

	/**
	 * Retrieves all assignments for the given student.
	 * 
	 * @param student
	 *            the student
	 * @return the list of assignments
	 */
	@SuppressWarnings("unchecked")
	public static List<Assignment> getAll(Student student) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT a FROM Assignment a JOIN a._student s WHERE s._id = :id");
		q.setParameter("id", student.getId());
		List<Assignment> result = q.getResultList();
		em.close();
		return result;
	}

	/**
	 * Removes the assignment at the given index from the database.
	 * 
	 * @param index
	 *            the index
	 * @param student
	 *            the student to which the assignment was assigned
	 */
	public static void remove(int index, Student student) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Assignment a = em.merge(get(index, student));
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Saves the given assignment back to the database.
	 * 
	 * @param assignment
	 *            the assignment
	 */
	public static void save(Assignment assignment) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(assignment);
		em.getTransaction().commit();
		em.close();
	}

	@JoinColumn(name = "CATEGORY_ID")
	@ManyToOne
	private Category _category;

	@Column(name = "DATE_ASSIGNED")
	@Temporal(TemporalType.DATE)
	private Date _dateAssigned;

	@Column(name = "DATE_COMPLETED")
	@Temporal(TemporalType.DATE)
	private Date _dateCompleted;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;

	@Column(name = "POINTS_EARNED")
	private Integer _pointsEarned;

	@Column(name = "POINTS_POSSIBLE")
	private Integer _pointsPossible;

	@JoinColumn(name = "STUDENT_ID")
	@ManyToOne
	private Student _student;
	
	@JoinColumn(name = "SUBJECT_ID")
	@ManyToOne
	private Subject _subject;

	@Column(name = "TITLE")
	private String _title;

	/**
	 * Defines a new assignment with no title, 0 points out of 1 possible, and
	 * set to today.
	 */
	public Assignment() {
		setDateAssigned(new Date());
		setDateCompleted(new Date());
		setPointsEarned(0);
		setPointsPossible(1);
		setCategory(null);
		setStudent(null);
	}

	/**
	 * Defines a new assignment with no title, 0 points out of 1 possible, set
	 * to today, and assigned to the given student.
	 * 
	 * @param student
	 *            the student
	 */
	public Assignment(Student student) {
		setDateAssigned(new Date());
		setDateCompleted(new Date());
		setPointsEarned(0);
		setPointsPossible(1);
		setCategory(null);
		setStudent(student);
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return _category;
	}

	/**
	 * @return the dateAssigned
	 */
	public Date getDateAssigned() {
		return _dateAssigned;
	}

	/**
	 * @return the dateCompleted
	 */
	public Date getDateCompleted() {
		return _dateCompleted;
	}

	/**
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @return the pointsEarned
	 */
	public Integer getPointsEarned() {
		return _pointsEarned;
	}

	/**
	 * @return the pointsPossible
	 */
	public Integer getPointsPossible() {
		return _pointsPossible;
	}

	/**
	 * @return the student
	 */
	private Student getStudent() {
		return _student;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		_category = category;
	}

	/**
	 * @param dateAssigned
	 *            the dateAssigned to set
	 */
	public void setDateAssigned(Date dateAssigned) {
		_dateAssigned = dateAssigned;
	}

	/**
	 * @param dateCompleted
	 *            the dateCompleted to set
	 */
	public void setDateCompleted(Date dateCompleted) {
		_dateCompleted = dateCompleted;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @param pointsEarned
	 *            the pointsEarned to set
	 */
	public void setPointsEarned(Integer pointsEarned) {
		_pointsEarned = pointsEarned;
	}

	/**
	 * @param pointsPossible
	 *            the pointsPossible to set
	 */
	public void setPointsPossible(Integer pointsPossible) {
		_pointsPossible = pointsPossible;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	private void setStudent(Student student) {
		_student = student;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return _subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		_subject = subject;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		_title = title;
	}
}

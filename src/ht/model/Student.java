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
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Defines a student within the tracker.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class Student {
	/**
	 * @return a list of all students
	 */
	@SuppressWarnings("unchecked")
	public static List<Student> getAll() {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT s FROM Student s ORDER BY s._birthdate");
		List<Student> results = q.getResultList();
		em.close();
		return results;
	}
	
	/**
	 * Deletes the provided student.
	 * @param student the student to be deleted
	 */
	public static void remove(Student student) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Student s = em.merge(student);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Saves a given student to the database.
	 * @param student
	 */
	public static void save(Student student) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		em.close();
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE")
	private Date _birthdate;
	
	@Column(name = "FIRST_NAME")
	private String _firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;

	@Column(name = "LAST_NAME")
	private String _lastName;

	@Column(name = "MIDDLE_NAME")
	private String _middleName;

	/**
	 * Creates a new student with no name and today as the birthdate.
	 */
	public Student() {
		setFirstName("");
		setMiddleName("");
		setLastName("");
		setBirthdate(new Date());
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return _birthdate;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return _firstName;
	}

	/**
	 * Returns the student's full name as First Middle Last
	 * @return the full name
	 */
	public String getFullName() {
		String result = "";
		if (getFirstName() != null) {
			result += getFirstName();
		}
		if (getMiddleName() != null) {
			result += " " + getMiddleName();
		}
		if (getLastName() != null) {
			result += " " + getLastName();
		}
		return result;
	}

	/**
	 * @return the id
	 */
	@SuppressWarnings("unused")
	private Long getId() {
		return _id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return _lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return _middleName;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		_birthdate = birthdate;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}
	
	/**
	 * @param id the id to set
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	/* (non-javadoc)
	 * @see java.lang.Object#toString
	 */
	@Override
	public String toString() {
		String result = getFullName();
		if (getBirthdate() != null) {
			result += " Born: " + getBirthdate().toString();
		}
		return result.trim();
	}
}

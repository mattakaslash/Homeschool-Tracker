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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Column(name = "FIRST_NAME")
	private String _firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String _middleName;
	
	@Column(name = "LAST_NAME")
	private String _lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE")
	private Date _birthdate;

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
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return _firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return _middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return _lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return _birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		_birthdate = birthdate;
	}
	
	/* (non-javadoc)
	 * @see java.lang.Object#toString
	 */
	@Override
	public String toString() {
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
		return result.trim();
	}

	/**
	 * @return a list of all students
	 */
	@SuppressWarnings("unchecked")
	public static List<Student> getAll() {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT s FROM Student s");
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
}

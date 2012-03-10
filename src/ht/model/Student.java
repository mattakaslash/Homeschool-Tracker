/**
 * 
 */
package ht.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String getFirstName() {
		return _firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	private void setFirstName(String firstName) {
		_firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	private String getMiddleName() {
		return _middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	private void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	private String getLastName() {
		return _lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	private void setLastName(String lastName) {
		_lastName = lastName;
	}

	/**
	 * @return the birthdate
	 */
	private Date getBirthdate() {
		return _birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	private void setBirthdate(Date birthdate) {
		_birthdate = birthdate;
	}
}

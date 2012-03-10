/**
 * 
 */
package ht.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Id;

/**
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 *
 */
@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Column(name = "DATE_ASSIGNED")
	@Temporal(TemporalType.DATE)
	private Date _dateAssigned;
	
	@Column(name = "DATE_COMPLETED")
	@Temporal(TemporalType.DATE)
	private Date _dateCompleted;
	
	@Column(name = "POINTS_EARNED")
	private Integer _pointsEarned;
	
	@Column(name = "POINTS_POSSIBLE")
	private Integer _pointsPossible;
	
	@JoinColumn(name = "CATEGORY_ID")
	@ManyToOne
	private Category _category;
	
	@JoinColumn(name = "STUDENT_ID")
	@ManyToOne
	private Student _student;
	
	/**
	 * Defines a new assignment with no title, 0 points out of 1 possible, and set to today.
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
	 * @return the dateAssigned
	 */
	private Date getDateAssigned() {
		return _dateAssigned;
	}

	/**
	 * @param dateAssigned the dateAssigned to set
	 */
	private void setDateAssigned(Date dateAssigned) {
		_dateAssigned = dateAssigned;
	}

	/**
	 * @return the dateCompleted
	 */
	private Date getDateCompleted() {
		return _dateCompleted;
	}

	/**
	 * @param dateCompleted the dateCompleted to set
	 */
	private void setDateCompleted(Date dateCompleted) {
		_dateCompleted = dateCompleted;
	}

	/**
	 * @return the pointsEarned
	 */
	private Integer getPointsEarned() {
		return _pointsEarned;
	}

	/**
	 * @param pointsEarned the pointsEarned to set
	 */
	private void setPointsEarned(Integer pointsEarned) {
		_pointsEarned = pointsEarned;
	}

	/**
	 * @return the pointsPossible
	 */
	private Integer getPointsPossible() {
		return _pointsPossible;
	}

	/**
	 * @param pointsPossible the pointsPossible to set
	 */
	private void setPointsPossible(Integer pointsPossible) {
		_pointsPossible = pointsPossible;
	}

	/**
	 * @return the category
	 */
	private Category getCategory() {
		return _category;
	}

	/**
	 * @param category the category to set
	 */
	private void setCategory(Category category) {
		_category = category;
	}

	/**
	 * @return the student
	 */
	private Student getStudent() {
		return _student;
	}

	/**
	 * @param student the student to set
	 */
	private void setStudent(Student student) {
		_student = student;
	}
	
}

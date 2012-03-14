/**
 * 
 */
package ht.model;

import ht.util.SchoolYear;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Models a report card entry.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class ReportCardEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "YEAR_STARTING")
	private Date _yearStarting;
	
	@Column(name = "QUARTER")
	private Integer _quarter;
	
	@JoinColumn(name = "SUBJECT_ID")
	private Subject _topic;
	
	@Column(name = "GRADE")
	private String _grade;
	
	@Column(name = "PROFICIENCY")
	private String _proficiency;
	
	@JoinColumn(name = "STUDENT_ID")
	@OneToOne
	private Student _student;
	
	/**
	 * Creates a default report card entry for the current year and quarter.
	 */
	public ReportCardEntry() {
		setYearStarting(SchoolYear.getStart().getTime());
		setQuarter(SchoolYear.getQuarter(getYearStarting(), new Date()));
		setTopic(null);
		setGrade(null);
		setProficiency(null);
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
	 * @return the yearStarting
	 */
	private Date getYearStarting() {
		return _yearStarting;
	}
	/**
	 * @param yearStarting the yearStarting to set
	 */
	private void setYearStarting(Date yearStarting) {
		_yearStarting = yearStarting;
	}
	/**
	 * @return the quarter
	 */
	private Integer getQuarter() {
		return _quarter;
	}
	/**
	 * @param quarter the quarter to set
	 */
	private void setQuarter(Integer quarter) {
		_quarter = quarter;
	}
	/**
	 * @return the topic
	 */
	private Subject getTopic() {
		return _topic;
	}
	/**
	 * @param topic the topic to set
	 */
	private void setTopic(Subject topic) {
		_topic = topic;
	}

	/**
	 * @return the grade
	 */
	private String getGrade() {
		return _grade;
	}

	/**
	 * @param grade the grade to set
	 */
	private void setGrade(String grade) {
		_grade = grade;
	}

	/**
	 * @return the proficiency
	 */
	private String getProficiency() {
		return _proficiency;
	}

	/**
	 * @param proficiency the proficiency to set
	 */
	private void setProficiency(String proficiency) {
		_proficiency = proficiency;
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

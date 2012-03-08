/**
 * 
 */
package ht.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Models a day to track attendance.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class Day {
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date _date;
	
	@Column(name = "HAD_SCHOOL")
	private Boolean _hadSchool;

	/**
	 * Creates a new Day set to today, with attendance as FALSE.
	 */
	public Day() {
		setDate(new Date());
		setHadSchool(Boolean.FALSE);
	}

	/**
	 * @return the date
	 */
	private Date getDate() {
		return _date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	private void setDate(Date date) {
		_date = date;
	}

	/**
	 * @return the hadSchool
	 */
	private Boolean hadSchool() {
		return _hadSchool;
	}

	/**
	 * @param hadSchool
	 *            the hadSchool to set
	 */
	private void setHadSchool(Boolean hadSchool) {
		_hadSchool = hadSchool;
	}
}

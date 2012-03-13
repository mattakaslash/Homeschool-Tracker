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
	
	@Column(name = "VACATION")
	private Boolean _vacationDay;
	
	@Column(name = "SICK")
	private Boolean _sickDay;
	
	@Column(name = "COOP")
	private Boolean _coopDay;

	/**
	 * Creates a new Day set to today, with attendance as FALSE.
	 */
	public Day() {
		setDate(new Date());
		setHadSchool(Boolean.FALSE);
		setVacationDay(Boolean.FALSE);
		setSickDay(Boolean.FALSE);
		setCoopDay(Boolean.FALSE);
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

	/**
	 * @return the vacationDay
	 */
	private Boolean isVacationDay() {
		return _vacationDay;
	}

	/**
	 * @param vacationDay the vacationDay to set
	 */
	private void setVacationDay(Boolean vacationDay) {
		_vacationDay = vacationDay;
	}

	/**
	 * @return the sickDay
	 */
	private Boolean isSickDay() {
		return _sickDay;
	}

	/**
	 * @param sickDay the sickDay to set
	 */
	private void setSickDay(Boolean sickDay) {
		_sickDay = sickDay;
	}

	/**
	 * @return the coopDay
	 */
	private Boolean isCoopDay() {
		return _coopDay;
	}

	/**
	 * @param coopDay the coopDay to set
	 */
	private void setCoopDay(Boolean coopDay) {
		_coopDay = coopDay;
	}
}

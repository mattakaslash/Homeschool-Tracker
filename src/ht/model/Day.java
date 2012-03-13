/**
 * 
 */
package ht.model;

import ht.HomeschoolTracker;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
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
	/**
	 * Retrieves the requested day from the database and returns it.
	 * 
	 * @param date
	 *            the day of the month
	 * @param month
	 *            the month of the year
	 * @param year
	 *            the year
	 * @return the day
	 */
	public static Day get(Date date) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT d FROM Day d WHERE d._date = :date");
		q.setParameter("date", date, TemporalType.DATE);
		if (q.getResultList().size() == 0) {
			return new Day(date);
		} else {
			return (Day) q.getSingleResult();
		}
	}

	@Column(name = "COOP")
	private Boolean _coopDay;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date _date;

	@Column(name = "HAD_SCHOOL")
	private Boolean _hadSchool;

	@Column(name = "SICK")
	private Boolean _sickDay;

	@Column(name = "VACATION")
	private Boolean _vacationDay;

	/**
	 * Creates a new Day set to today.
	 */
	public Day() {
		setDate(new Date());
		setHadSchool(Boolean.FALSE);
		setVacationDay(Boolean.FALSE);
		setSickDay(Boolean.FALSE);
		setCoopDay(Boolean.FALSE);
	}

	/**
	 * Creates a new Day set to the given date
	 * @param date
	 */
	public Day(Date date) {
		setDate(date);
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
	 * @return the hadSchool
	 */
	private Boolean hadSchool() {
		return _hadSchool;
	}

	/**
	 * @return the coopDay
	 */
	private Boolean isCoopDay() {
		return _coopDay;
	}

	/**
	 * @return the sickDay
	 */
	private Boolean isSickDay() {
		return _sickDay;
	}

	/**
	 * @return the vacationDay
	 */
	private Boolean isVacationDay() {
		return _vacationDay;
	}

	/**
	 * @param coopDay
	 *            the coopDay to set
	 */
	private void setCoopDay(Boolean coopDay) {
		_coopDay = coopDay;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	private void setDate(Date date) {
		_date = date;
	}

	/**
	 * @param hadSchool
	 *            the hadSchool to set
	 */
	private void setHadSchool(Boolean hadSchool) {
		_hadSchool = hadSchool;
	}

	/**
	 * @param sickDay
	 *            the sickDay to set
	 */
	private void setSickDay(Boolean sickDay) {
		_sickDay = sickDay;
	}

	/**
	 * @param vacationDay
	 *            the vacationDay to set
	 */
	private void setVacationDay(Boolean vacationDay) {
		_vacationDay = vacationDay;
	}
}

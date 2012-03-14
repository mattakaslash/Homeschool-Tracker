/**
 * 
 */
package ht.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Provides utilities for managing the school year dates. A school year is
 * considered to start on 1 June and go to 31 May.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class SchoolYear {

	/**
	 * Determines the start of the current school year.
	 * 
	 * @return the date the current school year began
	 */
	public static Calendar getStart() {
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());

		Calendar start = Calendar.getInstance();
		start.set(Calendar.DAY_OF_MONTH, 1);
		start.set(Calendar.MONTH, 5);

		if (start.after(now)) {
			start.set(Calendar.YEAR, start.get(Calendar.YEAR) - 1);
		}

		return start;
	}

	/**
	 * Indicates which quarter of the year the given date falls into.
	 * 
	 * @param yearStarting
	 *            the starting date for the school year in question
	 * @param date
	 *            the date in question
	 * @return 0 for summer session, or the quarter number (1-4), or -1 if the
	 *         date does not fall in the given school year
	 */
	public static Integer getQuarter(Date yearStarting, Date date) {
		Calendar year = Calendar.getInstance();
		year.setTime(yearStarting);

		Calendar ref = Calendar.getInstance();
		ref.setTime(date);

		Calendar quarter1 = Calendar.getInstance();
		quarter1.set(Calendar.DAY_OF_MONTH, 1);
		quarter1.set(Calendar.MONTH, 8);
		quarter1.set(Calendar.YEAR, year.get(Calendar.YEAR));

		Calendar quarter2 = Calendar.getInstance();
		quarter2.set(Calendar.DAY_OF_MONTH, 1);
		quarter2.set(Calendar.MONTH, 10);
		quarter2.set(Calendar.YEAR, year.get(Calendar.YEAR));

		Calendar quarter3 = Calendar.getInstance();
		quarter3.set(Calendar.DAY_OF_MONTH, 16);
		quarter3.set(Calendar.MONTH, 0);
		quarter3.set(Calendar.YEAR, year.get(Calendar.YEAR) + 1);

		Calendar quarter4 = Calendar.getInstance();
		quarter4.set(Calendar.DAY_OF_MONTH, 1);
		quarter4.set(Calendar.MONTH, 3);
		quarter4.set(Calendar.YEAR, year.get(Calendar.YEAR) + 1);

		if (ref.compareTo(year) >= 0 && ref.compareTo(quarter1) < 0) {
			return 0;
		} else if (ref.compareTo(quarter1) >= 0 && ref.compareTo(quarter2) < 0) {
			return 1;
		} else if (ref.compareTo(quarter2) >= 0 && ref.compareTo(quarter3) < 0) {
			return 2;
		} else if (ref.compareTo(quarter3) >= 0 && ref.compareTo(quarter4) < 0) {
			return 3;
		} else if (ref.compareTo(quarter4) >= 0) {
			return 4;
		} else {
			return -1;
		}
	}
}

/**
 * 
 */
package ht.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Models a journal entry.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class JournalEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long _id;
	private Date _introduced;
	private Date _mastered;
	private Concept _topic;
	
	/**
	 * Creates a new blank journal entry for today.
	 */
	public JournalEntry() {
		setIntroduced(new Date());
		setMastered(null);
		setTopic(null);
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
	 * @return the introduced
	 */
	private Date getIntroduced() {
		return _introduced;
	}

	/**
	 * @param introduced the introduced to set
	 */
	private void setIntroduced(Date introduced) {
		_introduced = introduced;
	}

	/**
	 * @return the mastered
	 */
	private Date getMastered() {
		return _mastered;
	}

	/**
	 * @param mastered the mastered to set
	 */
	private void setMastered(Date mastered) {
		_mastered = mastered;
	}

	/**
	 * @return the topic
	 */
	private Concept getTopic() {
		return _topic;
	}

	/**
	 * @param topic the topic to set
	 */
	private void setTopic(Concept topic) {
		_topic = topic;
	}
}

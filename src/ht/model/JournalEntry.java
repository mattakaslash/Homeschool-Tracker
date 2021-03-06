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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Models a journal entry.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class JournalEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "INTRODUCED")
	private Date _introduced;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MASTERED")
	private Date _mastered;
	
	@JoinColumn(name = "TOPIC_ID")
	private Concept _topic;
	
	@JoinColumn(name = "STUDENT_ID")
	@OneToOne
	private Student _student;
	
	/**
	 * Creates a new blank journal entry for today.
	 */
	public JournalEntry() {
		setIntroduced(new Date());
		setMastered(null);
		setTopic(null);
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

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return _student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		_student = student;
	}
}

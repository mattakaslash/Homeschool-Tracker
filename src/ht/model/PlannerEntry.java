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
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Models a planner entry for a given day.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class PlannerEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "WHEN")
	private Date _when;
	
	@JoinColumn(name = "TOPIC_ID")
	private Concept _topic;
	
	@JoinColumn(name = "STUDENT_ID")
	@OneToOne
	private Student _student;
	
	@Lob
	@Column(name = "NOTES")
	private String _notes;
	
	/**
	 * Creates a new planner entry for today and a new, blank concept.
	 */
	public PlannerEntry() {
		setWhen(new Date());
		setTopic(null);
		setStudent(null);
		setNotes("");
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
	 * @return the when
	 */
	private Date getWhen() {
		return _when;
	}
	/**
	 * @param when the when to set
	 */
	private void setWhen(Date when) {
		_when = when;
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
	 * @return the notes
	 */
	private String getNotes() {
		return _notes;
	}
	/**
	 * @param notes the notes to set
	 */
	private void setNotes(String notes) {
		_notes = notes;
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

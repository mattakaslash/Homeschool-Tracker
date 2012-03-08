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
 * Models a reading list entry.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class ReadingListEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Column(name = "TITLE")
	private String _title;
	
	@Column(name = "AUTHOR")
	private String _author;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTED")
	private Date _started;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FINISHED")
	private Date _finished;
	
	@Column(name = "PROGRESS")
	private Integer _progress;
	
	@Column(name = "ASSISTED")
	private Boolean _assisted;

	/**
	 * Creates a default reading list entry.
	 */
	public ReadingListEntry() {
		setTitle("");
		setAuthor("");
		setStarted(new Date());
		setFinished(null);
		setProgress(0);
		setAssisted(Boolean.FALSE);
	}

	/**
	 * @return the id
	 */
	private Long getId() {
		return _id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @return the title
	 */
	private String getTitle() {
		return _title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	private void setTitle(String title) {
		_title = title;
	}

	/**
	 * @return the author
	 */
	private String getAuthor() {
		return _author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	private void setAuthor(String author) {
		_author = author;
	}

	/**
	 * @return the started
	 */
	private Date getStarted() {
		return _started;
	}

	/**
	 * @param started
	 *            the started to set
	 */
	private void setStarted(Date started) {
		_started = started;
	}

	/**
	 * @return the finished
	 */
	private Date getFinished() {
		return _finished;
	}

	/**
	 * @param finished
	 *            the finished to set
	 */
	private void setFinished(Date finished) {
		_finished = finished;
	}

	/**
	 * @return the progress
	 */
	private Integer getProgress() {
		return _progress;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	private void setProgress(Integer progress) {
		_progress = progress;
	}

	/**
	 * @return the assisted
	 */
	private Boolean getAssisted() {
		return _assisted;
	}

	/**
	 * @param assisted
	 *            the assisted to set
	 */
	private void setAssisted(Boolean assisted) {
		_assisted = assisted;
	}
}

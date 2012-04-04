package ht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Stores progress as a "X out of Y" count, where X is completed units and Y is total units.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class Progress {
	/**
	 * Generated.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	/**
	 * Number of completed units.
	 */
	@Column(name = "COMPLETED")
	private Integer _completed;
	
	/**
	 * Total number of units.
	 */
	@Column(name = "TOTAL")
	private Integer _total;
	
	/**
	 * Sets up a new progress with value 0 out of 1.
	 */
	public Progress() {
		setCompleted(0);
		setTotal(1);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return _id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		_id = id;
	}

	/**
	 * @return the completed
	 */
	public Integer getCompleted() {
		return _completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(Integer completed) {
		_completed = completed;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return _total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		_total = total;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getCompleted() + "/" + getTotal();
	}
}

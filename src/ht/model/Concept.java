/**
 * 
 */
package ht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Models a concept within a given Subject.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class Concept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Column(name = "TITLE")
	private String _title;
	
	@JoinColumn(name = "SUBJECT_ID")
	@ManyToOne
	private Subject _parent;
	
	/**
	 * Creates a default, blank concept.
	 */
	public Concept() {
		setTitle("");
		setParent(null);
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
	 * @return the title
	 */
	private String getTitle() {
		return _title;
	}

	/**
	 * @param title the title to set
	 */
	private void setTitle(String title) {
		_title = title;
	}

	/**
	 * @return the parent
	 */
	private Subject getParent() {
		return _parent;
	}

	/**
	 * @param parent the parent to set
	 */
	private void setParent(Subject parent) {
		_parent = parent;
	}
}

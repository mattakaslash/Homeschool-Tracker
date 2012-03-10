/**
 * 
 */
package ht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Defines a category with weight for use with {@link Assignment}s.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;
	
	@Column(name = "TITLE")
	private String _title;
	
	@Column(name = "WEIGHT")
	private Integer _weight;
	
	/**
	 * Defines a new category with no title and a weight of 1.
	 */
	public Category() {
		setTitle("");
		setWeight(1);
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
	 * @return the weight
	 */
	private Integer getWeight() {
		return _weight;
	}

	/**
	 * @param weight the weight to set
	 */
	private void setWeight(Integer weight) {
		_weight = weight;
	}
}

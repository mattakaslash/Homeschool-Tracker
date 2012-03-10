/**
 * 
 */
package ht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Defines a configuration entry.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class ConfigurationEntry {
	@Id
	@Column(name = "NAME")
	private String _name;
	
	@Column(name = "VALUE")
	private String _value;
	
	/**
	 * Creates a new blank configuration entry.
	 */
	public ConfigurationEntry() {
		setName("");
		setValue("");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		_name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return _value;
	}

	/**
	 * @param value the value to set
	 */
	private void setValue(String value) {
		_value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getName() + ": " + getValue();
	}
}

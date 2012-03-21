/**
 * 
 */
package ht.model;

import java.util.List;

import ht.HomeschoolTracker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;

/**
 * Models a classroom subject in a hierarchical model.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
@Entity
public class Subject {
	/**
	 * Returns the requested child subject in the sorted by title list of child
	 * subjects.
	 * 
	 * @param parent
	 *            the parent subject
	 * @param index
	 *            the index
	 * @return the child subject
	 */
	public static Subject get(Subject parent, int index) {
		if (parent == null) {
			EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
			Query q = em.createQuery("SELECT s FROM Subject s WHERE s._id = :id");
			q.setParameter("id", 1);
			Subject result = (Subject) q.getSingleResult();

			em.close();
			return result;
		} else {
			return getAll(parent).get(index);
		}
	}

	/**
	 * Returns a list of all child subjects for the given parent.
	 * 
	 * @param parent
	 *            the parent subject
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static List<Subject> getAll(Subject parent) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT s FROM Subject s JOIN s._parent p WHERE p._id = :id");
		if (parent == null) {
			q.setParameter("id", null);
		} else {
			q.setParameter("id", parent.getId());
		}
		List<Subject> results = q.getResultList();

		em.close();
		return results;
	}

	/**
	 * Returns the root of all subjects.
	 * 
	 * @return the root
	 */
	public static Subject getRoot() {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Query q = em.createQuery("SELECT s FROM Subject s WHERE s._parent._id is null");
		Subject result = (Subject) q.getSingleResult();
		return result;
	}

	/**
	 * Removes the given subject from the database.
	 * 
	 * @param subject the subject
	 */
	public static void remove(Subject subject) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		Subject s = em.merge(subject);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Saves the given subject to the database.
	 * @param subject the subject
	 */
	public static void save(Subject subject) {
		EntityManager em = HomeschoolTracker.getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(subject);
		em.getTransaction().commit();
		em.close();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long _id;

	@JoinColumn(name = "PARENT_ID")
	@ManyToOne
	private Subject _parent;

	@Column(name = "TITLE")
	private String _title;

	/**
	 * Creates a default Subject with no title and no parent.
	 */
	public Subject() {
		setTitle("(no title)");
		setParent(null);
	}

	/**
	 * Creates a new subject with the given title and no parent.
	 * 
	 * @param title
	 *            the title
	 */
	public Subject(String title) {
		setTitle(title);
		setParent(null);
	}

	/**
	 * Creates a new subject with the given title and parent.
	 * 
	 * @param title
	 *            the title
	 * @param parent
	 *            the parent
	 */
	public Subject(String title, Subject parent) {
		setTitle(title);
		setParent(parent);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return _id;
	}

	/**
	 * @return the parent
	 */
	public Subject getParent() {
		return _parent;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return _title;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	private void setId(Long id) {
		_id = id;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	private void setParent(Subject parent) {
		_parent = parent;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		_title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getTitle();
	}
}

package ht.debug;

import ht.model.Assignment;
import ht.model.Category;
import ht.model.Concept;
import ht.model.ConfigurationEntry;
import ht.model.CurriculumLogEntry;
import ht.model.Day;
import ht.model.FieldTrip;
import ht.model.JournalEntry;
import ht.model.PlannerEntry;
import ht.model.ReadingListEntry;
import ht.model.ReportCardEntry;
import ht.model.Student;
import ht.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@SuppressWarnings("javadoc")
public class DatabaseDump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("records").createEntityManager();
		
		System.out.println("Assignment");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Assignment o").getResultList()) {
			System.out.println(((Assignment) o));
		}
		System.out.println();

		System.out.println("Category");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Category o").getResultList()) {
			System.out.println(((Category) o));
		}
		System.out.println();

		System.out.println("Concept");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Concept o").getResultList()) {
			System.out.println(((Concept) o));
		}
		System.out.println();

		System.out.println("ConfigurationEntry");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from ConfigurationEntry o").getResultList()) {
			System.out.println(((ConfigurationEntry) o));
		}
		System.out.println();

		System.out.println("CurriculumLogEntry");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from CurriculumLogEntry o").getResultList()) {
			System.out.println(((CurriculumLogEntry) o));
		}
		System.out.println();

		System.out.println("Category");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Category o").getResultList()) {
			System.out.println(((Category) o));
		}
		System.out.println();

		System.out.println("Day");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Day o").getResultList()) {
			System.out.println(((Day) o));
		}
		System.out.println();

		System.out.println("FieldTrip");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from FieldTrip o").getResultList()) {
			System.out.println(((FieldTrip) o));
		}
		System.out.println();

		System.out.println("JournalEntry");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from JournalEntry o").getResultList()) {
			System.out.println(((JournalEntry) o));
		}
		System.out.println();

		System.out.println("PlannerEntry");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from PlannerEntry o").getResultList()) {
			System.out.println(((PlannerEntry) o));
		}
		System.out.println();

		System.out.println("ReadingListEntry");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from ReadingListEntry o").getResultList()) {
			System.out.println(((ReadingListEntry) o));
		}
		System.out.println();

		System.out.println("ReportCardEntry");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from ReportCardEntry o").getResultList()) {
			System.out.println(((ReportCardEntry) o));
		}
		System.out.println();

		System.out.println("Student");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Student o").getResultList()) {
			System.out.println(((Student) o));
		}
		System.out.println();

		System.out.println("Subject");
		System.out.println("---------------------------------------------------------------------------------------------");
		for (Object o : em.createQuery("select o from Subject o").getResultList()) {
			System.out.println(((Subject) o));
		}
		System.out.println();
	}
}
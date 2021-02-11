package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.business.KanbanBoard;
import jpa.business.Step;
import jpa.business.User;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			test.createKanbanBoardStepsAndUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listSteps();

		manager.close();
		System.out.println(".. done");
	}

	private void createKanbanBoardStepsAndUsers() {
		int numOfSteps = manager.createQuery("Select s From Step as s", Step.class).getResultList().size();
		if (numOfSteps == 0) {
			KanbanBoard kanbanBoard = new KanbanBoard("Java",new User("ESSOH",
					"Jean-Théodore","jean-theodore.essoh@etudiant.univ-rennes1.fr"));
			manager.persist(kanbanBoard);

			manager.persist(new User("Essoh ","Jean-Théodore","jean-theodore1.essoh@etudiant.univ-rennes1.fr"));
			manager.persist(new User("Captaine ","courage", "jean-theodore2.essoh@etudiant.univ-rennes1.fr"));

		}
	}

	private void listSteps() {
		List<Step> resultList = manager.createQuery("Select a From Step as a", Step.class).getResultList();
		System.out.println("num of Steps:" + resultList.size());
		for (Step next : resultList) {
			System.out.println("next step: " + next);
		}
	}
}


package jpa;

import java.security.Timestamp;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.business.*;

public class JpaTest {

	private EntityManager em;

	public JpaTest(EntityManager em) {
		this.em = em;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("mysql");
		EntityManager em = emf.createEntityManager();
		JpaTest test = new JpaTest(em);

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			test.createKanbanBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listOfUsers();

		em.close();
		System.out.println(".. done");
		emf.close();
	}

	private void createKanbanBoard() {
		int cardCmpt = em.createQuery("Select k From kanbanBoard as k", KanbanBoard.class).getResultList().size();
		if (cardCmpt == 0) {
			KanbanBoard kanbanBoard = new KanbanBoard("JavaApi");
			em.persist(kanbanBoard);

			em.persist(new User("Essoh","jean.essoh@etudiant.univ-rennes1.fr "));
			em.persist(new User("Captaine", "capitaine@gmail.com"));
			/*em.persist(new User("Captaine", "capitaine@gmail.com"));*/

			em.persist(new Tag("Index 1"));
			em.persist(new Tag("Index 2"));

			em.persist(new Section("To do"));
			em.persist(new Section("Doing"));
			em.persist(new Section("Done"));

			em.persist(new CardUser(new Date(new java.util.Date().getTime()),new Date(new java.util.Date().getTime())));

			em.persist( new Card("Ajout kanban"));
			System.out.println(new Date(new java.util.Date().getTime()));
			

		}
	}

	private void listOfUsers() {
		List<User> resultList = em.createQuery("Select u From user as u", User.class).getResultList();
		System.out.println("The number of users is:" + resultList.size());
		for (User next : resultList) {
			System.out.println("next step: " + next);
		}
	}
}


package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.IKanbanBoardDao;
import jpa.business.KanbanBoard;
import jpa.business.Section;

import javax.persistence.EntityTransaction;

public class KanbanBoardDaoImpl extends AbstractJpaDao<Long, KanbanBoard> implements IKanbanBoardDao {

    public KanbanBoardDaoImpl() {
        super(KanbanBoard.class);
    }


    @Override
    public void addSection(Long id, Section section) {
        KanbanBoard board = findOne(id);
        section.setKanbanBoard(board);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(section);
        transaction.commit();
    }
}

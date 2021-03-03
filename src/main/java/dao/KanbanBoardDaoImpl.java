package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.IKanbanBoardDao;
import jpa.business.KanbanBoard;

public class KanbanBoardDaoImpl extends AbstractJpaDao<Long, KanbanBoard> implements IKanbanBoardDao {

    public KanbanBoardDaoImpl() {
        super(KanbanBoard.class);
    }


}

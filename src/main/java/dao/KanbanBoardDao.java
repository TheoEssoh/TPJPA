package dao;

import jpa.business.KanbanBoard;

public class KanbanBoardDao extends AbstractJpaDao<Long, KanbanBoard>{

    public KanbanBoardDao() {
        super(KanbanBoard.class);
    }
}

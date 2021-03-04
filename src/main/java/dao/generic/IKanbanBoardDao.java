package dao.generic;

import jpa.business.Section;

public interface IKanbanBoardDao {
    void addSection(Long id, Section section);
}

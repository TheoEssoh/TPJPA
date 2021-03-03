package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.ISectionDao;
import jpa.business.Section;

public class SectionDaoImpl extends AbstractJpaDao<Long, Section> implements ISectionDao {
    public SectionDaoImpl() {
        super(Section.class);
    }
}

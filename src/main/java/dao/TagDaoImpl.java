package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.ITagDao;
import jpa.business.Tag;
import jpa.business.User;
import net.bytebuddy.implementation.bind.annotation.Super;

public class TagDaoImpl extends AbstractJpaDao<Long, Tag> implements ITagDao {

    public TagDaoImpl() {
        super(Tag.class);
    }
}

package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.ICardUserDao;
import jpa.business.CardUser;

public class CardUserDaoImpl extends AbstractJpaDao<Long, CardUser> implements ICardUserDao{
    public CardUserDaoImpl() {
        super(CardUser.class);
    }
}

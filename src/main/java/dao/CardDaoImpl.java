package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.ICardDao;
import jpa.business.Card;

public class CardDaoImpl extends AbstractJpaDao<Long, Card> implements ICardDao{
    public CardDaoImpl(){
        super(Card.class);
    }
}

package dao;

import jpa.business.Card;

public class CardDao extends AbstractJpaDao<Long, Card>{
    public CardDao(){
        super(Card.class);
    }
}

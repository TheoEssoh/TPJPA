package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.ICardDao;
import jpa.business.Card;
import jpa.business.Section;
import jpa.business.User;

public class CardDaoImpl extends AbstractJpaDao<Long, Card> implements ICardDao{
    public CardDaoImpl(){
        super(Card.class);
    }

    @Override
    public Card getCardByUser(User user) {
        return null;
    }

    @Override
    public Card getCardBySection(Section section) {
        return null;
    }

    @Override
    public boolean move(Card card) {
        return false;
    }

    @Override
    public int getTotalNumberOfCards() {
        return 0;
    }

    @Override
    public int getTotalNumberOfCardsBySection() {
        return 0;
    }

    @Override
    public String findCardName(Card card) {
        return null;
    }

    @Override
    public boolean verifCardPresentByName(String label) {
        return false;
    }
}

package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.ICardDao;
import jpa.EntityManagerHelper;
import jpa.business.Card;
import jpa.business.CardUser;
import jpa.business.Section;
import jpa.business.User;

import java.util.List;

public class CardDaoImpl extends AbstractJpaDao<Long, Card> implements ICardDao{
    private Card card = null;
    private Section section = null;
    private boolean presence = false;
    public CardDaoImpl(){
        super(Card.class);
    }

    @Override
    public Card getCardByUser(User user) {

        String query = "SELECT cu FROM cardUser cu   ";

         List<CardUser> cardUsers = EntityManagerHelper.getEntityManager().createQuery(query,CardUser.class).getResultList();

         for (int i=0; i <cardUsers.size();i++){
             if (cardUsers.get(i).getUser().equals(user)){
                 card= cardUsers.get(i).getCard();

             }

         }

         return card;


    }

    @Override
    public Card getCardBySection(Section section) {

        String query = "SELECT c FROM card c   ";

        List<Card> cards = EntityManagerHelper.getEntityManager().createQuery(query,Card.class).getResultList();

        for (int i=0; i <cards.size();i++){

            if (cards.get(i).getSection().equals(section)){
                card= cards.get(i);
            }

        }

        return card;
    }

    /*@Override
    public boolean move(Card card) {
        return false;
    }*/

    @Override
    public int getTotalNumberOfCards() {
        String query = "SELECT c FROM card c   ";
        return EntityManagerHelper.getEntityManager().createQuery(query,Card.class).getResultList().size();
    }

    @Override
    public int getTotalNumberOfCardsBySection(Section section) {

        String query = "SELECT s FROM section s   ";

        List<Section> sections = EntityManagerHelper.getEntityManager().createQuery(query,Section.class).getResultList();

        for (int i=0; i <sections.size();i++){

            if (sections.get(i).equals(section)){
                section= sections.get(i);
            }
        }
        return section.getCards().size();
    }

    @Override
    public String findCardName(Card card) {
        return card.getLabel();
    }

    @Override
    public boolean verifCardPresentByName(String label) {
        String query = "SELECT c FROM card c   ";

        List<Card> cards = EntityManagerHelper.getEntityManager().createQuery(query,Card.class).getResultList();

        for (int i=0; i <cards.size();i++){

            if (cards.get(i).getLabel().equals(label)){
                presence = true;
            }
        }
       ;
        return presence;
    }
}

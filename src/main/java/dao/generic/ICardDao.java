package dao.generic;

import jpa.business.Card;
import jpa.business.Section;
import jpa.business.User;

public interface ICardDao {
    /**
     * Retrieves  card by user
     * @param user whose cards will be get
     * @return card or null on error
     */
    Card getCardByUser(User user);

    /**
     * Retrieves  card by section
     * @param section whose cards will be get
     * @return card or null on error
     */
    Card getCardBySection(Section section);


    /**
     * move card to a new section
     * @param card which will be move
     * @return true on success, false otherwise
     */
   // boolean move(Card card);


    /**
     * get the number of cards
     * @return int number of cards
     */
    int getTotalNumberOfCards() ;


    /**
     * get the number of cards
     * @return int number of cards
     */
    int getTotalNumberOfCardsBySection(Section section) ;

    /**
     * get the label of card
     * @param card whose label will be return
     * @return label or null on error
     */
    String findCardName(Card card);

    /**
     * verify the presence of card by the label
     * @param label whose presence will be verify
     * @return true if present, false otherwise
     */
    boolean verifCardPresentByName(String label);
}

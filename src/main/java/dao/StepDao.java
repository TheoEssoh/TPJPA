package dao;

import jpa.business.Card;
import jpa.business.Step;

public class StepDao extends AbstractJpaDao<Long, Step>{
    public StepDao(Class<Step> clazzToSet) {
        super(clazzToSet);
    }
}

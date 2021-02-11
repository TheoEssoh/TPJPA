package dao;

import jpa.business.Fiche;
import net.bytebuddy.implementation.bind.annotation.Super;

public class FicheDao extends AbstractJpaDao<Long, Fiche>{
    public FicheDao(){
        super(Fiche.class);
    }
}

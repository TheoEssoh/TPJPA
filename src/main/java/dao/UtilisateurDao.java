package dao;

import jpa.business.Utilisateur;

import javax.management.Query;
import java.util.List;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur> {

    public UtilisateurDao() {
        super(Utilisateur.class);
    }

    public List<Utilisateur> getUserWithOwnShip(){
       String query = "select distinct k.owner from KanbanBoard as k ";
       return  this.entityManager.createQuery(query).getResultList();
    }
}

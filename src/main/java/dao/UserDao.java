package dao;

import jpa.business.User;

import java.util.List;

public class UserDao extends AbstractJpaDao<String, User> {

    public UserDao() {
        super(User.class);
    }

    public List<User> getUserWithOwnShip(){
       String query = "select distinct k.owner from KanbanBoard as k ";
       return  this.entityManager.createQuery(query).getResultList();

    }
}

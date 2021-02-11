package dao;

import jpa.EntityManagerHelper;
import jpa.business.User;

import java.util.List;

public class UserDao extends AbstractJpaDao<String, User> {

    public UserDao() {
        super(User.class);
    }

    public List<User> getKanbanOwners(){
        // NamedQuery
       return  EntityManagerHelper.getEntityManager().createNamedQuery("AllKanbanOwners", User.class)
               .getResultList();
    }
    // NamedQuery
    public List<User> getAllUsers() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("AllUsers", User.class)
                .getResultList();
    }

    public List<User> getAllUsersWhoHaveCardS() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("AllUsersWhoHaveCardS", User.class)
                .getResultList();
    }

    public int getTotalNumberOfUsers() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("AllUsers", User.class)
                .getResultList().size();
    }

    public List<User> getAllUsersInStepOne() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("UsersInStepOne", User.class)
                .getResultList();
    }







}

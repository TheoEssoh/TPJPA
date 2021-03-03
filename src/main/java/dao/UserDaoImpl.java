package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.*;
import jpa.EntityManagerHelper;
import jpa.business.User;

import java.util.List;

public class UserDaoImpl extends AbstractJpaDao<Long, User> implements IUserDao {

    public UserDaoImpl() {
        super(User.class);
    }



    public List<User> getKanbanOwners(){
        // NamedQuery
       return  EntityManagerHelper.getEntityManager().createNamedQuery("All Kanban Owners", User.class)
               .getResultList();
    }
    // NamedQuery
    public List<User> getAllUsers() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("All Users", User.class)
                .getResultList();
    }

    public List<User> getAllCardsUsers(){
        return EntityManagerHelper.getEntityManager().createNamedQuery("All Users Who Have CardS", User.class)
                .getResultList();
    }

    public int getTotalNumberOfUsers() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("All Users", User.class)
                .getResultList().size();
    }

/*
    public List<User> getAllUsersInStepOne() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("UsersInStepOne", User.class)
                .getResultList();
    }

    public List<User> getAllUsersInStepTwo() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("UsersInStepTwo", User.class)
                .getResultList();
    }

    public List<User> getAllUsersInStepThree() {
        return EntityManagerHelper.getEntityManager().createNamedQuery("UsersInStepThree", User.class)
                .getResultList();
    }*/








}

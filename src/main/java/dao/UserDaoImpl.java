package dao;

import dao.generic.AbstractJpaDao;
import dao.generic.*;
import jpa.EntityManagerHelper;
import jpa.business.User;

import java.util.List;

public class UserDaoImpl extends AbstractJpaDao<Long, User> implements IUserDao {
    boolean present = false;
    String username = null;

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserByEmail( String email ) {

        String query ="SELECT u FROM user as u WHERE u.email = : email";
        return EntityManagerHelper.getEntityManager().createQuery(query,User.class).getSingleResult();
    }

    @Override
    public boolean removeUserByEmail(String email) {
        delete(getUserByEmail(email));
        return false;
    }

    @Override
    public int getTotalNumberOfUsers() {
        return  EntityManagerHelper.getEntityManager().createNamedQuery("All Users", User.class)
                .getResultList().size();
    }

    @Override
    public String findUsername(User user) {

        List<User> users = EntityManagerHelper.getEntityManager().createNamedQuery("All Users",User.class).
                getResultList();

        for (User userVerif: users)
            if (userVerif.equals(user))  {
                username= userVerif.getName();
            }
        return username;
    }

    @Override
    public boolean verifUserByName(String name) {

        List<User> users = EntityManagerHelper.getEntityManager().createNamedQuery("All Users",User.class).
                getResultList();

        for (User user: users)
            if (user.getName().equals(name))  {
                present= true;
            }

        return present;
    }


/*
    @Override
    public List<User> findByUsername(String username) {

        return null;
    }*/




   /* public List<User> getKanbanOwners(){
        // NamedQuery
       return  EntityManagerHelper.getEntityManager().createNamedQuery("All Kanban Owners", User.class)
               .getResultList();
    }*/
    // NamedQuery
   /* public List<User> getAllUsers() {
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
    }*/

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

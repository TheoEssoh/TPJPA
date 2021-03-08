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


}

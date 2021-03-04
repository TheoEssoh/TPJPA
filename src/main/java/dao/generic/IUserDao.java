package dao.generic;

import jpa.business.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {
    /**
     * Retrieves  participant by email
     * @return users or null on error
     */
    User getUserByEmail(String email);
    /**
     * Reset of the enabled so that the given user is removed from the kanboard
     * @param email whose enabled flag is to be reset
     * @return true on success, false otherwise
     */
    boolean removeUserByEmail(String email);

    /**
     * Reset of the enabled so that the given user is removed from the kanbabboard
     * @param username whose flag is enabled
     * @return true on success, false otherwise
     *//*
    List<User> findByUsername(String username);
*/
    /**
     * get the number of users
     * @return int number of users
     */
    int getTotalNumberOfUsers() ;

    /**
     * get the name of user
     * @param user whose name will be return
     * @return name or null on error
     */
    String findUsername(User user);

    /**
     * verify the presence of user by the name
     * @param name whose presence will be verify
     * @return true if present, false otherwise
     */
    boolean verifUserByName(String name);





}

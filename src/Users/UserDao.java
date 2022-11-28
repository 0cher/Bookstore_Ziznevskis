package Users;

import java.util.List;
public interface UserDao {
    //CRUD //Create, Read, Update, Delete
    List<User> findAll();
    User findById (Long id);
    User findByEmail(String email);
    User createUser (User user);
    void update (Long id, User user);
    boolean delete (Long id);
}


package style.jason.elasticsearchdemo.repository;

import style.jason.elasticsearchdemo.domain.modul.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(String userId);
    User addNewUser(User user);
    Object getAllUserSettings(String username);
    String getUserSetting(String username, String key);
    String addUserSetting(String username, String key, String value);
}

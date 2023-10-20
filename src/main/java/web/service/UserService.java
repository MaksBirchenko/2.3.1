package web.service;

import web.user.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
    public User findUser(Long id);
    List<User> getAllUsers();

}

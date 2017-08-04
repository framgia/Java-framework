package mvs.service;


import mvs.model.User;

public interface UserService {
    void save(User user);
    void saveAndGrantRole(User user);
    User findByUsername(String username);
    User getCurentUser();
}

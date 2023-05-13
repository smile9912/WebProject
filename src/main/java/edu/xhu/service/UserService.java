package edu.xhu.service;

import edu.xhu.pojo.User;


public interface UserService {
    boolean login(String userName, String passWord);
    void register(String userName, String passWord);
    User findUserByUserName(String userName);
    void removeUser(String userName);
    void editUser(User user);
}

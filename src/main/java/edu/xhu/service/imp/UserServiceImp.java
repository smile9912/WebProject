package edu.xhu.service.imp;

import edu.xhu.dao.UserMapper;
import edu.xhu.pojo.User;
import edu.xhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userName, String passWord) {
        User user = userMapper.selectUser(userName, passWord);
        if(user == null) {
            return false;
        }
        return true;
    }

    @Override
    public void register(String userName, String passWord) {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        userMapper.insertUser(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        User user = userMapper.selectByUserName(userName);
        return user;
    }

    @Override
    public void removeUser(String userName) {
        userMapper.deleteUserByUserName(userName);
    }

    @Override
    public void editUser(User user) {
        userMapper.updateUser(user);
    }
}

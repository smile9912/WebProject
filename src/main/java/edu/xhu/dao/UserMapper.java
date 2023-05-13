package edu.xhu.dao;

import edu.xhu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByUserName(String userName);
    User selectUser(String userName, String passWord);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUserByUserName(String userName);
}

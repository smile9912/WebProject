package edu.xhu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.xhu.pojo.User;
import edu.xhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userName, String passWord) {
        if (userService.login(userName, passWord)) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @RequestMapping("/find")
    public String find(String userName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(userService.findUserByUserName(userName));
        return userJson;
    }

    @RequestMapping("/register")
    public void register(String userName, String passWord) {
        userService.register(userName, passWord);
    }

    @RequestMapping("/edit")
    public void edit(@RequestBody User user) {
        userService.editUser(user);
    }

    @RequestMapping("/remove")
    public void remove(String userName) {
        userService.removeUser(userName);
    }
}

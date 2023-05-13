package edu.xhu;

import edu.xhu.dao.ProductMapper;
import edu.xhu.dao.UserMapper;
import edu.xhu.pojo.Product;
import edu.xhu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebBigProjectApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectByUserName("123");
        System.out.println(user);
    }

    @Test
    void fun2() {
        User user = new User();
        user.setUserName("123");
        user.setPassWord("456");
        userMapper.updateUser(user);
    }

    @Test
    void fun3(){
        List<Product> products = productMapper.selectByUserName("123");
        System.out.println(products);
    }

    @Test
    void fun4() {
        Product product = productMapper.selectById("18");
        System.out.println(product);
    }
}

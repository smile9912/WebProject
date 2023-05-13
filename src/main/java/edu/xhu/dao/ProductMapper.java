package edu.xhu.dao;

import edu.xhu.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> selectAllProduct();
    List<Product> selectByProductName(String name);
    List<Product> selectByUserName(String userName);
    void insertProduct(Product product);
    Product selectById(String id);
}

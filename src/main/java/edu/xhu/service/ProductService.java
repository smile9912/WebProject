package edu.xhu.service;

import edu.xhu.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAll();
    List<Product> selectByName(String name);
    List<Product> selectByUserName(String userName);
    void add(String name, String kind, Integer price, String img, String description);
    Product findById(String id);
}

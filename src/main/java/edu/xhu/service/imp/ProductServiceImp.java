package edu.xhu.service.imp;

import edu.xhu.dao.ProductMapper;
import edu.xhu.pojo.Product;
import edu.xhu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAllProduct();
    }

    @Override
    public List<Product> selectByName(String name) {
        return productMapper.selectByProductName(name);
    }

    @Override
    public List<Product> selectByUserName(String userName) {
        return productMapper.selectByUserName(userName);
    }

    @Override
    public void add(String name, String kind, Integer price, String img, String description) {
        Product product = new Product();
        product.setName(name);
        product.setKind(kind);
        product.setPrice(price);
        product.setImg(img);
        product.setDescription(description);
        productMapper.insertProduct(product);
    }

    @Override
    public Product findById(String id) {
        return productMapper.selectById(id);
    }
}

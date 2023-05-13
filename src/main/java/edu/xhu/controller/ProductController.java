package edu.xhu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.xhu.pojo.Product;
import edu.xhu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/selectAll")
    public String selectAll() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = productService.selectAll();
        String productsJson = objectMapper.writeValueAsString(products);
        return productsJson;
    }

    @RequestMapping("/selectByName")
    public String selectByName(String name) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = productService.selectByName(name);
        String productsJson = objectMapper.writeValueAsString(products);
        return productsJson;
    }

    @RequestMapping("/selectByUserName")
    public String selectByUserName(String userName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = productService.selectByUserName(userName);
        String productsJson = objectMapper.writeValueAsString(products);
        return productsJson;
    }

    @RequestMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productService.add(product.getName(), product.getKind(), product.getPrice(), product.getImg(), product.getDescription());
    }

    @RequestMapping("/findById")
    public String findById(String id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = productService.findById(id);
        String productJson = objectMapper.writeValueAsString(product);
        return productJson;
    }
}

package com.ywq.secKill.service;


import com.ywq.secKill.DemoApplication;
import com.ywq.secKill.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void queryAll() {
        List<Product> list = productService.queryAll();
        System.out.println(list);
    }

    @Test
    public void insert() {
        Product product = new Product();
        product.setAmount(10000);
        productService.insert(product);

    }

    @Test
    public void buyOne() {
        int productId = 1;
        int res = productService.buyOne(productId);
    }
}
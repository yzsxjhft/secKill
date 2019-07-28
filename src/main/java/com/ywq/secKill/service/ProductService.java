package com.ywq.secKill.service;

import com.ywq.secKill.entity.Product;
import com.ywq.secKill.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> queryAll() {
        return repository.findAll();
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public int buyOne(int productId) {
        return repository.reduceOne(productId);
    }

}

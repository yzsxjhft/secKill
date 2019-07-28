package com.ywq.secKill.service;

import com.ywq.secKill.entity.Product;
import com.ywq.secKill.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductRepository repository;

    public List<Product> queryAll() {
        return repository.findAll();
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public int buyOne(int productId) {
        int res = repository.reduceOne(productId);
        if (res == 0) logger.info("秒杀失败");
        else logger.info("秒杀成功");
        return res;
    }

}

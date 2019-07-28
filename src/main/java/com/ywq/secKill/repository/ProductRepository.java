package com.ywq.secKill.repository;

import com.ywq.secKill.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Query("update Product set amount = amount - 1 where id = ?1 and amount >= 1")
    int reduceOne(int productId);

}

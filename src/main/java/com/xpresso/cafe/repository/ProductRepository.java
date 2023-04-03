package com.xpresso.cafe.repository;

import com.xpresso.cafe.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{'name': ?0}")
    Optional<Product> findByName(String name);

    @Query("{'id':  ?0}")
    Optional<Product> findById(String id);
}

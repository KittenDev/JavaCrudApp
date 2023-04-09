package com.xpresso.cafe.service;

import com.xpresso.cafe.model.Product;
import com.xpresso.cafe.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@Service
@RequiredArgsConstructor
@ControllerAdvice
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        try {
            productRepository.insert(product);
        } catch (DuplicateKeyException e) {}
    }

    public void updateProduct(Product product) {
        Product savedProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", product.getId())));
        savedProduct.setProductName(product.getProductName());
        savedProduct.setProductPrice(product.getProductPrice());
        savedProduct.setProductAmount(product.getProductAmount());

        productRepository.save(product);
    }

    public List<Product> getProductPartial(String name) {
        return productRepository.findByNamePartial(name);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Product by Id - %s", id)));
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "productName"));
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}

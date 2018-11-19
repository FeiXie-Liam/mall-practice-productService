package com.thoughtworks.demo.service;

import com.thoughtworks.demo.exception.ProductNotFoundException;
import com.thoughtworks.demo.model.Product;
import com.thoughtworks.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product get(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        return product;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void update(Long productId, Product product) {
        Product selectedProduct = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        selectedProduct.updateProduct(product);
        productRepository.save(selectedProduct);
    }

    public void remove(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}

package com.nucleusteq.product.service;



import org.springframework.stereotype.Service;

import com.nucleusteq.product.customexception.ProductNotFoundException;
import com.nucleusteq.product.entity.Product;

import java.util.*;

@Service
public class ProductService {

    private final Map<String, Product> productRepo = new HashMap<>();

    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        productRepo.put(product.getId(), product);
        return product;
    }

    public Product getProduct(String id) {
        Product product = productRepo.get(id);
        if (product == null) throw new ProductNotFoundException(id);
        return product;
    }

    public Product updateProduct(String id, Product updatedProduct) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException(id);
        updatedProduct.setId(id);
        productRepo.put(id, updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(String id) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException(id);
        productRepo.remove(id);
    }

    public Collection<Product> listProducts() {
        return productRepo.values();
    }
}


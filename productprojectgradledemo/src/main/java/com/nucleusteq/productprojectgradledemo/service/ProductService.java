package com.nucleusteq.productprojectgradledemo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nucleusteq.productprojectgradledemo.customexception.ProductNotFoundException;
import com.nucleusteq.productprojectgradledemo.entity.Product;

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



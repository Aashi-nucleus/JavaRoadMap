package com.nucleusteq.product.customexception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Product not found with ID: " + id);
    }
    
    Integer errorCode;
	String errorMessage;
}



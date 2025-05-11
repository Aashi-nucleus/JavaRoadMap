package com.nucleusteq.productprojectgradledemo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class Product {


    private String id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotNull(message = "Price is required")
    private double price;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Product(String id, @NotBlank(message = "Name must not be blank") String name,
            @NotNull(message = "Price is required") double price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }


}


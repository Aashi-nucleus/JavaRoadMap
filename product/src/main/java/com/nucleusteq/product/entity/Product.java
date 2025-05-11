package com.nucleusteq.product.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	
	private String id;
	@NotBlank(message = "Name must not be blank")
	private String name;
	@NotNull(message = "Price is required")
	private double price;

}

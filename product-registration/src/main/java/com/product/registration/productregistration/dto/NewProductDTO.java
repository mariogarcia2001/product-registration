package com.product.registration.productregistration.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewProductDTO {

    @NotNull(message = "Name width can't be null.")  
    private String name;
    @NotNull(message = "Price width can't be null.")  
    private double price;
    private double weight;
    private LocalDate expirationDate;
    private int stock;
    
}

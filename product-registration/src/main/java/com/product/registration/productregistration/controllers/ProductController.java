package com.product.registration.productregistration.controllers;

import java.util.List;

import javax.validation.Valid;

import com.product.registration.productregistration.dto.ProductDTO;
import com.product.registration.productregistration.dto.NewProductDTO;
import com.product.registration.productregistration.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
  
    @Autowired
    public ProductController(ProductService srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody NewProductDTO productDTO){
        ProductDTO result = service.create(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> retrive(@PathVariable("id") Long id){
        ProductDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() 
    public ResponseEntity<List<ProductDTO>> list(){
        List<ProductDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id){
        ProductDTO result = service.update(productDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Product deleted!");        
    }
}



package com.product.registration.productregistration.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import com.product.registration.productregistration.dto.ProductDTO;
import com.product.registration.productregistration.dto.NewProductDTO;
import com.product.registration.productregistration.exceptions.ResourceNotFoundException;
import com.product.registration.productregistration.models.Product;
import com.product.registration.productregistration.repositories.ProductRepository;
import com.product.registration.productregistration.services.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    final ModelMapper modelMapper;
    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(@Autowired ProductRepository repository, ModelMapper mapper){
        this.productRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ProductDTO create(NewProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);        
        return modelMapper.map(product, ProductDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO retrieve(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    @Transactional
    public ProductDTO update(ProductDTO productDTO, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        
        product.setId(id);
        product = modelMapper.map(productDTO, Product.class);
        productRepository.save(product);       

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));        
        productRepository.deleteById(product.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> list() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
            .collect(Collectors.toList());        
    }
    
}



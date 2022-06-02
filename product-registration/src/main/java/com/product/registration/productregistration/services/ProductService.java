package com.product.registration.productregistration.services;

import java.util.List;

import com.product.registration.productregistration.dto.ProductDTO;
import com.product.registration.productregistration.dto.NewProductDTO;

public interface ProductService {
    
    public ProductDTO create(NewProductDTO productDTO);
    public ProductDTO retrieve(Long id);
    public ProductDTO update(ProductDTO productDTO, Long id);
    public void delete(Long id);

    public List<ProductDTO> list();
}


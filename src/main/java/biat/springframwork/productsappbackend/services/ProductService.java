package biat.springframwork.productsappbackend.services;

import biat.springframwork.productsappbackend.web.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto create(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void delete(Long id);

}

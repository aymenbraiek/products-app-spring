package biat.springframwork.productsappbackend.web.controller;

import biat.springframwork.productsappbackend.common.Web;
import biat.springframwork.productsappbackend.domain.Product;
import biat.springframwork.productsappbackend.services.ProductServiceImpl;
import biat.springframwork.productsappbackend.web.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Web.API + "/products")
@RequiredArgsConstructor
public class ProductResource {

    private final  ProductServiceImpl productService;


    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable("id") Long id) {
        return this.productService.findById(id);

    }


    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return this.productService.create(productDto);
    }

    @PutMapping("product/{id}")
    public ProductDto update(@PathVariable Long id,@RequestBody ProductDto productDto)
    {
        return this.productService.updateProduct(id,productDto);
    }
}

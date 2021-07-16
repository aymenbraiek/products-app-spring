package biat.springframwork.productsappbackend.services;

import biat.springframwork.productsappbackend.domain.Product;
import biat.springframwork.productsappbackend.domain.ProductStatus;
import biat.springframwork.productsappbackend.repository.ProductRepository;
import biat.springframwork.productsappbackend.web.controller.NotFoundException;
import biat.springframwork.productsappbackend.web.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;



    public List<ProductDto> findAll() {
         log.debug("Request to all products");
        return this.productRepository.findAll().stream().map(ProductServiceImpl::mapToDto).collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
         log.debug("Resquest to get Products :{}", id);
        return this.productRepository.findById(id).map(ProductServiceImpl::mapToDto).orElse(null);
    }


    public ProductDto create(ProductDto productDto) {
        log.debug("request to create Product:{}", productDto);
        return mapToDto(this.productRepository.save(
                new Product(
                        productDto.getName(),
                        productDto.getPrice(),
                        productDto.getQuantity(),
                        ProductStatus.valueOf((productDto.getStatus())))));


    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        log.debug("update Product{}" + id, "{}" + productDto);
        Product product = productRepository.findById(id).orElseThrow(NotFoundException::new);
        log.info("Product"+product);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setStatus(ProductStatus.valueOf(productDto.getStatus()));

        return mapToDto(this.productRepository.save(product));
    }

    public void delete(Long id) {
        log.debug("Request to delete Product:{}", id);
        this.productRepository.deleteById(id);
    }

    public static ProductDto mapToDto(Product product) {
        if (product != null) {
            return new ProductDto(
                    Math.toIntExact(product.getId()),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getStatus().name()
            );
        }
        return null;
    }

}

package biat.springframwork.productsappbackend.boostrap;

import biat.springframwork.productsappbackend.domain.Product;
import biat.springframwork.productsappbackend.domain.ProductStatus;
import biat.springframwork.productsappbackend.repository.ProductRepository;
import biat.springframwork.productsappbackend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class ProductLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (this.productRepository.count() == 0) {
            LoadProductObject();
        }
    }

    private void LoadProductObject() {
        Product product1 = Product.builder().name("ihpone x").quantity(20).price(new BigDecimal(1.12)).status(ProductStatus.SELECTED)
                .build();
        Product product2 = Product.builder().name("S10").quantity(200).price(new BigDecimal(2.15)).status(ProductStatus.AVAILABLE)
                .build();
        Product product3=Product.builder().name("Ad41").quantity(20).price(new BigDecimal(1.12222)).status(ProductStatus.SELECTED)
                .build();

        this.productRepository.save(product1);
        this.productRepository.save(product2);
        this.productRepository.save(product3);
    }
}

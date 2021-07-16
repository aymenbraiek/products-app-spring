package biat.springframwork.productsappbackend.repository;

import biat.springframwork.productsappbackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

   // Product findProductById(Long id);
}

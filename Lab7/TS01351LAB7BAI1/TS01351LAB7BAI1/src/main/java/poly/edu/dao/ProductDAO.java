package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);
}
package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
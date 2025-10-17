package poly.edu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Product;



public interface ProductDAO extends JpaRepository<Product, Integer> {

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}
package poly.edu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Product;



public interface ProductDAO extends JpaRepository<Product, Integer> {
    
    /**
     * Chú ý: Pageable và Sort là hai đối số cuối cùng để tránh nhầm lẫn với các
     * vị trí tham số trong JPQL (?1, ?2, ...)
     * * @Query: Câu lệnh truy vấn JPQL. 'o' là bí danh cho đối tượng Product.
     * o.name LIKE ?1: Tìm các Product có 'name' chứa chuỗi được truyền vào 
     * tham số đầu tiên của phương thức.
     */
    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);
}
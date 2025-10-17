package poly.edu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductDAO dao; // Tiêm ProductDAO vào để sử dụng

    @RequestMapping("/product/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        // Lấy giá trị min, nếu không có thì dùng giá trị nhỏ nhất của Double
        double minPrice = min.orElse(Double.MIN_VALUE);

        // Lấy giá trị max, nếu không có thì dùng giá trị lớn nhất của Double
        double maxPrice = max.orElse(Double.MAX_VALUE);

        // Gọi phương thức findByPrice từ DAO
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);

        // Đưa danh sách sản phẩm vào model để view có thể đọc được
        model.addAttribute("items", items);

        // Trả về view "search.html" trong thư mục "product"
        return "product/search";
    }
}
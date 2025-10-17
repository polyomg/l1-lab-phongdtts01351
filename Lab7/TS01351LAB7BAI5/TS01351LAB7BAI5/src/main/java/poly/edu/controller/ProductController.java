package poly.edu.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;
import poly.edu.service.SessionService;
@Controller
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    SessionService session;

    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model, 
            @RequestParam("keywords") Optional<String> kw,
            @RequestParam("p") Optional<Integer> p) {
        
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        
        // orElse(0): Nếu p không tồn tại thì lấy giá trị 0
        // 5: Kích thước trang (5 sản phẩm mỗi trang)
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        
        // Thêm '%' để tìm kiếm tương đối (contains)
        Page<Product> page = productDAO.findAllByNameLike("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        
        return "product/search-and-page";
    }
}
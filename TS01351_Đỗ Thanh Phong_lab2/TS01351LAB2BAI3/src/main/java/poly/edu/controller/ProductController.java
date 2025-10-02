package poly.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }
    
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        return "form";
    }
}
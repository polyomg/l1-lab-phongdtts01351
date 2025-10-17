package poly.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    // List to store products
    private List<Product> items = new ArrayList<>(Arrays.asList(
        new Product("A", 1.0),
        new Product("B", 2.0)
    ));

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("product", p); // /*?1*/
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product p, Model model) { // /*?2*/
        // Add the new product to the items list
        items.add(new Product(p.getName(), p.getPrice()));
        return "product/form";
    }

    @ModelAttribute("items") // /*?3*/
    public List<Product> getItems() {
        return items;
    }
}
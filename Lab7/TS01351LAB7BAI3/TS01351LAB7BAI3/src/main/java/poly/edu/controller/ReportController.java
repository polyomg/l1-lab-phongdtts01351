package poly.edu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.dao.ProductRepository;
import poly.edu.dao.Report;



@Controller
public class ReportController {

    @Autowired
    ProductRepository productRepo; 

    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = productRepo.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
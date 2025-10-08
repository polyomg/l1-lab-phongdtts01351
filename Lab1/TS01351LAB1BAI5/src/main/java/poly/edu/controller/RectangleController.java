package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rectangle")
public class RectangleController {

    @GetMapping("/form")
    public String showForm() {
        return "rectangle";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double length,
            @RequestParam double width,
            Model model
    ) {
        if (length <= 0 || width <= 0) {
            model.addAttribute("error", "Chiều dài và chiều rộng phải lớn hơn 0!");
            return "rectangle";
        }
        double area = length * width;
        double perimeter = 2 * (length + width);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);
        return "rectangle";
    }
}
package poly.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {

    @GetMapping("/poly/hello")
    public String sayHello(Model model) {
        model.addAttribute("title", "FPT Polytechnic");
        model.addAttribute("subject", "Spring boot MVC - Đỗ Thanh Phong (TS01351)");
        return "hello.html"; 
    }
}

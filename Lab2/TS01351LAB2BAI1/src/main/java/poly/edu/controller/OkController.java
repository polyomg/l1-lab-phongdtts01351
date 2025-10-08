package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {
    @PostMapping(value="/ok", params = "!x")
    public String m1(Model model) {
        model.addAttribute("result", "m1");
        return "ok";
    }
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("result", "m2");
        return "ok";
    }
    @PostMapping(value="/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("result", "m3");
        return "ok";
    }
}
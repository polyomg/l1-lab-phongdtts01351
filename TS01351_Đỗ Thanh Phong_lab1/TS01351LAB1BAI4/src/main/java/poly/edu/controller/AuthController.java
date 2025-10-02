package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/form")
    public String form() {
        return "login";
    }

    @PostMapping("/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password))
        {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai thông tin đăng nhập!");
        }
        return "login";
    }
}

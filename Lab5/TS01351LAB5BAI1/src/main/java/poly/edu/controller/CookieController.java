package poly.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import poly.edu.cookie.CookieService;

@Controller
public class CookieController {

    @Autowired
    CookieService cookieService;

    @GetMapping("/add-cookie")
    @ResponseBody
    public String addCookie() {
        cookieService.add("username", "Phong", 1); // lưu cookie 1 giờ
        return "Cookie 'username' đã được tạo!";
    }

    @GetMapping("/read-cookie")
    @ResponseBody
    public String readCookie() {
        String value = cookieService.getValue("username", "Không có cookie");
        return "Giá trị cookie username: " + value;
    }

    @GetMapping("/remove-cookie")
    @ResponseBody
    public String removeCookie() {
        cookieService.remove("username");
        return "Cookie 'username' đã bị xóa!";
    }
}
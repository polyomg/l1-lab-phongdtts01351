package poly.edu.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import poly.edu.service.CookieService;
import poly.edu.service.ParamService;
import poly.edu.service.SessionService;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    // Hiển thị form đăng nhập
    @GetMapping("/account/login")
    public String login1() {
        return "account/login"; // trỏ đến login.html
    }

    // Xử lý khi bấm nút Login
    @PostMapping("/account/login")
    @ResponseBody
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        // Kiểm tra tài khoản hợp lệ
        if (un.equals("poly") && pw.equals("123")) {
            sessionService.set("username", un);

            // Nếu remember = true thì lưu cookie 10 ngày
            if (rm) {
                cookieService.add("user", un, 24 * 10); // 10 ngày
            } else {
                cookieService.remove("user");
            }

            return "Đăng nhập thành công! Xin chào " + un;
        } else {
            return "Sai tài khoản hoặc mật khẩu!";
        }
    }
}

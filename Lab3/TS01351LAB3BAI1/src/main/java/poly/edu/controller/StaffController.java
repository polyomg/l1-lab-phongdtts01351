package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.bean.Staff;

import java.util.Date;

@Controller
public class StaffController {

    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .gender(true)
                .birthday(new Date(124, 11, 23)) // 23-12-2024 (năm = 124 vì bắt đầu từ 1900)
                .salary(12345.6789)
                .level(2)
                .photo("anh1.jpg")
                .build();

        model.addAttribute("staff", staff);
        return "/demo/staff-detail";
    }
}

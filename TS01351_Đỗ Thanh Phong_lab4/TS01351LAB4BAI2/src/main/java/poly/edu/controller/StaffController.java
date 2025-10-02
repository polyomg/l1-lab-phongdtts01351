package poly.edu.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.bean.Staff;

@Controller
public class StaffController {

    // Hiển thị form nhập Staff
    @GetMapping("/staff/create")
    public String createForm(Model model) {
        Staff staff = new Staff();
        model.addAttribute("staff", staff);
        return "demo/staff-form"; // view hiển thị form
    }

    // Xử lý khi nhấn Save
    @RequestMapping("/staff/create/save")
    public String createSave(Model model,
                             @RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") Staff staff,
                             Errors errors) {

        // Nếu có upload ảnh thì lấy tên file
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename()); 
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }

        model.addAttribute("staff", staff);
        return "demo/staff-form"; // view hiển thị kết quả
    }
}

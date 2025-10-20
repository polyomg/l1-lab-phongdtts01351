package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.service.MailService;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/mail/send")
    public String send() {
        try {
            mailService.send("do.phong.152007@gmail.com", 
            		"Quân gửi thư", 
            		"<b>Xin chào!</b><br>đỗ thanh phong, ts01351");
            return "Mail của bạn đã được gửi đi";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @ResponseBody
    @RequestMapping("/mail/send-MailerService")
	    public String send2(Model model) {
    	mailService.push("do.phong.152007@gmail.com", "Mail hàng đợi", "<b>Đây là mail gửi nền qua @Scheduled</b>");
        return " Mail của bạn đã được xếp vào hàng đợi!";
    }
}

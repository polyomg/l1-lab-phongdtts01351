package poly.edu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import poly.edu.param.ParamService;

@Controller
public class ParamController {

    @Autowired
    ParamService paramService;

    @GetMapping("/test-param")
    @ResponseBody
    public String testParam() {
        String name = paramService.getString("name", "Chưa nhập");
        int age = paramService.getInt("age", 0);
        double score = paramService.getDouble("score", 0.0);

        return "Tên: " + name + "<br>Tuổi: " + age + "<br>Điểm: " + score;
    }
}
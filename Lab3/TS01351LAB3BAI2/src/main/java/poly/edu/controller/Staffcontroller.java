package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import poly.edu.bean.Staff;

import java.util.Date;
import java.util.List;

@Controller
public class Staffcontroller {
	@RequestMapping("/staff/list")
	public String list(Model model) {
	    List<Staff> list = List.of(
	        Staff.builder().id("user1@gmail.com").fullname("Nguyễn Văn User1").salary(1200.5).photo("avatar1.png").build(),
	        Staff.builder().id("user2@gmail.com").fullname("Nguyễn Văn User2").salary(1500.0).photo("avatar2.png").build(),
	        Staff.builder().id("user3@gmail.com").fullname("Nguyễn Văn User3").salary(1700.25).photo("avatar3.png").build(),
	        Staff.builder().id("user4@gmail.com").fullname("Nguyễn Văn User4").salary(1100.75).photo("avatar4.png").build(),
	        Staff.builder().id("user5@gmail.com").fullname("Nguyễn Văn User5").salary(1600.0).photo("avatar5.png").build(),
	        Staff.builder().id("user6@gmail.com").fullname("Nguyễn Văn User6").salary(2000.0).photo("avatar6.png").build()
	    );
	    model.addAttribute("list", list);
	    return "/demo/staff-list";
	}

}
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.StaffDAO;

@Controller
public class HelloController {
	@Autowired
	 StaffDAO staffDAO;
	@RequestMapping({"/hello","/"})
	public String hello(String username,Model model){	
		model.addAttribute("username",username);
		return "hello";
	}
}

package controller;

import javax.servlet.http.HttpSession;

import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.StaffService;


/**
 * 
 *@Project superedit 
 *@ClassName LoginController
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年11月23日 下午3:15:43
 */
@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	StaffService staffService;
	
	@RequestMapping("/login")
	public String login(HttpSession session){
		
		Staff staff=staffService.get(1);
		session.setAttribute("h_user",staff);
		return "redirect:/proprieter/index";
		
	}
	
}

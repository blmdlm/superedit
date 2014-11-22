package controller;

import model.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.StaffService;
import dao.StaffDAO;

/**
 * 
 * @Project superedit
 * @ClassName ProprieterController
 * @Description 社长角色的控制器
 * @Author gejing gjblmdlm@sina.com
 * @Date 2014年11月22日 下午4:43:01
 */
@Controller
@RequestMapping("/proprieter")
public class ProprieterController {
	@Autowired
	StaffService staffService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "/proprieter/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {

		return "/proprieter/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(String email, int character, String password) {
		Staff staff = new Staff();
		staffService.save(staff);
		return "redirect:/proprieter/index";
	}

}

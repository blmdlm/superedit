package controller;

import javax.servlet.http.HttpServletRequest;

import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.StaffService;
import dao.StaffDAO;
import exception.StaffException;

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
	
	private static Logger logger = Logger.getLogger(ProprieterController.class);
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
	public String add(String email, int role, String password) {
		Staff staff = new Staff();
		staff.setEmail(email);
		//staff.setCharacter(character);
		staff.setPassword(password);
		//staff.setParentid(1);
		
		if (staffService.isExist(staff)) {
			
			throw new StaffException("用户已存在");
		}
		logger.info("staff---logging");
		logger.info(staff);
		staffService.save(staff);
		return "redirect:/proprieter/index";
	}
	
	
//	/**局部异常处理*/
//	@ExceptionHandler(value={StaffException.class})
//	public String handleException(StaffException e,HttpServletRequest req){
//		req.setAttribute("error", e);
//		return "/error";
//		
//	}
//   采用全局配置文件处理异常替换
	
	
	
	
	
	
	
	
	
	

}

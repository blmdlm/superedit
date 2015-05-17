package controller.proprieter;

import javax.servlet.http.HttpSession;

import model.Publisher;
import model.Staff;

import org.apache.log4j.Logger;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MagazineService;
import service.StaffService;

/**
 * 用户中心的控制类
 * @author gejing gjblmdlm@sina.com
 *
 */
@Controller("proprieterusercenter")
@RequestMapping("/proprieter/usercenter")
public class UserCenterController {
	private static Logger logger = Logger.getLogger(UserCenterController.class);
	@Autowired
	StaffService staffService;
	
	/**
	 * 访问查看个人资料页面
	 */
	@RequestMapping("/check")
	public String userCenterCheck( Model model) {	
		return "/proprieter/usercenter/check";
	}

	/**
	 * 访问修改个人资料页面
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String userCenterUpdate(Model model) {
		model.addAttribute("staff", new Staff());
		return "/proprieter/usercenter/update";
	}

	/**
	 * 处理修改资料
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String userCenterUpdate(Staff staff, HttpSession session) {
		Staff currentStaff=(Staff) session.getAttribute("h_user");
		currentStaff=staffService.updateTargetByOther(currentStaff,staff);
		session.setAttribute("h_user", currentStaff);
		return "redirect:/proprieter/usercenter/check";
	}

	
	

	/**
	 * 修改密码界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String userCenterPassword(HttpSession session,Model model) {
		Staff currentStaff=(Staff) session.getAttribute("h_user"); 
		model.addAttribute("staff", new Staff());
		return "/proprieter/usercenter/password";
	}
	
	
	
	/**
	 * 确认原密码
	 */
	@ResponseBody
	@RequestMapping(value = "/checkoldpassword", method = RequestMethod.GET)
	public String[] userCenterCheckoldpassword(HttpSession session,String oldpassword) {
		Staff currentStaff=(Staff) session.getAttribute("h_user");
		if (staffService.confirmPassword(currentStaff, oldpassword)) {
			return new String[]{"1"};
		}else {
			return new String[]{"0"};
		}
		
	}
	
	/**
	 * 处理修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/editPassowrdyet", method = RequestMethod.GET)
	public String[] userCentereditPassowrdyet(HttpSession session,String password,String oldpassword) {
		Staff currentStaff=(Staff) session.getAttribute("h_user");
		if(staffService.confirmPassword(currentStaff,oldpassword)){
			session.setAttribute("h_user", staffService.changePasswordAndUpdate(currentStaff, password));
			return new String[]{"1"};
		}else {
			return new String[]{"0"};
		}
		

		
	}
	
	
	
	
	
	
}

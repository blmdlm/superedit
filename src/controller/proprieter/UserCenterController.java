package controller.proprieter;

import javax.servlet.http.HttpSession;

import model.Publisher;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * 查看个人资料
	 * 
	 * @return
	 */
	@RequestMapping("/check")
	public String userCenterCheck( Model model) {
		
		return "/proprieter/usercenter/check";

	}

	/**
	 * 修改资料界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String userCenterUpdate(Model model) {

		model.addAttribute("staff", new Staff());
		return "/proprieter/usercenter/update";
	}

	/**
	 * 处理修改资料
	 * 
	 * @param staff
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String userCenterUpdate(Staff staff, HttpSession session) {
		Staff currentStaff=(Staff) session.getAttribute("h_user");
		currentStaff.setName(staff.getName());
		currentStaff.setGender(staff.getGender());
		currentStaff.setPhone(staff.getPhone());
		currentStaff.setEmail(staff.getEmail());
		//更新一次
		staffService.update(currentStaff);
		//重新取一次
		staff=staffService.get(currentStaff.getId());
		//刷新session
		session.setAttribute("h_user", staff);
		return "redirect:/proprieter/usercenter/check";
	}

}

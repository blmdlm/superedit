package controller.editor;

import javax.servlet.http.HttpSession;

import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Controller("editorusercenter")
@RequestMapping("/editor/usercenter")
public class UserCenterController {
	private static Logger logger = Logger.getLogger(UserCenterController.class);
	@Autowired
	StaffService staffService;
	@Autowired
	MagazineService magazineService;
	/**
	 * 查看个人资料
	 * 
	 * @return
	 */
	@RequestMapping("/check")
	public String userCenterCheck(HttpSession session, Model model) {
		Staff currentStaff=(Staff) session.getAttribute("k_user"); 
		model.addAttribute("magazine", magazineService.get(currentStaff.getMagazineId()));
		return "/editor/usercenter/check";

	}

	/**
	 * 修改资料界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String userCenterUpdate(HttpSession session,Model model) {
		Staff currentStaff=(Staff) session.getAttribute("k_user"); 
		model.addAttribute("magazine", magazineService.get(currentStaff.getMagazineId()));
		model.addAttribute("staff", new Staff());
		return "/editor/usercenter/update";
	}

	/**
	 * 处理修改资料
	 * 
	 * @param staff
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String userCenterUpdate(Staff staff, HttpSession session) {
		Staff currentStaff=(Staff) session.getAttribute("k_user");
		currentStaff.setName(staff.getName());
		currentStaff.setGender(staff.getGender());
		currentStaff.setPhone(staff.getPhone());
		currentStaff.setEmail(staff.getEmail());
		//更新一次
		staffService.update(currentStaff);
		//重新取一次
		staff=staffService.get(currentStaff.getId());
		//刷新session
		session.setAttribute("k_user", staff);
		return "redirect:/editor/usercenter/check";
	}
	
	
	
	
	
	
	/**
	 * 修改密码界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String userCenterPassword(HttpSession session,Model model) {
		Staff currentStaff=(Staff) session.getAttribute("k_user"); 
		model.addAttribute("staff", new Staff());
		return "/editor/usercenter/password";
	}
	
	
	
	/**
	 * 确认原密码
	 */
	@ResponseBody
	@RequestMapping(value = "/checkoldpassword", method = RequestMethod.GET)
	public String[] userCenterCheckoldpassword(HttpSession session,String oldpassword) {
		Staff currentStaff=(Staff) session.getAttribute("k_user");
		if (currentStaff.getPassword().equals(oldpassword)) {
			return new String[]{"1"};
		}else {
			return new String[]{"0"};
		}
		
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/editPassowrdyet", method = RequestMethod.GET)
	public String[] userCentereditPassowrdyet(HttpSession session,String password,String oldpassword) {
		Staff currentStaff=(Staff) session.getAttribute("k_user");
		if (!currentStaff.getPassword().equals(oldpassword)) {
			return new String[]{"0"};
		}
		currentStaff.setPassword(password);
		//更新一次
		staffService.update(currentStaff);
		//重新取一次
		Staff staff=staffService.get(currentStaff.getId());
		//刷新session
		session.setAttribute("k_user", staff);
		return new String[]{"1"};
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

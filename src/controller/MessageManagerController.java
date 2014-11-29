package controller;

import javax.servlet.http.HttpSession;

import model.Publisher;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.StaffService;

/**
 * 留言管理人员的控制器
 *@Project superedit 
 *@ClassName MessageManagerController
 *@Description TODO
 *@Author gejing gjblmdlm@sina.com
 *@Date 2014年11月29日 下午9:21:15
 */
@Controller
@RequestMapping("/messagemanager")
public class MessageManagerController {
	private static Logger logger = Logger.getLogger(MessageManagerController.class);
	@Autowired
	StaffService staffService;
	
	/**个人首页
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/messagemanager/index";
	}

	/****************************************用户中心 **************************************/

	/**
	 * 用户中心首页
	 * 
	 * @return
	 */
	@RequestMapping("/usercenter")
	public String userCenter() {
		return "/messagemanager/usercenter/index";
	}

	/**
	 * 查看个人资料
	 * 
	 * @return
	 */
	@RequestMapping("/usercenter/check")
	public String userCenterCheck(HttpSession session, Model model) {
		return "/messagemanager/usercenter/check";

	}

	/**
	 * 修改资料界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/usercenter/update", method = RequestMethod.GET)
	public String userCenterUpdate(Model model) {
		model.addAttribute("staff", new Staff());
		return "/messagemanager/usercenter/update";
	}

	/**
	 * 处理修改资料
	 * 
	 * @param staff
	 * @return
	 */
	@RequestMapping(value = "/usercenter/update", method = RequestMethod.POST)
	public String userCenterUpdate(Staff staff, HttpSession session) {
		
		staff.setId(((Staff) session.getAttribute("i_user")).getId());
		Publisher publisher=new Publisher();
		publisher.setId(1);
		staff.setPublisher(publisher);
		//更新一次
		staffService.update(staff);
		//重新取一次
		staff=staffService.get(staff.getId());
		//刷新session
		session.setAttribute("i_user", staff);
		return "redirect:/messagemanager/usercenter/check";
	}
	
	
	
	/****************************************留言管理**************************************************/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

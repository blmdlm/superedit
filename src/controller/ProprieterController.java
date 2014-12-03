package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Publisher;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	/**
	 * 个人首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/proprieter/index";
	}

	/****************************************用户中心 **************************************/

	/**
	 * 用户中心首页
	 * 
	 * @return
	 */
	@RequestMapping("/usercenter")
	public String userCenter() {
		return "/proprieter/usercenter/index";
	}

	/**
	 * 查看个人资料
	 * 
	 * @return
	 */
	@RequestMapping("/usercenter/check")
	public String userCenterCheck(HttpSession session, Model model) {
		return "/proprieter/usercenter/check";

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
		return "/proprieter/usercenter/update";
	}

	/**
	 * 处理修改资料
	 * 
	 * @param staff
	 * @return
	 */
	@RequestMapping(value = "/usercenter/update", method = RequestMethod.POST)
	public String userCenterUpdate(Staff staff, HttpSession session) {
		logger.info("staff"+staff);
		//bug!!!!!!!!!!!!!!
		staff.setId(((Staff) session.getAttribute("h_user")).getId());
		Publisher publisher=new Publisher();
		publisher.setId(1);
		staff.setPublisher(publisher);
		//更新一次
		staffService.update(staff);
		//重新取一次
		staff=staffService.get(staff.getId());
		//刷新session
		session.setAttribute("h_user", staff);
		return "redirect:/proprieter/usercenter/check";
	}

	
	/****************************************用户管理******************************************/
	
	/**
	 * 社长用户管理的首页
	 * @return
	 */
	@RequestMapping("/usermanager")
	public String userManager(){
		return "/proprieter/usermanager/index";
	}
	/**
	 * 访问查看账户页面
	 * @return
	 */
	@RequestMapping("/usermanager/check")
	public String userManagerCheck(HttpSession session,Model model){
		Integer parentid=(((Staff)session.getAttribute("h_user")).getId());
		//获取总编List
		List<Staff> staffs01=staffService.findByParentidAndRole(parentid, 6);
		//获取财务人员List
		List<Staff> staffs02=staffService.findByParentidAndRole(parentid, 9);
		//获取留言管理人员List
		List<Staff> staffs03=staffService.findByParentidAndRole(parentid, 8);
		
		model.addAttribute("staffs01", staffs01);
		model.addAttribute("staffs02", staffs02);
		model.addAttribute("staffs03", staffs03);
		
		return "/proprieter/usermanager/check";
	}
	
	
	
	
	
	

	/**
	 * 访问创建账户的页面
	 * @return
	 */
	@RequestMapping(value = "/usermanager/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("staff",new Staff());
		return "/proprieter/usermanager/create";
	}
	/**
	 * 处理创建账户请求
	 * @param email
	 * @param role
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/usermanager/create", method = RequestMethod.POST)
	public String create(Staff staff,HttpSession session) {
		logger.info(staff);
		staff.setName("new staff");
		staff.setParentid(((Staff)session.getAttribute("h_user")).getId());
		staff.setPublisher(((Staff)session.getAttribute("h_user")).getPublisher());
		if (staffService.isExist(staff)) {
			throw new StaffException("用户已存在");
		}

		staffService.save(staff);
		return "redirect:/proprieter/usermanager/check";
	}
	/**
	 * 访问删除账户页面
	 * @return
	 */
	@RequestMapping(value = "/usermanager/delete")
	public String delete(HttpSession session,Model model){
		Integer parentid=(((Staff)session.getAttribute("h_user")).getId());
		//获取总编List
		List<Staff> staffs01=staffService.findByParentidAndRole(parentid, 6);
		//获取财务人员List
		List<Staff> staffs02=staffService.findByParentidAndRole(parentid, 9);
		//获取留言管理人员List
		List<Staff> staffs03=staffService.findByParentidAndRole(parentid, 8);
		
		model.addAttribute("staffs01", staffs01);
		model.addAttribute("staffs02", staffs02);
		model.addAttribute("staffs03", staffs03);

		
		return "/proprieter/usermanager/delete";
	}
	/**
	 * 处理删除账户请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/usermanager/delete/{id}")
	public String delete(@PathVariable  int id,HttpSession session){
		Staff staff=new Staff();
		staff.setPublisher(((Staff)session.getAttribute("h_user")).getPublisher());
		staff.setId(id);
		staffService.delete(staff);
		
		return "redirect:/proprieter/usermanager/delete";
	}
	
	
	
	
	
	
	
	
	// /**局部异常处理*/
	// @ExceptionHandler(value={StaffException.class})
	// public String handleException(StaffException e,HttpServletRequest req){
	// req.setAttribute("error", e);
	// return "/error";
	//
	// }
	// 采用全局配置文件处理异常替换

}

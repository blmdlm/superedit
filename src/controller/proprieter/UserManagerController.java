package controller.proprieter;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Magazine;
import model.Script;
import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.StaffException;
import service.MagazineService;
import service.StaffService;

/**
 * 账户管理
 * @author gejing gjblmdlm@sina.com
 *
 */
@Controller("proprieterusermanager")
@RequestMapping("/proprieter/usermanager")
public class UserManagerController {
	private static Logger logger = Logger.getLogger(UserManagerController.class);
	@Autowired
	StaffService staffService;
	@Autowired
	MagazineService magazineService;
	
	/**
	 * 访问查看账户页面
	 */
	@RequestMapping("/check")
	public String userManagerCheck(HttpSession session,Model model){
		Staff currentStaff=(Staff)session.getAttribute("h_user");
		
		List<Staff> chiefEditors=staffService.getChiefEditors(currentStaff);
		List<Staff> financials=staffService.getFinancials(currentStaff);
		List<Staff> messageManagers=staffService.getMessageManagers(currentStaff);
		
		model.addAttribute("staffs01", chiefEditors);
		model.addAttribute("staffs02", financials);
		model.addAttribute("staffs03", messageManagers);
		
		return "/proprieter/usermanager/check";
	}
	
	
	
	
	
	

	/**
	 * 访问创建账户的页面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("staff",new Staff());
		return "/proprieter/usermanager/create";
	}
	/**
	 * 处理创建账户请求
	 */
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String[] create(HttpSession session,String email,int role,String password,int magazineid) {
		Staff staff=new Staff();
		staff.setName("new staff");
		staff.setEmail(email);
		staff.setPassword(password);
		staff.setRole(role);
		staff.setLocked(0);
		if (role==6) {
			staff.setMagazineId(magazineid);
		}
		staff.setParentid(((Staff)session.getAttribute("h_user")).getId());
		staff.setPublisher(((Staff)session.getAttribute("h_user")).getPublisher());
		if (staffService.isExist(staff)) {
			return new String[]{"用户已存在"};
		}

		staffService.save(staff);
		return new String[]{"1"};
	}
	/**
	 * 访问删除账户页面
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(HttpSession session,Model model){
		Staff currentStaff=(Staff)session.getAttribute("h_user");
		
		List<Staff> chiefEditors=staffService.getChiefEditors(currentStaff);
		List<Staff> financials=staffService.getFinancials(currentStaff);
		List<Staff> messageManagers=staffService.getMessageManagers(currentStaff);
		
		model.addAttribute("staffs01", chiefEditors);
		model.addAttribute("staffs02", financials);
		model.addAttribute("staffs03", messageManagers);

		return "/proprieter/usermanager/delete";
	}
	/**
	 * 处理删除账户请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable  int id){
		staffService.deleteById(id);
		return "redirect:/proprieter/usermanager/delete";
	}
	
	
	
	/**
	 * 查看该出版社的所有杂志
	 * @param id
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/allmagazines")
	public String[][] allMagazines(HttpSession session){
		Staff currentStaff=(Staff)session.getAttribute("h_user");	
		List<Magazine> magazines=magazineService.getByPublisher(currentStaff.getPublisher());
		return magazineService.listToArray(magazines);

	}
	
}

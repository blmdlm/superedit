package controller.chiefeditor;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Staff;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exception.StaffException;
import service.StaffService;

/**
 * 账户管理
 * @author gejing gjblmdlm@sina.com
 *
 */
@Controller("chiefeditorusermanager")
@RequestMapping("/chiefeditor/usermanager")
public class UserManagerController {
	private static Logger logger = Logger.getLogger(UserManagerController.class);
	@Autowired
	StaffService staffService;
	
	/**
	 * 访问查看账户页面
	 * @return
	 */
	@RequestMapping("/check")
	public String userManagerCheck(HttpSession session,Model model){
		Integer parentid=(((Staff)session.getAttribute("g_user")).getId());
		//获取编辑List
		List<Staff> staffs01=staffService.findByParentidAndRole(parentid, 10);
		//获取审核人员List
		List<Staff> staffs02=staffService.findByParentidAndRole(parentid, 3);
		//获取校对人员List
		List<Staff> staffs03=staffService.findByParentidAndRole(parentid, 5);
		//获取排版人员List
		List<Staff> staffs04=staffService.findByParentidAndRole(parentid, 4);		
		
		
		model.addAttribute("staffs01", staffs01);
		model.addAttribute("staffs02", staffs02);
		model.addAttribute("staffs03", staffs03);
		model.addAttribute("staffs04", staffs04);
		
		return "/chiefeditor/usermanager/check";
	}
	
	
	
	
	
	

	/**
	 * 访问创建账户的页面
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("staff",new Staff());
		return "/chiefeditor/usermanager/create";
	}
	/**
	 * 处理创建账户请求
	 * @param email
	 * @param role
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Staff staff,HttpSession session) {
		logger.info(staff);
		staff.setName("new staff");
		staff.setParentid(((Staff)session.getAttribute("g_user")).getId());
		staff.setPublisher(((Staff)session.getAttribute("g_user")).getPublisher());
		staff.setMagazineId(((Staff)session.getAttribute("g_user")).getMagazineId());
		if (staffService.isExist(staff)) {
			throw new StaffException("用户已存在");
		}

		staffService.save(staff);
		return "redirect:/chiefeditor/usermanager/check";
	}
	/**
	 * 访问删除账户页面
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(HttpSession session,Model model){
		Integer parentid=(((Staff)session.getAttribute("g_user")).getId());
		//获取编辑List
		List<Staff> staffs01=staffService.findByParentidAndRole(parentid, 10);
		//获取审核人员List
		List<Staff> staffs02=staffService.findByParentidAndRole(parentid, 3);
		//获取校对人员List
		List<Staff> staffs03=staffService.findByParentidAndRole(parentid, 5);
		//获取排版人员List
		List<Staff> staffs04=staffService.findByParentidAndRole(parentid, 4);		
		
		model.addAttribute("staffs01", staffs01);
		model.addAttribute("staffs02", staffs02);
		model.addAttribute("staffs03", staffs03);
		model.addAttribute("staffs04", staffs04);

		
		return "/chiefeditor/usermanager/delete";
	}
	/**
	 * 处理删除账户请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable  int id,HttpSession session){
		Staff staff=new Staff();
		staff.setPublisher(((Staff)session.getAttribute("g_user")).getPublisher());
		staff.setId(id);
		staffService.delete(staff);
		
		return "redirect:/chiefeditor/usermanager/delete";
	}
	
	
}
